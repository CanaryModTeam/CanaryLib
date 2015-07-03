package net.canarymod.converter;

import com.google.gson.stream.JsonWriter;
import net.canarymod.Canary;
import net.canarymod.ToolBox;
import net.canarymod.api.PlayerReference;
import net.canarymod.bansystem.Ban;
import net.canarymod.config.Configuration;
import net.canarymod.config.ServerConfiguration;
import net.canarymod.config.WorldConfiguration;
import net.visualillusionsent.utils.PropertiesFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Convert a Canary server into files Vanilla can understand
 *
 * @author Jos Kuijpers
 * @author Jason Jones (darkdiplomat)
 */
public class CanaryToVanilla {

    private static final String path = "vanilla/%s/";

    public boolean convert(String world) {
        File vanillaDir = new File(String.format(path, world));
        return createFolders(vanillaDir, world) &&
                createServerProperties(vanillaDir, world) &&
                createBans(vanillaDir) &&
                createOps(vanillaDir) &&
                createWhitelist();
    }

    private boolean createFolders(File directory, String world) {
        if (!directory.exists() && !directory.mkdirs()) {
            Canary.log.error("Failed to create directory structure for Vanilla conversion.");
            return false;
        }

        File canaryWorld = new File("worlds/" + world);
        if (!canaryWorld.isDirectory() || !canaryWorld.exists()) {
            Canary.log.error("No CanaryMod world found");
            return false;
        }

        File dstFolder = new File(directory, "world/");
        try {
            copyFolder(canaryWorld, dstFolder);
        }
        catch (IOException ioex) {
            Canary.log.error("Failed to migrate world files... ", ioex);
            return false;
        }
        return true;
    }

    private void copyFolder(File src, File dest) throws IOException {
        if (src.isDirectory()) { // Create directories
            // Create the destination if not existent
            if (!dest.exists() && !dest.mkdirs()) {
                throw new IOException("Failed to make destination directory structure");
            }

            // List the files/directories
            String contents[] = src.list();
            // Do a recursive call
            for (String file : contents) {
                copyFolder(new File(src, file), new File(dest, file));
            }
        }
        else { // Copy files
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int length;

            // Read from one, write to the other
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
        }
    }

    private boolean createServerProperties(File directory, String worldName) {
        PropertiesFile props = new PropertiesFile(directory.getAbsolutePath().concat("server.properties"));

        ServerConfiguration server = Configuration.getServerConfig();
        WorldConfiguration world = Configuration.getWorldConfig(worldName);

        props.setBoolean("allow-flight", world.isFlightAllowed());
        props.setBoolean("allow-nether", world.isNetherAllowed());
        props.setInt("difficulty", world.getDifficulty().getId());
        props.setBoolean("enable-query", server.isQueryEnabled());
        props.setBoolean("enable-rcon", server.isRconEnabled());
        props.setInt("gamemode", world.getGameMode().getId());
        props.setBoolean("generate-structures", world.generatesStructures());
        props.setString("level-name", world.getWorldName());
        props.setString("level-seed", world.getWorldSeed());
        props.setString("level-type", world.getWorldType().toString());
        props.setInt("max-build-height", world.getMaxBuildHeight());
        props.setInt("max-players", server.getMaxPlayers());
        props.setString("motd", server.getMotd());
        props.setBoolean("online-mode", server.isOnlineMode());
        props.setBoolean("pvp", world.isPvpEnabled());
        props.setInt("query.port", server.getQueryPort());
        props.setString("rcon.password", server.getRconPassword());
        props.setInt("rcon.port", server.getRconPort());
        props.setString("server-ip", server.getBindIp());
        props.setInt("server-port", server.getPort());
        props.setBoolean("spawn-animals", world.canSpawnAnimals());
        props.setBoolean("spawn-monsters", world.canSpawnMonsters());
        props.setBoolean("spawn-npcs", world.canSpawnVillagers());
        props.setInt("view-distance", server.getViewDistance());
        props.setBoolean("white-list", server.isWhitelistEnabled());

        props.save();
        return true;
    }

    private boolean createBans(File directory) {
        /*

        [
          {
            "uuid": "35fed202-9f93-4d91-b208-93fd903e74e6",
            "name": "theantibukkit",
            "created": "2015-01-06 09:17:55 -0600",
            "source": "Server",
            "expires": "forever",
            "reason": "Banned by an operator."
          }
        ]

        */
        Ban[] bans = Canary.bans().getAllBans();

        Writer banOutput = null;
        Writer ipBanOutput = null;

        try {
            File banFile = new File(directory, "banned-players.json");
            File ipBanFile = new File(directory, "banned-ips.json");

            banFile.createNewFile();
            ipBanFile.createNewFile();

            banOutput = new BufferedWriter(new FileWriter(banFile));
            ipBanOutput = new BufferedWriter(new FileWriter(ipBanFile));

            for (Ban ban : bans) {
                if (ban.isIpBan()) {
                    ipBanOutput.write(ban.getIp() + "\n");
                }
                else {
                    banOutput.write(ban.getSubject() + "\n");
                }
            }

            banOutput.close();
            ipBanOutput.close();
        }
        catch (IOException ioe) {
            try {
                if (banOutput != null) {
                    banOutput.close();
                }
                if (ipBanOutput != null) {
                    ipBanOutput.close();
                }
            }
            catch (IOException ioe2) {
            }
            return false;
        }

        return true;
    }

    private boolean createOps(File directory) {
        boolean failure = false;
        File opsFile = new File(directory, "ops.json");

        JsonWriter writer = null;
        PrintWriter pWriter = null;
        try {
            if (!opsFile.createNewFile()) {
                Canary.log.error("Failed to create a new ops.json");
                return false;
            }

            pWriter = new PrintWriter(opsFile);
            writer = new JsonWriter(pWriter);
            writer.beginArray(); // Master Array start
            pWriter.println();
            for (String op : Canary.ops().getOps()) {
                writer.setIndent("  "); // Indent
                writer.beginObject(); // Operator Object start
                pWriter.println(); // Next line
                writer.setIndent("    "); // Indent
                PlayerReference reference = Canary.getServer().getOfflinePlayer(op);
                writer.name("uuid"); // UUID
                writer.value(ToolBox.isUUID(op) ? op : ToolBox.usernameToUUID(op));
                pWriter.println(); // next line
                writer.name("name");
                writer.value(!ToolBox.isUUID(op) ? op : reference != null ? reference.getName() : "");
                pWriter.println(); // next line
                writer.value("level");
                writer.value(4); // Canary only uses the level 4 op
                pWriter.println(); // next line
                writer.setIndent("  "); // Indent
                writer.endObject(); // Operator Object end
                pWriter.println();
            }
            writer.endArray(); // Master Array end
        }
        catch (Exception ex) {
            Canary.log.error("Failed to convert Ops from database to Vanilla json...", ex);
            failure = true;
        }
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }
            catch (IOException ioex) {
                //IGNORED
            }
            if (pWriter != null) {
                pWriter.close();
            }
        }

        return !failure;
    }

    private boolean createWhitelist() {

        Writer output = null;

        try {
            File opFile = new File("vanilla/white-list.txt");

            opFile.createNewFile();
            output = new BufferedWriter(new FileWriter(opFile));

            // for(String user : getUsersWithPermission("canary.vanilla.op")) {
            // output.write(user + "\n");
            // }

            output.close();
        }
        catch (IOException ioe) {
            if (output != null) {
                try {
                    output.close();
                }
                catch (IOException ioe2) {
                    return false;
                }
            }
            return false;
        }

        return true;
    }
}
