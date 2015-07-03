package net.canarymod.motd;

import net.canarymod.Canary;
import net.canarymod.ToolBox;
import net.canarymod.api.CommandBlockLogic;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.World;
import net.canarymod.api.world.blocks.CommandBlock;
import net.canarymod.chat.MessageReceiver;
import net.visualillusionsent.utils.StringUtils;

import java.lang.management.ManagementFactory;

/**
 * Canary Message Of The Day default variables listener
 *
 * @author Jason (darkdiplomat)
 */
public final class CanaryMessageOfTheDayListener implements MessageOfTheDayListener {

    @MOTDKey(key = "{name}")
    public final String receiverName(MessageReceiver msgrec) {
        return msgrec.getName();
    }

    @MOTDKey(key = "{player.list}")
    public final String playerList(MessageReceiver msgrec) {
        return Canary.getServer().getNumPlayersOnline() > 0 ? StringUtils.joinString(Canary.getServer().getPlayerNameList(), ", ", 0) : "";
    }

    @MOTDKey(key = "{player.count}")
    public final String playerCount(MessageReceiver msgrec) {
        return String.valueOf(Canary.getServer().getNumPlayersOnline());
    }

    @MOTDKey(key = "{player.max}")
    public final String playerMax(MessageReceiver msgrec) {
        return String.valueOf(Canary.getServer().getMaxPlayers());
    }

    @MOTDKey(key = "{group}")
    public final String group(MessageReceiver msgrec) {
        return msgrec instanceof Player ? ((Player)msgrec).getGroup().getName() : "N/A";
    }

    @MOTDKey(key = "{world}")
    public final String world(MessageReceiver msgrec) {
        return msgrec instanceof Player ? ((Player)msgrec).getWorld().getName() : Canary.getServer().getDefaultWorldName();
    }

    @MOTDKey(key = "{world.weather}")
    public final String worldWeather(MessageReceiver msgrec) {
        World world;
        if (msgrec instanceof Player) {
            world = ((Player)msgrec).getWorld();
        }
        else if (msgrec instanceof CommandBlockLogic) {
            world = ((CommandBlockLogic)msgrec).getWorld();
        }
        else {
            world = Canary.getServer().getDefaultWorld();
        }

        if (world.isThundering()) {
            return "thunderstorm";
        }
        else if (world.isRaining()) {
            return "raining";
        }
        else {
            return "sunny";
        }
    }

    @MOTDKey(key = "{world.time.24h}")
    public final String worldTime24h(MessageReceiver msgrec) {
        if (msgrec instanceof CommandBlock) {
            return ToolBox.worldTimeTo24hClock(((CommandBlock)msgrec).getWorld().getRelativeTime());
        }
        else if (msgrec instanceof Player) {
            return ToolBox.worldTimeTo24hClock(((Player)msgrec).getWorld().getRelativeTime());
        }
        else {
            return ToolBox.worldTimeTo24hClock(Canary.getServer().getDefaultWorld().getRelativeTime());
        }
    }

    @MOTDKey(key = "{world.time.12h}")
    public final String worldTime12h(MessageReceiver msgrec) {
        if (msgrec instanceof CommandBlock) {
            return ToolBox.worldTimeTo12hClock(((CommandBlock)msgrec).getWorld().getRelativeTime());
        }
        else if (msgrec instanceof Player) {
            return ToolBox.worldTimeTo12hClock(((Player)msgrec).getWorld().getRelativeTime());
        }
        else {
            return ToolBox.worldTimeTo12hClock(Canary.getServer().getDefaultWorld().getRelativeTime());
        }
    }

    @MOTDKey(key = "{world.time.total}")
    public final String worldTimeTotal(MessageReceiver msgrec) {
        if (msgrec instanceof CommandBlock) {
            return String.valueOf(((CommandBlock)msgrec).getWorld().getTotalTime());
        }
        else if (msgrec instanceof Player) {
            return String.valueOf(((Player)msgrec).getWorld().getTotalTime());
        }
        else {
            return String.valueOf(Canary.getServer().getDefaultWorld().getTotalTime());
        }
    }

    @MOTDKey(key = "{world.time.raw}")
    public final String worldTimeRaw(MessageReceiver msgrec) {
        if (msgrec instanceof CommandBlock) {
            return String.valueOf(((CommandBlock)msgrec).getWorld().getRelativeTime());
        }
        else if (msgrec instanceof Player) {
            return String.valueOf(((Player)msgrec).getWorld().getRelativeTime());
        }
        else {
            return String.valueOf(Canary.getServer().getDefaultWorld().getRelativeTime());
        }
    }

    @MOTDKey(key = "{server.uptime}")
    public final String uptime(MessageReceiver msgrec) {
        return ToolBox.getTimeUntil(ManagementFactory.getRuntimeMXBean().getUptime() / 1000);
    }

    @MOTDKey(key = "{server.tps}")
    public final String tps(MessageReceiver msgrec) {
        return String.valueOf(Canary.getServer().getTicksPerSecond());
    }

    @MOTDKey(key = "{player.first.join}")
    public final String playerFirstJoin(MessageReceiver msgrec) {
        if (msgrec instanceof Player) {
            return ((Player)msgrec).getFirstJoined();
        }
        return "N/A";
    }

    @MOTDKey(key = "{player.time.played}")
    public final String playerTimePlayed(MessageReceiver msgrec) {
        if (msgrec instanceof Player) {
            return ToolBox.getTimeUntil(((Player)msgrec).getTimePlayed());
        }
        return "N/A";
    }

    @MOTDKey(key = "{player.last.join}")
    public final String lastLogin(MessageReceiver msgrec) {
        if (msgrec instanceof Player) {
            return ((Player)msgrec).getLastJoined();
        }
        return "N/A";
    }

    @MOTDKey(key = "{player.last.ip}")
    public final String lastIP(MessageReceiver msgrec) {
        if (msgrec instanceof Player) {
            return ((Player)msgrec).getPreviousIP();
        }
        return "N/A";
    }
}
