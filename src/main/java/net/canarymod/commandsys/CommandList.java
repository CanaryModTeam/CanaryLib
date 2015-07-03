package net.canarymod.commandsys;

import net.canarymod.Canary;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.commands.groupmod.GroupCheck;
import net.canarymod.commandsys.commands.groupmod.GroupCreate;
import net.canarymod.commandsys.commands.groupmod.GroupList;
import net.canarymod.commandsys.commands.groupmod.GroupParent;
import net.canarymod.commandsys.commands.groupmod.GroupPermissionAdd;
import net.canarymod.commandsys.commands.groupmod.GroupPermissionCheck;
import net.canarymod.commandsys.commands.groupmod.GroupPermissionFlush;
import net.canarymod.commandsys.commands.groupmod.GroupPermissionList;
import net.canarymod.commandsys.commands.groupmod.GroupPermissionRemove;
import net.canarymod.commandsys.commands.groupmod.GroupPrefix;
import net.canarymod.commandsys.commands.groupmod.GroupRemove;
import net.canarymod.commandsys.commands.groupmod.GroupRename;
import net.canarymod.commandsys.commands.player.Compass;
import net.canarymod.commandsys.commands.player.GetPosition;
import net.canarymod.commandsys.commands.player.GodCommand;
import net.canarymod.commandsys.commands.playermod.PlayerCreate;
import net.canarymod.commandsys.commands.playermod.PlayerGroupAdd;
import net.canarymod.commandsys.commands.playermod.PlayerGroupCheck;
import net.canarymod.commandsys.commands.playermod.PlayerGroupList;
import net.canarymod.commandsys.commands.playermod.PlayerGroupRemove;
import net.canarymod.commandsys.commands.playermod.PlayerGroupSet;
import net.canarymod.commandsys.commands.playermod.PlayerPermissionAdd;
import net.canarymod.commandsys.commands.playermod.PlayerPermissionCheck;
import net.canarymod.commandsys.commands.playermod.PlayerPermissionList;
import net.canarymod.commandsys.commands.playermod.PlayerPermissionRemove;
import net.canarymod.commandsys.commands.playermod.PlayerPrefix;
import net.canarymod.commandsys.commands.playermod.PlayerRemove;
import net.canarymod.commandsys.commands.playermod.PlayermodBase;
import net.canarymod.commandsys.commands.system.CreateVanilla;
import net.canarymod.commandsys.commands.system.HelpCommand;
import net.canarymod.commandsys.commands.system.Kick;
import net.canarymod.commandsys.commands.system.ListPlugins;
import net.canarymod.commandsys.commands.system.Motd;
import net.canarymod.commandsys.commands.system.Mute;
import net.canarymod.commandsys.commands.system.PlayerInformation;
import net.canarymod.commandsys.commands.system.PlayerList;
import net.canarymod.commandsys.commands.system.PluginCommand;
import net.canarymod.commandsys.commands.system.ReloadCommand;
import net.canarymod.commandsys.commands.system.StopServer;
import net.canarymod.commandsys.commands.system.bans.BanCommand;
import net.canarymod.commandsys.commands.system.bans.IpBanCommand;
import net.canarymod.commandsys.commands.system.bans.UnbanCommand;
import net.canarymod.commandsys.commands.system.informational.CanaryModCommand;
import net.canarymod.commandsys.commands.system.informational.SystemInformation;
import net.canarymod.commandsys.commands.system.informational.Uptime;
import net.canarymod.commandsys.commands.system.kits.KitCreate;
import net.canarymod.commandsys.commands.system.kits.KitDelete;
import net.canarymod.commandsys.commands.system.kits.KitGive;
import net.canarymod.commandsys.commands.system.kits.KitList;
import net.canarymod.commandsys.commands.system.operator.DeOp;
import net.canarymod.commandsys.commands.system.operator.Op;
import net.canarymod.commandsys.commands.system.operator.OpList;
import net.canarymod.commandsys.commands.system.reservelist.ReservelistAdd;
import net.canarymod.commandsys.commands.system.reservelist.ReservelistRemove;
import net.canarymod.commandsys.commands.system.reservelist.ReservelistShow;
import net.canarymod.commandsys.commands.system.whitelist.WhitelistAdd;
import net.canarymod.commandsys.commands.system.whitelist.WhitelistDisable;
import net.canarymod.commandsys.commands.system.whitelist.WhitelistEnable;
import net.canarymod.commandsys.commands.system.whitelist.WhitelistReload;
import net.canarymod.commandsys.commands.system.whitelist.WhitelistRemove;
import net.canarymod.commandsys.commands.system.whitelist.WhitelistShow;
import net.canarymod.commandsys.commands.vanilla.Achievement;
import net.canarymod.commandsys.commands.vanilla.BlockData;
import net.canarymod.commandsys.commands.vanilla.Broadcast;
import net.canarymod.commandsys.commands.vanilla.Clear;
import net.canarymod.commandsys.commands.vanilla.Clone;
import net.canarymod.commandsys.commands.vanilla.Debug;
import net.canarymod.commandsys.commands.vanilla.DefaultGameMode;
import net.canarymod.commandsys.commands.vanilla.DefaultSpawnpoint;
import net.canarymod.commandsys.commands.vanilla.Difficulty;
import net.canarymod.commandsys.commands.vanilla.Effect;
import net.canarymod.commandsys.commands.vanilla.Emote;
import net.canarymod.commandsys.commands.vanilla.Enchant;
import net.canarymod.commandsys.commands.vanilla.EntityData;
import net.canarymod.commandsys.commands.vanilla.Execute;
import net.canarymod.commandsys.commands.vanilla.Fill;
import net.canarymod.commandsys.commands.vanilla.GameMode;
import net.canarymod.commandsys.commands.vanilla.GameRule;
import net.canarymod.commandsys.commands.vanilla.Give;
import net.canarymod.commandsys.commands.vanilla.Kill;
import net.canarymod.commandsys.commands.vanilla.Message;
import net.canarymod.commandsys.commands.vanilla.MessageRaw;
import net.canarymod.commandsys.commands.vanilla.Particle;
import net.canarymod.commandsys.commands.vanilla.PlaySound;
import net.canarymod.commandsys.commands.vanilla.ReplaceItem;
import net.canarymod.commandsys.commands.vanilla.SaveAll;
import net.canarymod.commandsys.commands.vanilla.SaveOff;
import net.canarymod.commandsys.commands.vanilla.SaveOn;
import net.canarymod.commandsys.commands.vanilla.Scoreboard;
import net.canarymod.commandsys.commands.vanilla.SetBlock;
import net.canarymod.commandsys.commands.vanilla.SpawnPoint;
import net.canarymod.commandsys.commands.vanilla.SpreadPlayers;
import net.canarymod.commandsys.commands.vanilla.Stats;
import net.canarymod.commandsys.commands.vanilla.Summon;
import net.canarymod.commandsys.commands.vanilla.Teleport;
import net.canarymod.commandsys.commands.vanilla.TestFor;
import net.canarymod.commandsys.commands.vanilla.TestForBlock;
import net.canarymod.commandsys.commands.vanilla.TestForBlocks;
import net.canarymod.commandsys.commands.vanilla.Time;
import net.canarymod.commandsys.commands.vanilla.Title;
import net.canarymod.commandsys.commands.vanilla.ToggleDownfall;
import net.canarymod.commandsys.commands.vanilla.Trigger;
import net.canarymod.commandsys.commands.vanilla.Weather;
import net.canarymod.commandsys.commands.vanilla.WorldBorder;
import net.canarymod.commandsys.commands.vanilla.XP;
import net.canarymod.commandsys.commands.warp.Home;
import net.canarymod.commandsys.commands.warp.SetHome;
import net.canarymod.commandsys.commands.warp.SpawnCommand;
import net.canarymod.commandsys.commands.warp.WarpList;
import net.canarymod.commandsys.commands.warp.WarpRemove;
import net.canarymod.commandsys.commands.warp.WarpSet;
import net.canarymod.commandsys.commands.warp.WarpUse;
import net.canarymod.commandsys.commands.world.CreateWorldCommand;
import net.canarymod.commandsys.commands.world.DeleteWorldCommand;
import net.canarymod.commandsys.commands.world.ListWorldsCommand;
import net.canarymod.commandsys.commands.world.LoadWorldCommand;
import net.canarymod.commandsys.commands.world.MobClear;
import net.canarymod.commandsys.commands.world.MobCount;
import net.canarymod.commandsys.commands.world.MobSpawnerCheck;
import net.canarymod.commandsys.commands.world.MobSpawnerSet;
import net.canarymod.commandsys.commands.world.UnloadWorldCommand;
import net.canarymod.commandsys.commands.world.WorldInfoCommand;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.canarymod.commandsys.CanaryCommandPermissions.ACHIEVEMENT;
import static net.canarymod.commandsys.CanaryCommandPermissions.BAN;
import static net.canarymod.commandsys.CanaryCommandPermissions.BLOCKDATA;
import static net.canarymod.commandsys.CanaryCommandPermissions.BROADCAST;
import static net.canarymod.commandsys.CanaryCommandPermissions.CANARYMOD;
import static net.canarymod.commandsys.CanaryCommandPermissions.CLEAR;
import static net.canarymod.commandsys.CanaryCommandPermissions.CLONE;
import static net.canarymod.commandsys.CanaryCommandPermissions.COMPASS;
import static net.canarymod.commandsys.CanaryCommandPermissions.CREATEVANILLA;
import static net.canarymod.commandsys.CanaryCommandPermissions.DEBUG;
import static net.canarymod.commandsys.CanaryCommandPermissions.DEFAULTGAMEMODE;
import static net.canarymod.commandsys.CanaryCommandPermissions.DIFFICULTY;
import static net.canarymod.commandsys.CanaryCommandPermissions.EFFECT;
import static net.canarymod.commandsys.CanaryCommandPermissions.EMOTE;
import static net.canarymod.commandsys.CanaryCommandPermissions.ENCHANT;
import static net.canarymod.commandsys.CanaryCommandPermissions.ENTITYDATA;
import static net.canarymod.commandsys.CanaryCommandPermissions.EXECUTE;
import static net.canarymod.commandsys.CanaryCommandPermissions.FILL;
import static net.canarymod.commandsys.CanaryCommandPermissions.GAMEMODE;
import static net.canarymod.commandsys.CanaryCommandPermissions.GAMERULE;
import static net.canarymod.commandsys.CanaryCommandPermissions.GETPOS;
import static net.canarymod.commandsys.CanaryCommandPermissions.GIVE;
import static net.canarymod.commandsys.CanaryCommandPermissions.GOD;
import static net.canarymod.commandsys.CanaryCommandPermissions.GOD$OTHER;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$ADD;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$CHECK;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$LIST;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$PARENT;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$PERMISSIONS;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$PERMISSIONS$ADD;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$PERMISSIONS$CHECK;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$PERMISSIONS$FLUSH;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$PERMISSIONS$LIST;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$PERMISSIONS$REMOVE;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$PREFIX;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$REMOVE;
import static net.canarymod.commandsys.CanaryCommandPermissions.GROUPMOD$RENAME;
import static net.canarymod.commandsys.CanaryCommandPermissions.HELP;
import static net.canarymod.commandsys.CanaryCommandPermissions.HOME;
import static net.canarymod.commandsys.CanaryCommandPermissions.HOME$SET;
import static net.canarymod.commandsys.CanaryCommandPermissions.IPBAN;
import static net.canarymod.commandsys.CanaryCommandPermissions.KICK;
import static net.canarymod.commandsys.CanaryCommandPermissions.KILL;
import static net.canarymod.commandsys.CanaryCommandPermissions.KILL$OTHER;
import static net.canarymod.commandsys.CanaryCommandPermissions.KIT;
import static net.canarymod.commandsys.CanaryCommandPermissions.KIT$CREATE;
import static net.canarymod.commandsys.CanaryCommandPermissions.KIT$DELETE;
import static net.canarymod.commandsys.CanaryCommandPermissions.KIT$OTHER;
import static net.canarymod.commandsys.CanaryCommandPermissions.MESSAGE;
import static net.canarymod.commandsys.CanaryCommandPermissions.MESSAGERAW;
import static net.canarymod.commandsys.CanaryCommandPermissions.MOB;
import static net.canarymod.commandsys.CanaryCommandPermissions.MOB$CLEAR;
import static net.canarymod.commandsys.CanaryCommandPermissions.MOB$COUNT;
import static net.canarymod.commandsys.CanaryCommandPermissions.MOBSPAWNER;
import static net.canarymod.commandsys.CanaryCommandPermissions.MOBSPAWNER$CHECK;
import static net.canarymod.commandsys.CanaryCommandPermissions.MOBSPAWNER$SET;
import static net.canarymod.commandsys.CanaryCommandPermissions.MOTD;
import static net.canarymod.commandsys.CanaryCommandPermissions.MUTE;
import static net.canarymod.commandsys.CanaryCommandPermissions.PARTICLE;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYER$INFO;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYER$LIST;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$ADD;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$GROUP;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$GROUP$ADD;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$GROUP$CHECK;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$GROUP$LIST;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$GROUP$REMOVE;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$GROUP$SET;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$PERMISSIONS;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$PERMISSIONS$ADD;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$PERMISSIONS$CHECK;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$PERMISSIONS$LIST;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$PERMISSIONS$REMOVE;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$PREFIX;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYERMOD$REMOVE;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLAYSOUND;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLUGIN$DISABLE;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLUGIN$ENABLE;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLUGIN$LIST;
import static net.canarymod.commandsys.CanaryCommandPermissions.PLUGIN$RELOAD;
import static net.canarymod.commandsys.CanaryCommandPermissions.RELOAD;
import static net.canarymod.commandsys.CanaryCommandPermissions.REPLACEITEM;
import static net.canarymod.commandsys.CanaryCommandPermissions.RESERVELIST;
import static net.canarymod.commandsys.CanaryCommandPermissions.SAVE$ALL;
import static net.canarymod.commandsys.CanaryCommandPermissions.SAVE$OFF;
import static net.canarymod.commandsys.CanaryCommandPermissions.SAVE$ON;
import static net.canarymod.commandsys.CanaryCommandPermissions.SCOREBOARD;
import static net.canarymod.commandsys.CanaryCommandPermissions.SETBLOCK;
import static net.canarymod.commandsys.CanaryCommandPermissions.SETWORLDSPAWN;
import static net.canarymod.commandsys.CanaryCommandPermissions.SPAWN;
import static net.canarymod.commandsys.CanaryCommandPermissions.SPAWNPOINT;
import static net.canarymod.commandsys.CanaryCommandPermissions.SPREADPLAYERS;
import static net.canarymod.commandsys.CanaryCommandPermissions.STATS;
import static net.canarymod.commandsys.CanaryCommandPermissions.STOP;
import static net.canarymod.commandsys.CanaryCommandPermissions.SUMMON;
import static net.canarymod.commandsys.CanaryCommandPermissions.SYSINFO;
import static net.canarymod.commandsys.CanaryCommandPermissions.TELEPORT;
import static net.canarymod.commandsys.CanaryCommandPermissions.TELEPORT$OTHER;
import static net.canarymod.commandsys.CanaryCommandPermissions.TESTFOR;
import static net.canarymod.commandsys.CanaryCommandPermissions.TESTFORBLOCK;
import static net.canarymod.commandsys.CanaryCommandPermissions.TESTFORBLOCKS;
import static net.canarymod.commandsys.CanaryCommandPermissions.TIME;
import static net.canarymod.commandsys.CanaryCommandPermissions.TITLE;
import static net.canarymod.commandsys.CanaryCommandPermissions.TOGGLEDOWNFALL;
import static net.canarymod.commandsys.CanaryCommandPermissions.TRIGGER;
import static net.canarymod.commandsys.CanaryCommandPermissions.UNBAN;
import static net.canarymod.commandsys.CanaryCommandPermissions.UPTIME;
import static net.canarymod.commandsys.CanaryCommandPermissions.WARP$LIST;
import static net.canarymod.commandsys.CanaryCommandPermissions.WARP$REMOVE;
import static net.canarymod.commandsys.CanaryCommandPermissions.WARP$SET;
import static net.canarymod.commandsys.CanaryCommandPermissions.WARP$USE;
import static net.canarymod.commandsys.CanaryCommandPermissions.WEATHER;
import static net.canarymod.commandsys.CanaryCommandPermissions.WHITELIST;
import static net.canarymod.commandsys.CanaryCommandPermissions.WHITELIST$ADMIN;
import static net.canarymod.commandsys.CanaryCommandPermissions.WORLD;
import static net.canarymod.commandsys.CanaryCommandPermissions.WORLD$CREATE;
import static net.canarymod.commandsys.CanaryCommandPermissions.WORLD$DELETE;
import static net.canarymod.commandsys.CanaryCommandPermissions.WORLD$INFO;
import static net.canarymod.commandsys.CanaryCommandPermissions.WORLD$LIST;
import static net.canarymod.commandsys.CanaryCommandPermissions.WORLD$LOAD;
import static net.canarymod.commandsys.CanaryCommandPermissions.WORLDBORDER;
import static net.canarymod.commandsys.CanaryCommandPermissions.XP;
import static net.canarymod.commandsys.TabCompleteHelper.matchTo;
import static net.canarymod.commandsys.TabCompleteHelper.matchToBannedSubject;
import static net.canarymod.commandsys.TabCompleteHelper.matchToDimension;
import static net.canarymod.commandsys.TabCompleteHelper.matchToGroup;
import static net.canarymod.commandsys.TabCompleteHelper.matchToKitNames;
import static net.canarymod.commandsys.TabCompleteHelper.matchToKnownPlayer;
import static net.canarymod.commandsys.TabCompleteHelper.matchToKnownWorld;
import static net.canarymod.commandsys.TabCompleteHelper.matchToLoadedWorld;
import static net.canarymod.commandsys.TabCompleteHelper.matchToOnlinePlayer;
import static net.canarymod.commandsys.TabCompleteHelper.matchToPlayerPermission;
import static net.canarymod.commandsys.TabCompleteHelper.matchToWarpNames;
import static net.canarymod.commandsys.TabCompleteHelper.matchToWorldType;

/**
 * Canary "native" commands
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 * @author Aaron (somners)
 */
public class CommandList implements CommandListener {
    private final static Map<String, NativeCommand> natives;

    static {
        HashMap<String, NativeCommand> temp = new HashMap<String, NativeCommand>();

        /* groupmod */
        temp.put("groupmod.add", new GroupCreate());
        temp.put("groupmod.perms.add", new GroupPermissionAdd());
        temp.put("groupmod.perms.remove", new GroupPermissionRemove());
        temp.put("groupmod.perms.check", new GroupPermissionCheck());
        temp.put("groupmod.perms.list", new GroupPermissionList());
        temp.put("groupmod.perms.flush", new GroupPermissionFlush());
        temp.put("groupmod.list", new GroupList());
        temp.put("groupmod.remove", new GroupRemove());
        temp.put("groupmod.check", new GroupCheck());
        temp.put("groupmod.rename", new GroupRename());
        temp.put("groupmod.prefix", new GroupPrefix());
        temp.put("groupmod.parent", new GroupParent());

        /* player */
        temp.put("compass", new Compass());
        temp.put("pos", new GetPosition());
        temp.put("god", new GodCommand());

        /* playermod */
        temp.put("playermod", new PlayermodBase());
        temp.put("playermod.add", new PlayerCreate());
        temp.put("playermod.perms.add", new PlayerPermissionAdd());
        temp.put("playermod.perms.remove", new PlayerPermissionRemove());
        temp.put("playermod.perms.check", new PlayerPermissionCheck());
        temp.put("playermod.perms.list", new PlayerPermissionList());
        temp.put("playermod.prefix", new PlayerPrefix());
        temp.put("playermod.remove", new PlayerRemove());
        temp.put("playermod.group.set", new PlayerGroupSet());
        temp.put("playermod.group.add", new PlayerGroupAdd());
        temp.put("playermod.group.list", new PlayerGroupList());
        temp.put("playermod.group.check", new PlayerGroupCheck());
        temp.put("playermod.group.remove", new PlayerGroupRemove());

        /* system.bans */
        temp.put("ban", new BanCommand());
        temp.put("ipban", new IpBanCommand());
        temp.put("unban", new UnbanCommand());

        /* system.informational */
        temp.put("canarymod", new CanaryModCommand());
        temp.put("sysinfo", new SystemInformation());
        temp.put("uptime", new Uptime());

        /* system.kits */
        temp.put("kit.create", new KitCreate());
        temp.put("kit.delete", new KitDelete());
        temp.put("kit.give", new KitGive());
        temp.put("kit.list", new KitList());

        /* system.operator */
        temp.put("deop", new DeOp());
        temp.put("op", new Op());
        temp.put("oplist", new OpList());

        /* system.reservelist */
        temp.put("reservelist.add", new ReservelistAdd());
        temp.put("reservelist.remove", new ReservelistRemove());
        temp.put("reservelist.show", new ReservelistShow());

        /* system.whitelist */
        temp.put("whitelist.add", new WhitelistAdd());
        temp.put("whitelist.remove", new WhitelistRemove());
        temp.put("whitelist.show", new WhitelistShow());
        temp.put("whitelist.enable", new WhitelistEnable());
        temp.put("whitelist.disable", new WhitelistDisable());
        temp.put("whitelist.reload", new WhitelistReload());

        /* system */
        temp.put("createvanilla", new CreateVanilla());

        temp.put("help", new HelpCommand());
        temp.put("kick", new Kick());
        temp.put("listplugins", new ListPlugins());
        temp.put("motd", new Motd());
        temp.put("mute", new Mute());

        temp.put("playerinfo", new PlayerInformation());
        temp.put("playerlist", new PlayerList());
        temp.put("enableplugin", new PluginCommand(false, false));
        temp.put("disableplugin", new PluginCommand(true, false));
        temp.put("reloadplugin", new PluginCommand(false, true));
        temp.put("reload", new ReloadCommand());

        temp.put("stop", new StopServer());

        /* vanilla */
        temp.put("achievement", new Achievement());
        temp.put("blockdata", new BlockData());
        temp.put("broadcast", new Broadcast());
        temp.put("clear", new Clear());
        temp.put("clone", new Clone());
        temp.put("debug", new Debug());
        temp.put("defaultgamemode", new DefaultGameMode());
        temp.put("defaultspawnpoint", new DefaultSpawnpoint());
        temp.put("difficulty", new Difficulty());
        temp.put("effect", new Effect());
        temp.put("emote", new Emote());
        temp.put("enchant", new Enchant());
        temp.put("entitydata", new EntityData());
        temp.put("execute", new Execute());
        temp.put("fill", new Fill());
        temp.put("gamemode", new GameMode());
        temp.put("gamerule", new GameRule());
        temp.put("give", new Give());
        temp.put("kill", new Kill());
        temp.put("message", new Message());
        temp.put("messageraw", new MessageRaw());
        temp.put("particle", new Particle());
        temp.put("playsound", new PlaySound());
        temp.put("replaceitem", new ReplaceItem());
        temp.put("save-all", new SaveAll());
        temp.put("save-off", new SaveOff());
        temp.put("save-on", new SaveOn());
        temp.put("scoreboard", new Scoreboard());
        temp.put("setblock", new SetBlock());
        temp.put("spawnpoint", new SpawnPoint());
        temp.put("spreadplayers", new SpreadPlayers());
        temp.put("stats", new Stats());
        temp.put("summon", new Summon());
        temp.put("teleport", new Teleport());
        temp.put("testfor", new TestFor());
        temp.put("testforblock", new TestForBlock());
        temp.put("testforblocks", new TestForBlocks());
        temp.put("time", new Time());
        temp.put("title", new Title());
        temp.put("toggledownfall", new ToggleDownfall());
        temp.put("trigger", new Trigger());
        temp.put("weather", new Weather());
        temp.put("worldborder", new WorldBorder());
        temp.put("xp", new XP());

        /* warp */
        temp.put("home", new Home());
        temp.put("sethome", new SetHome());
        temp.put("spawn", new SpawnCommand());
        temp.put("listwarps", new WarpList());
        temp.put("delwarp", new WarpRemove());
        temp.put("setwarp", new WarpSet());
        temp.put("warp", new WarpUse());

        /* world */
        temp.put("world.create", new CreateWorldCommand());
        temp.put("world.delete", new DeleteWorldCommand());
        temp.put("world.info", new WorldInfoCommand());
        temp.put("world.list", new ListWorldsCommand());
        temp.put("world.load", new LoadWorldCommand());
        temp.put("world.unload", new UnloadWorldCommand());
        temp.put("mob.clear", new MobClear());
        temp.put("mob.count", new MobCount());
        temp.put("mobspawner.set", new MobSpawnerSet());
        temp.put("mobspawner.check", new MobSpawnerCheck());

        natives = Collections.unmodifiableMap(temp);
    }

    /* groupmod start */
    @Command(
            aliases = { "groupmod", "group" },
            helpLookup = "groupmod",
            description = "groupmod info",
            permissions = { GROUPMOD },
            toolTip = "/groupmod <add|delete|rename|permission|list|prefix> [parameters...]",
            min = 1,
            version = 2
    )
    public void groupBase(MessageReceiver caller, String[] parameters) {
        Canary.help().getHelp(caller, "groupmod");
    }

    @TabComplete(commands = { "groupmod" })
    public List<String> groupBaseTabComplete(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 ? matchTo(parameters, new String[]{ "add", "delete", "rename", "permission", "list", "prefix" }) : null;
    }

    @Command(
            aliases = { "add", "create" },
            parent = "groupmod",
            helpLookup = "groupmod add",
            description = "group add info",
            permissions = { GROUPMOD$ADD },
            toolTip = "/groupmod add <name> [[parent] [world[:dimension]]]",
            min = 1,
            max = 3
    )
    public void groupAdd(MessageReceiver caller, String[] parameters) {
        natives.get("groupmod.add").execute(caller, parameters);
    }

    @TabComplete(commands = { "groupmod add", "groupmod create" })
    public List<String> groupmodAddTabComplete(MessageReceiver caller, String[] parameters) {
        switch (parameters.length) {
            // case 1 would be user submitted and unknown
            case 2:
                return matchToGroup(parameters);
            case 3:
                return matchToKnownWorld(parameters);
            default:
                return null;
        }
    }

    @Command(
            aliases = { "permission", "perms" },
            parent = "groupmod",
            helpLookup = "groupmod permission",
            description = "group permission info",
            permissions = { GROUPMOD$PERMISSIONS },
            toolTip = "/groupmod permission <add|remove|check|list> [arguments...]",
            min = 1,
            version = 2
    )
    public void groupPerms(MessageReceiver caller, String[] parameters) {
        Canary.help().getHelp(caller, "groupmod permission");
    }

    @TabComplete(commands = { "groupmod permission", "groupmod perms" })
    public List<String> groupmodPermissionTabComplete(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 ? matchTo(parameters, new String[]{ "add", "remove", "check", "list" }) : null;
    }

    @Command(
            aliases = { "add" },
            parent = "groupmod.permission",
            helpLookup = "groupmod permission add",
            description = "groupmod permission add info",
            permissions = { GROUPMOD$PERMISSIONS$ADD },
            toolTip = "/groupmod permission add <group> <path>:[value]",
            min = 2
    )
    public void groupPermissionsAdd(MessageReceiver caller, String[] parameters) {
        natives.get("groupmod.perms.add").execute(caller, parameters);
    }

    @Command(
            aliases = { "remove" },
            parent = "groupmod.permission",
            helpLookup = "groupmod permission remove",
            description = "groupmod permission remove info",
            permissions = { GROUPMOD$PERMISSIONS$REMOVE },
            toolTip = "/groupmod permission remove <group> <path>:[value]",
            min = 2
    )
    public void groupPermissionsRemove(MessageReceiver caller, String[] parameters) {
        natives.get("groupmod.perms.remove").execute(caller, parameters);
    }

    @Command(
            aliases = { "check" },
            parent = "groupmod.permission",
            helpLookup = "groupmod permission check",
            description = "groupmod permission check info",
            permissions = { GROUPMOD$PERMISSIONS$CHECK },
            toolTip = "/groupmod permission check <group> <path>:[value]",
            min = 2
    )
    public void groupPermissionsCheck(MessageReceiver caller, String[] parameters) {
        natives.get("groupmod.perms.check").execute(caller, parameters);
    }

    @TabComplete(commands = { "groupmod permission add", "groupmod permission remove", "groupmod permission check" })
    public List<String> groupmodPermissionAddRemoveCheckTabComplete(MessageReceiver caller, String[] parameters) {
        switch (parameters.length) {
            case 1:
                return matchToGroup(parameters);
            case 2:
                if (parameters[1].contains(":")) {
                    String pre = parameters[1].split(":")[0];
                    return matchTo(parameters, new String[]{ pre.concat(":true"), pre.concat(":false") });
                }
        }
        return null;
    }

    @Command(
            aliases = { "list" },
            parent = "groupmod.permission",
            helpLookup = "groupmod permission list",
            description = "groupmod permission list info",
            permissions = { GROUPMOD$PERMISSIONS$LIST },
            toolTip = "/groupmod permission list <group>",
            min = 1
    )
    public void groupPermissionsList(MessageReceiver caller, String[] parameters) {
        natives.get("groupmod.perms.list").execute(caller, parameters);
    }

    @Command(
            aliases = { "flush" },
            parent = "groupmod.permission",
            helpLookup = "groupmod permission flush",
            description = "group permissionflush info",
            permissions = { GROUPMOD$PERMISSIONS$FLUSH },
            toolTip = "/groupmod permission flush <group>",
            min = 1
    )
    public void groupFlush(MessageReceiver caller, String[] parameters) {
        natives.get("groupmod.perms.flush").execute(caller, parameters);
    }

    @Command(
            aliases = { "list", "show" },
            parent = "groupmod",
            helpLookup = "groupmod list",
            description = "group list info",
            permissions = { GROUPMOD$LIST },
            toolTip = "/groupmod list"
    )
    public void groupList(MessageReceiver caller, String[] parameters) {
        natives.get("groupmod.list").execute(caller, parameters);
    }

    @Command(
            aliases = { "remove", "delete" },
            parent = "groupmod",
            helpLookup = "groupmod remove",
            description = "group remove info",
            permissions = { GROUPMOD$REMOVE },
            toolTip = "/groupmod remove <name>",
            min = 1
    )
    public void groupRemove(MessageReceiver caller, String[] parameters) {
        natives.get("groupmod.remove").execute(caller, parameters);
    }

    @Command(
            aliases = { "check", "show" },
            parent = "groupmod",
            helpLookup = "groupmod check",
            description = "group check info",
            permissions = { GROUPMOD$CHECK },
            toolTip = "/groupmod check <name>",
            min = 1
    )
    public void groupCheck(MessageReceiver caller, String[] parameters) {
        natives.get("groupmod.check").execute(caller, parameters);
    }

    @Command(
            aliases = { "rename" },
            parent = "groupmod",
            helpLookup = "groupmod rename",
            description = "group rename info",
            permissions = { GROUPMOD$RENAME },
            toolTip = "/groupmod rename <group> <newname>",
            min = 2
    )
    public void groupRename(MessageReceiver caller, String[] parameters) {
        natives.get("groupmod.rename").execute(caller, parameters);
    }

    @Command(
            aliases = { "prefix" },
            parent = "groupmod",
            helpLookup = "groupmod prefix",
            description = "group prefix info",
            permissions = { GROUPMOD$PREFIX },
            toolTip = "/groupmod prefix <group> <prefix>",
            min = 2
    )
    public void groupPrefix(MessageReceiver caller, String[] parameters) {
        natives.get("groupmod.prefix").execute(caller, parameters);
    }

    @Command(
            aliases = { "parent" },
            parent = "groupmod",
            helpLookup = "groupmod parent",
            description = "group parent info",
            permissions = { GROUPMOD$PARENT },
            toolTip = "/groupmod parent <group> <parent group>",
            min = 2
    )
    public void groupParent(MessageReceiver caller, String[] parameters) {
        natives.get("groupmod.parent").execute(caller, parameters);
    }

    @TabComplete(commands = { "groupmod parent" })
    public List<String> groupmodParentTabComplete(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 || parameters.length == 2 ? matchToGroup(parameters) : null;
    }

    @TabComplete(commands = { "groupmod permissions list", "groupmod permission flush", "groupmod remove", "groupmod check", "groupmod rename", "groupmod prefix" })
    public List<String> matchToGroupTabComplete(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 ? matchToGroup(parameters) : null;
    }
    /* groupmod end */

    /* player */
    @Command(
            aliases = { "compass" },
            description = "compass info",
            permissions = { COMPASS },
            toolTip = "/compass"
    )
    public void compassCommand(MessageReceiver caller, String[] parameters) {
        natives.get("compass").execute(caller, parameters);
    }

    @Command(
            aliases = { "pos", "getpos" },
            description = "getpos info",
            permissions = { GETPOS },
            toolTip = "/getpos"
    )
    public void getPosCommand(MessageReceiver caller, String[] parameters) {
        natives.get("pos").execute(caller, parameters);
    }

    @Command(
            aliases = { "god", "godmode" },
            description = "enable god mode",
            permissions = { GOD, GOD$OTHER },
            toolTip = "/god [playername]",
            version = 2
    )
    public void godCommand(MessageReceiver caller, String[] parameters) {
        natives.get("god").execute(caller, parameters);
    }

    @Command(
            aliases = { "kill", "murder" },
            description = "kill info",
            permissions = { KILL, KILL$OTHER },
            toolTip = "/kill [player:entity]",
            version = 2
    )
    public void killCommand(MessageReceiver caller, String[] parameters) {
        natives.get("kill").execute(caller, parameters);
    }

    /* playermod start */
    @Command(
            aliases = { "playermod", "player" },
            description = "playermod info",
            permissions = { PLAYERMOD },
            toolTip = "/playermod <add|remove|prefix|permission|group> [parameters...]",
            version = 2
    )
    public void playerBase(MessageReceiver caller, String[] parameters) {
        natives.get("playermod").execute(caller, parameters);
    }

    @TabComplete(commands = { "playermod", "player" })
    public List<String> playerBaseTabComplete(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 ? matchTo(parameters, new String[]{ "add", "remove", "prefix", "permission", "group" }) : null;
    }

    @Command(
            aliases = { "add", "create" },
            parent = "playermod",
            helpLookup = "playermod add",
            description = "playermod add info",
            permissions = { PLAYERMOD$ADD },
            toolTip = "/playermod add <name> <group>",
            min = 2
    )
    public void playerAdd(MessageReceiver caller, String[] parameters) {
        natives.get("playermod.add").execute(caller, parameters);
    }

    @TabComplete(commands = { "playermod add" })
    public List<String> playerAddTabComplete(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 ? matchToOnlinePlayer(parameters)
                : parameters.length == 2 ? matchToGroup(parameters)
                : null;
    }

    @Command(
            aliases = { "permission", "perms" },
            parent = "playermod",
            helpLookup = "playermod permission",
            description = "playermod permission info",
            permissions = { PLAYERMOD$PERMISSIONS },
            toolTip = "/playermod permission <add|remove|check|list> [arguments...]",
            version = 2
    )
    public void playerPermissions(MessageReceiver caller, String[] parameters) {
        Canary.help().getHelp(caller, "playermod permission");
    }

    @Command(
            aliases = { "add" },
            parent = "playermod.permission",
            helpLookup = "playermod permission add",
            description = "playermod permission add info",
            permissions = { PLAYERMOD$PERMISSIONS$ADD },
            toolTip = "/playermod permission add <player> <path>:[value]",
            min = 2
    )
    public void playerPermissionsAdd(MessageReceiver caller, String[] parameters) {
        natives.get("playermod.perms.add").execute(caller, parameters);
    }

    @Command(
            aliases = { "remove" },
            parent = "playermod.permission",
            helpLookup = "playermod permission remove",
            description = "playermod permission remove info",
            permissions = { PLAYERMOD$PERMISSIONS$REMOVE },
            toolTip = "/playermod permission remove <player> <path>",
            min = 2
    )
    public void playerPermissionsRemove(MessageReceiver caller, String[] parameters) {
        natives.get("playermod.perms.remove").execute(caller, parameters);
    }

    @TabComplete(commands = { "playermod permission remove" })
    public List<String> playermodPermissionRemove(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 ? matchToKnownPlayer(parameters)
                : parameters.length == 2 ? matchToPlayerPermission(Canary.getServer().matchKnownPlayer(parameters[1]), parameters)
                : null;
    }

    @Command(
            aliases = { "check" },
            parent = "playermod.permission",
            helpLookup = "playermod permission check",
            description = "playermod permission check info",
            permissions = { PLAYERMOD$PERMISSIONS$CHECK },
            toolTip = "/playermod permission check <player> <path>",
            min = 2
    )
    public void playerPermissionsCheck(MessageReceiver caller, String[] parameters) {
        natives.get("playermod.perms.check").execute(caller, parameters);
    }

    @Command(
            aliases = { "list" },
            parent = "playermod.permission",
            helpLookup = "playermod permission list",
            description = "playermod permission list info",
            permissions = { PLAYERMOD$PERMISSIONS$LIST },
            toolTip = "/playermod permission list <player>",
            min = 1
    )
    public void playerPermissionsList(MessageReceiver caller, String[] parameters) {
        natives.get("playermod.perms.list").execute(caller, parameters);
    }

    @TabComplete(commands = { "playermod permission remove" })
    public List<String> playerGroupTabComplete(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 ? matchTo(parameters, new String[]{ "list", "check", "set", "add" }) : null;
    }

    @Command(
            aliases = { "prefix", "color" },
            parent = "playermod",
            helpLookup = "playermod prefix",
            description = "playermod prefix info",
            permissions = { PLAYERMOD$PREFIX },
            toolTip = "/playermod prefix <name> <prefix>",
            min = 2
    )
    public void playerPrefix(MessageReceiver caller, String[] parameters) {
        natives.get("playermod.prefix").execute(caller, parameters);
    }

    @Command(
            aliases = { "remove", "delete" },
            parent = "playermod",
            helpLookup = "playermod remove",
            description = "playermod remove info",
            permissions = { PLAYERMOD$REMOVE },
            toolTip = "/playermod remove <name>",
            min = 1
    )
    public void playerRemove(MessageReceiver caller, String[] parameters) {
        natives.get("playermod.remove").execute(caller, parameters);
    }

    @Command(
            aliases = { "group" },
            parent = "playermod",
            helpLookup = "playermod group",
            description = "playermod group info",
            permissions = { PLAYERMOD$GROUP },
            toolTip = "/playermod group <list|check|set|add> [arguments...]",
            version = 2
    )
    public void playerGroup(MessageReceiver caller, String[] parameters) {
        Canary.help().getHelp(caller, "playermod group");
    }

    @Command(
            aliases = { "set" },
            parent = "playermod.group",
            helpLookup = "playermod group set",
            description = "playermod group set info",
            permissions = { PLAYERMOD$GROUP$SET },
            toolTip = "/playermod group set <player> <group>",
            min = 2
    )
    public void playerGroupSet(MessageReceiver caller, String[] parameters) {
        natives.get("playermod.group.set").execute(caller, parameters);
    }

    @Command(
            aliases = { "add" },
            parent = "playermod.group",
            helpLookup = "playermod group add",
            description = "playermod group add info",
            permissions = { PLAYERMOD$GROUP$ADD },
            toolTip = "/playermod group add <player> <group>",
            min = 2
    )
    public void playerGroupAdd(MessageReceiver caller, String[] parameters) {
        natives.get("playermod.group.add").execute(caller, parameters);
    }

    @Command(
            aliases = { "list" },
            parent = "playermod.group",
            helpLookup = "playermod group list",
            description = "playermod group list info",
            permissions = { PLAYERMOD$GROUP$LIST },
            toolTip = "/playermod group list <player>",
            min = 1
    )
    public void playerGroupList(MessageReceiver caller, String[] parameters) {
        natives.get("playermod.group.list").execute(caller, parameters);
    }

    @Command(
            aliases = { "check" },
            parent = "playermod.group",
            helpLookup = "playermod group check",
            description = "playermod group check info",
            permissions = { PLAYERMOD$GROUP$CHECK },
            toolTip = "/playermod group check <player> <group>",
            min = 2
    )
    public void playerGroupCheck(MessageReceiver caller, String[] parameters) {
        natives.get("playermod.group.check").execute(caller, parameters);
    }

    @Command(
            aliases = { "remove" },
            parent = "playermod.group",
            helpLookup = "playermod group remove",
            description = "playermod group remove info",
            permissions = { PLAYERMOD$GROUP$REMOVE },
            toolTip = "/playermod group remove <player> <group>",
            min = 2
    )
    public void playerGroupRemove(MessageReceiver caller, String[] parameters) {
        natives.get("playermod.group.remove").execute(caller, parameters);
    }

    @TabComplete(commands = { "playermod group add", "playermod group remove", "playermod group set" })
    public List<String> playermodGroupAddRemoveSet(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 ? matchToKnownPlayer(parameters)
                : parameters.length == 2 ? matchToGroup(parameters)
                : null;
    }
    /* playermod end */

    /* system */
    @Command(
            aliases = { "ban" },
            description = "ban info",
            permissions = { BAN },
            toolTip = "/ban <player> [reason] [#number hour|day|week|month]",
            min = 1,
            version = 2
    )
    public void banCommand(MessageReceiver caller, String[] parameters) {
        natives.get("ban").execute(caller, parameters);
    }

    @TabComplete(commands = { "ban" })
    public List<String> banTabComplete(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 ? matchToKnownPlayer(parameters)
                : parameters.length >= 2 && parameters[parameters.length - 2].matches("\\d+") ? matchTo(parameters, new String[]{ "hour", "day", "week", "month" })
                : null;
    }

    @Command(
            aliases = { "canarymod", "version" },
            description = "CanaryMod Information",
            permissions = { CANARYMOD },
            toolTip = "/canarymod"
    )
    public void canarymodInfoCommand(MessageReceiver caller, String[] parameters) {
        natives.get("canarymod").execute(caller, parameters);
    }

    @Command(
            aliases = { "createvanilla", "makevanilla" },
            description = "makevanilla info",
            permissions = { CREATEVANILLA },
            toolTip = "/createvanilla <defaultworld>",
            min = 1,
            version = 2
    )
    public void createVanillaCommand(MessageReceiver caller, String[] parameters) {
        natives.get("createvanilla").execute(caller, parameters);
    }

    @Command(
            aliases = { "deop" },
            description = "Takes Op from a Player",
            permissions = { "canary.command.deop" }, // Really no point, Requires Op
            toolTip = "/deop <player>",
            min = 1,
            version = 2
    )
    public void deop(MessageReceiver caller, String[] args) {
        natives.get("deop").execute(caller, args);
    }

    @TabComplete(commands = { "deop" })
    public List<String> deopTabComplete(MessageReceiver caller, String[] args) {
        return args.length == 1 ? matchTo(args, Canary.ops().getOps()) : null;
    }

    @Command(
            aliases = { "help", "?" },
            description = "help info",
            permissions = { HELP },
            toolTip = "/help [search terms] [page]"
    )
    public void helpCommand(MessageReceiver caller, String[] parameters) {
        natives.get("help").execute(caller, parameters);
    }

    @Command(
            aliases = { "ipban" },
            description = "ipban info",
            permissions = { IPBAN },
            toolTip = "/ipban <player> [reason] [#number hour|day|week|month]",
            min = 1,
            version = 2
    )
    public void ipBanCommand(MessageReceiver caller, String[] parameters) {
        natives.get("ipban").execute(caller, parameters);
    }

    @Command(
            aliases = { "kick" },
            description = "kick info",
            permissions = { KICK },
            toolTip = "/kick <playername> [reason]",
            min = 1,
            version = 2
    )
    public void kickCommand(MessageReceiver caller, String[] parameters) {
        natives.get("kick").execute(caller, parameters);
    }

    @Command(
            aliases = { "kit" },
            description = "kit info",
            permissions = { KIT },
            toolTip = "/kit < give <name> [player] | create <name> <use delay> [G <groups> | P <players>] | delete <name> | list > ",
            version = 2
    )
    public void kitCommand(MessageReceiver caller, String[] parameters) {
        Canary.help().getHelp(caller, "kit");
    }

    @Command(
            aliases = { "create" },
            parent = "kit",
            description = "kit create",
            helpLookup = "kit create",
            permissions = { KIT$CREATE },
            toolTip = "/kit create <name> <use delay> [G|P Groups|Players]",
            min = 2
    )
    public void kitCreateCommand(MessageReceiver caller, String[] parameters) {
        natives.get("kit.create").execute(caller, parameters);
    }

    @Command(
            aliases = { "give" },
            parent = "kit",
            description = "kit give",
            helpLookup = "kit give",
            permissions = { KIT },
            toolTip = "/kit give <name> [player]",
            min = 1
    )
    public void kitGiveCommand(MessageReceiver caller, String[] parameters) {
        natives.get("kit.give").execute(caller, parameters);
    }

    @Command(
            aliases = { "list" },
            parent = "kit",
            description = "kit list",
            helpLookup = "kit list",
            permissions = { KIT },
            toolTip = "/kit list"
    )
    public void kitListCommand(MessageReceiver caller, String[] parameters) {
        natives.get("kit.list").execute(caller, parameters);
    }

    @Command(
            aliases = { "delete" },
            parent = "kit",
            description = "kit delete",
            helpLookup = "kit delete",
            permissions = { KIT$DELETE },
            toolTip = "/kit delete <kitName>",
            min = 1
    )
    public void kitDeleteCommand(MessageReceiver caller, String[] parameters) {
        natives.get("kit.delete").execute(caller, parameters);
    }

    @TabComplete(commands = { "kit" })
    public List<String> kitTabComplete(MessageReceiver caller, String[] parameters) {
        switch (parameters.length) {
            case 1:
                return matchTo(parameters, new String[]{ "create", "delete", "give", "list" });
            case 2:
                if (parameters[0].matches("(?i)(give|delete)")) {
                    return matchToKitNames(parameters, caller);
                }
            case 3:
                if (parameters[0].equals("give") && caller.hasPermission(KIT$OTHER)) {
                    return matchToOnlinePlayer(parameters);
                }
            default:
                return null;
        }
    }

    @Command(
            aliases = { "listplugins", "plugins" },
            description = "lplugin info",
            permissions = { PLUGIN$LIST },
            toolTip = "/listplugins"
    )
    public void listPluginsCommand(MessageReceiver caller, String[] parameters) {
        natives.get("listplugins").execute(caller, parameters);
    }

    @Command(
            aliases = { "motd" },
            description = "motd info",
            permissions = { MOTD },
            toolTip = "/motd"
    )
    public void motdCommand(MessageReceiver caller, String[] parameters) {
        natives.get("motd").execute(caller, parameters);
    }

    @Command(
            aliases = { "mute", "stfu" },
            description = "mute info",
            permissions = { MUTE },
            toolTip = "/mute <playername>",
            min = 1,
            version = 2
    )
    public void muteCommand(MessageReceiver caller, String[] parameters) {
        natives.get("mute").execute(caller, parameters);
    }

    @Command(
            aliases = { "op" },
            description = "Give Op to a Player",
            permissions = { "canary.command.op" }, // Really no point, Requires Op
            toolTip = "/op <player>",
            min = 1,
            version = 2
    )
    public void op(MessageReceiver caller, String[] args) {
        natives.get("op").execute(caller, args);
    }

    @Command(
            aliases = { "oplist" },
            description = "Displays a list of Operators",
            permissions = { "canary.command.oplist" }, // Really no point, Requires Op
            toolTip = "/oplist",
            version = 2
    )
    public void oplist(MessageReceiver caller, String[] args) {
        natives.get("oplist").execute(caller, args);
    }

    @Command(
            aliases = { "playerinfo", "pinfo" },
            description = "Player Information",
            permissions = { PLAYER$INFO },
            toolTip = "/playerinfo [player]",
            version = 2
    )
    public void playerinfo(MessageReceiver caller, String[] parameters) {
        natives.get("playerinfo").execute(caller, parameters);
    }

    @Command(
            aliases = { "playerlist", "players", "who", "list" },
            description = "who info",
            permissions = { PLAYER$LIST },
            toolTip = "/who [world]",
            version = 2
    )
    public void playerListCommand(MessageReceiver caller, String[] parameters) {
        natives.get("playerlist").execute(caller, parameters);
    }

    @Command(
            aliases = { "enableplugin" },
            description = "plugin enable info",
            permissions = { PLUGIN$ENABLE },
            toolTip = "/enableplugin <plugin>",
            min = 1,
            version = 2
    )
    public void enablePluginCommand(MessageReceiver caller, String[] parameters) {
        natives.get("enableplugin").execute(caller, parameters);
    }

    @Command(
            aliases = { "disableplugin" },
            description = "plugin disable info",
            permissions = { PLUGIN$DISABLE },
            toolTip = "/disableplugin <plugin>",
            min = 1,
            version = 2
    )
    public void disablePluginCommand(MessageReceiver caller, String[] parameters) {
        natives.get("disableplugin").execute(caller, parameters);
    }

    @Command(
            aliases = { "reloadplugin" },
            description = "plugin reload info",
            permissions = { PLUGIN$RELOAD },
            toolTip = "/reloadplugin <plugin>",
            min = 1,
            version = 2
    )
    public void reloadPluginCommand(MessageReceiver caller, String[] parameters) {
        natives.get("reloadplugin").execute(caller, parameters);
    }

    @TabComplete(commands = { "disableplugin", "reloadplugin" })
    public List<String> matchPluginName(MessageReceiver caller, String[] args) {
        return args.length == 1 ? matchTo(args, Canary.pluginManager().getPluginNames().toArray(new String[0])) : null;
    }

    @Command(
            aliases = { "reload" },
            description = "reload info",
            permissions = { RELOAD },
            toolTip = "/reload")
    public void reloadCommand(MessageReceiver caller, String[] parameters) {
        natives.get("reload").execute(caller, parameters);
    }

    @Command(
            aliases = { "reservelist", "rlist", "rl" },
            description = "reservelist info",
            permissions = { RESERVELIST },
            toolTip = "/reservelist <add|remove> <playername> | /reservelist show",
            version = 2
    )
    public void reservelistCommand(MessageReceiver caller, String[] parameters) {
        Canary.help().getHelp(caller, "reservelist");
    }

    @Command(
            aliases = { "add" },
            parent = "reservelist",
            description = "reservelist add",
            permissions = { RESERVELIST },
            toolTip = "/reservelist add <playername>",
            helpLookup = "reservelist add",
            min = 1
    )
    public void reservelistAdd(MessageReceiver caller, String[] parameters) {
        natives.get("reservelist.add").execute(caller, parameters);
    }

    @Command(
            aliases = { "remove" },
            parent = "reservelist",
            description = "reservelist remove",
            permissions = { RESERVELIST },
            toolTip = "/reservelist remove <playername>",
            helpLookup = "reservelist remove",
            min = 1
    )
    public void reservelistRemove(MessageReceiver caller, String[] parameters) {
        natives.get("reservelist.remove").execute(caller, parameters);
    }

    @Command(
            aliases = { "show", "list" },
            parent = "reservelist",
            description = "reservelist show (list)",
            permissions = { RESERVELIST },
            toolTip = "/reservelist show",
            helpLookup = "reservelist show"
    )
    public void reservelistShow(MessageReceiver caller, String[] parameters) {
        natives.get("reservelist.show").execute(caller, parameters);
    }

    @TabComplete(commands = { "reservelist" })
    public List<String> reservelistTabComplete(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 ? matchTo(parameters, new String[]{ "add", "remove" })
                : parameters.length == 2 ?
                parameters[0].equals("remove") ? matchTo(parameters, Canary.reservelist().getReservations())
                        : parameters[0].equals("add") ? matchToKnownPlayer(parameters)
                        : null
                : null;
    }

    @Command(
            aliases = { "stop", "shutdown" },
            description = "stop info",
            permissions = { STOP },
            toolTip = "/stop [reason]"
    )
    public void stopCommand(MessageReceiver caller, String[] parameters) {
        natives.get("stop").execute(caller, parameters);
    }

    @Command(
            aliases = { "sysinfo" },
            description = "System Information",
            permissions = { SYSINFO },
            toolTip = "/sysinfo"
    )
    public void sysinfo(MessageReceiver caller, String[] parameters) {
        natives.get("sysinfo").execute(caller, parameters);
    }

    @Command(
            aliases = { "unban" },
            description = "unban info",
            permissions = { UNBAN },
            toolTip = "/unban <player>",
            min = 1,
            version = 2
    )
    public void unbanCommand(MessageReceiver caller, String[] parameters) {
        natives.get("unban").execute(caller, parameters);
    }

    @TabComplete(commands = { "unban" })
    public List<String> unbanTabComplete(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 ? matchToBannedSubject(parameters) : null;
    }

    @Command(
            aliases = { "uptime" },
            description = "server uptime",
            permissions = { UPTIME },
            toolTip = "/uptime"
    )
    public void uptime(MessageReceiver caller, String[] parameters) {
        natives.get("uptime").execute(caller, parameters);
    }

    @Command(
            aliases = { "whitelist", "wlist", "wl" },
            description = "whitelist info",
            permissions = { WHITELIST },
            toolTip = "/whitelist <<add|remove <playername>>|show|enable|disable|reload>",
            version = 2
    )
    public void whitelistCommand(MessageReceiver caller, String[] parameters) {
        Canary.help().getHelp(caller, "whitelist");
    }

    @Command(
            aliases = { "add" },
            description = "whitelist add",
            permissions = { WHITELIST },
            toolTip = "/whitelist add <playername>",
            helpLookup = "whitelist add",
            parent = "whitelist",
            min = 1,
            version = 2
    )
    public void whitelistAddCommand(MessageReceiver caller, String[] parameters) {
        natives.get("whitelist.add").execute(caller, parameters);
    }

    @Command(
            aliases = { "remove" },
            description = "whitelist remove",
            permissions = { WHITELIST },
            toolTip = "/whitelist remove <playername>",
            helpLookup = "whitelist remove",
            parent = "whitelist",
            min = 1,
            version = 2
    )
    public void whitelistRemoveCommand(MessageReceiver caller, String[] parameters) {
        natives.get("whitelist.remove").execute(caller, parameters);
    }

    @Command(
            aliases = { "show", "list" },
            description = "whitelist show",
            permissions = { WHITELIST },
            toolTip = "/whitelist show",
            helpLookup = "whitelist show",
            parent = "whitelist",
            version = 2
    )
    public void whitelistShowCommand(MessageReceiver caller, String[] parameters) {
        natives.get("whitelist.show").execute(caller, parameters);
    }

    @Command(
            aliases = { "enable", "on" },
            description = "whitelist enable",
            permissions = { WHITELIST$ADMIN },
            toolTip = "/whitelist enable",
            helpLookup = "whitelist enable",
            parent = "whitelist",
            version = 2
    )
    public void whitelistEnableCommand(MessageReceiver caller, String[] parameters) {
        natives.get("whitelist.enable").execute(caller, parameters);
    }

    @Command(
            aliases = { "disable", "off" },
            description = "whitelist disable",
            permissions = { WHITELIST$ADMIN },
            toolTip = "/whitelist disable",
            helpLookup = "whitelist disable",
            parent = "whitelist",
            version = 2
    )
    public void whitelistDisableCommand(MessageReceiver caller, String[] parameters) {
        natives.get("whitelist.disable").execute(caller, parameters);
    }

    @Command(
            aliases = { "reload" },
            description = "whitelist reload",
            permissions = { WHITELIST$ADMIN },
            toolTip = "/whitelist reload",
            helpLookup = "whitelist reload",
            parent = "whitelist",
            version = 2
    )
    public void whitelistReloadCommand(MessageReceiver caller, String[] parameters) {
        natives.get("whitelist.reload").execute(caller, parameters);
    }

    @TabComplete(commands = { "whitelist" })
    public List<String> whitelistTabComplete(MessageReceiver caller, String[] parameters) {
        return parameters.length == 1 ? matchTo(parameters, new String[]{ "add", "remove", "show", "list", "enable", "on", "disable", "off", "reload" }) : null;
    }

    /* vanilla start */
    @Command(
            aliases = { "achievement" },
            description = "Gives a player an achievement or increases a statistic.",
            permissions = { ACHIEVEMENT },
            toolTip = "/achievement <give|take> <stat_name|*> [player]",
            min = 2,
            max = 3,
            version = 2
    )
    public void achievement(MessageReceiver caller, String[] args) {
        natives.get("achievement").execute(caller, args);
    }

    @Command(
            aliases = { "blockdata" },
            description = "Modifies NBT data at a specific coordinate, the <dataTag> merges with the block at that position",
            permissions = { BLOCKDATA },
            toolTip = "/blockdata <x> <y> <z> <dataTag>",
            min = 3,
            max = 4,
            version = 2
    )
    public void blockdata(MessageReceiver caller, String[] args) {
        natives.get("blockdata").execute(caller, args);
    }

    @Command(
            aliases = { "say", "broadcast" },
            description = "Broadcasts a message",
            permissions = { BROADCAST },
            toolTip = "/say <message>",
            min = 1,
            version = 2
    )
    public void broadcast(MessageReceiver caller, String[] args) {
        natives.get("broadcast").execute(caller, args);
    }

    @Command(
            aliases = { "clear", "clearinventory", "clearinv" },
            description = "Clears items from player inventory.",
            permissions = { CLEAR },
            toolTip = "/clear <player> [item] [data] [maxCount] [dataTag]",
            min = 1,
            version = 2
    )
    public void clear(MessageReceiver caller, String[] args) {
        natives.get("clear").execute(caller, args);
    }

    @Command(
            aliases = { "clone" },
            description = "Clones all the blocks (not entities) from a given area to a different given area. The clone can be replace, masked, or filtered",
            permissions = { CLONE },
            toolTip = "/clone <x1> <y1> <z1> <x2> <y2> <z2> <x> <y> <z> [mode]",
            min = 9,
            version = 2
    )
    public void clone(MessageReceiver caller, String[] args) {
        natives.get("clone").execute(caller, args);
    }

    @Command(
            aliases = { "debug" },
            description = "Starts or stops a debugging session.",
            permissions = { DEBUG },
            toolTip = "/debug <start|stop|chunk> [<x> <y> <z>]",
            min = 1,
            version = 2
    )
    public void debug(MessageReceiver caller, String[] args) {
        natives.get("debug").execute(caller, args);
    }

    @Command(
            aliases = { "defaultgamemode", "defaultmode" },
            description = "Sets the default game mode (creative, survival, etc.) for new players entering a multiplayer server.",
            permissions = { DEFAULTGAMEMODE },
            toolTip = "/defaultgamemode <gamemode> [worldName]",
            min = 1,
            version = 2
    )
    public void defaultgamemode(MessageReceiver caller, String[] args) {
        natives.get("defaultgamemode").execute(caller, args);
    }

    @Command(
            aliases = { "setworldspawn", "setspawn" },
            description = "Sets everyones GameMode",
            permissions = { SETWORLDSPAWN },
            toolTip = "/setworldspawn [<x> <y> <z>]",
            version = 2
    )
    public void defaultspawnpoint(MessageReceiver caller, String[] args) {
        natives.get("defaultspawnpoint").execute(caller, args);
    }

    @Command(
            aliases = { "difficulty" },
            description = "Sets the difficulty level (peaceful, easy, etc.).",
            permissions = { DIFFICULTY },
            toolTip = "/difficulty <new difficulty> [world]",
            min = 1,
            version = 2
    )
    public void difficulty(MessageReceiver caller, String[] args) {
        natives.get("difficulty").execute(caller, args);
    }

    @Command(
            aliases = { "effect" },
            description = "The effect command manages status effects on players and other entities.",
            permissions = { EFFECT },
            toolTip = "/effect <player> <clear|effect> [seconds] [amplifier] [hideParticles]",
            min = 2,
            version = 2
    )
    public void effect(MessageReceiver caller, String[] args) {
        natives.get("effect").execute(caller, args);
    }

    @Command(
            aliases = { "emote", "me" },
            description = "Express an emotion",
            permissions = { EMOTE },
            toolTip = "/emote <action...>",
            min = 1,
            version = 2
    )
    public void emote(MessageReceiver caller, String[] args) {
        natives.get("emote").execute(caller, args);
    }

    @Command(
            aliases = { "enchant" },
            description = "Enchants target's held item",
            permissions = { ENCHANT },
            toolTip = "/enchant <player> <enchantment ID> [level]",
            min = 2,
            version = 2
    )
    public void enchant(MessageReceiver caller, String[] args) {
        natives.get("enchant").execute(caller, args);
    }

    @Command(
            aliases = { "entitydata" },
            description = "Works similarly to /blockdata, but for entities. Does not work on Players.",
            permissions = { ENTITYDATA },
            toolTip = "/entitydata <entity> <dataTag>",
            min = 2,
            version = 2
    )
    public void entitydata(MessageReceiver caller, String[] args) {
        natives.get("entitydata").execute(caller, args);
    }

    @Command(
            aliases = { "execute" },
            description = "Allows commands to be run from the position of specified entities",
            permissions = { EXECUTE },
            toolTip = "/execute <entity> <x> <y> <z> [detect <x2> <y2> <z2> <block> <data>] <command…>",
            min = 5,
            version = 2
    )
    public void execute(MessageReceiver caller, String[] args) {
        natives.get("execute").execute(caller, args);
    }

    @Command(
            aliases = { "fill" },
            description = "Fills a given volume with a specified block",
            permissions = { FILL },
            toolTip = "/fill <x1> <y1> <z1> <x2> <y2> <z2> <TileName> [dataValue] [oldBlockHandling] [dataTag]",
            min = 7,
            version = 2
    )
    public void fill(MessageReceiver caller, String[] args) {
        natives.get("fill").execute(caller, args);
    }

    @Command(
            aliases = { "gamemode", "mode" },
            description = "Sets a player's game mode.",
            permissions = { GAMEMODE },
            toolTip = "/gamemode <mode> [player]",
            min = 1,
            version = 2
    )
    public void gamemode(MessageReceiver caller, String[] args) {
        natives.get("gamemode").execute(caller, args);
    }

    @Command(
            aliases = { "gamerule" },
            description = "Sets or queries a game rule value.",
            permissions = { GAMERULE },
            toolTip = "/gamerule <rule name> [value]",
            min = 1,
            version = 2
    )
    public void gamerule(MessageReceiver caller, String[] args) {
        natives.get("gamerule").execute(caller, args);
    }

    @Command(
            aliases = { "give", "item", "i" },
            description = "Gives an item to a player.",
            permissions = { GIVE },
            toolTip = "/give <player> <item> [amount] [data] [dataTag]",
            min = 2,
            version = 2
    )
    public void give(MessageReceiver caller, String[] args) {
        natives.get("give").execute(caller, args);
    }

    @Command(
            aliases = { "message", "msg", "tell" },
            description = "Sends a private message to a player",
            permissions = { MESSAGE },
            toolTip = "/tell <player> <private message ...>",
            min = 2,
            version = 2
    )
    public void message(MessageReceiver caller, String[] args) {
        natives.get("message").execute(caller, args);
    }

    @Command(
            aliases = { "messageraw", "msgraw", "tellraw" },
            description = "Sends a private message to a player",
            permissions = { MESSAGERAW },
            toolTip = "/tellraw <player> <raw json message>",
            min = 2,
            version = 2
    )
    public void messageraw(MessageReceiver caller, String[] args) {
        natives.get("messageraw").execute(caller, args);
    }

    @Command(
            aliases = { "particle" },
            description = "Spawns particles in a given area",
            permissions = { PARTICLE },
            toolTip = "/particle <name> <x> <y> <z> <xd> <yd> <zd> <speed> [count] [force]",
            min = 8,
            version = 2
    )
    public void particle(MessageReceiver caller, String[] args) {
        natives.get("particle").execute(caller, args);
    }

    @Command(
            aliases = { "playsound" },
            description = "Plays a sound",
            permissions = { PLAYSOUND },
            toolTip = "/playsound <sound> <player> [x] [y] [z] [volume] [pitch] [minimumVolume]",
            min = 2,
            version = 2
    )
    public void playsound(MessageReceiver caller, String[] args) {
        natives.get("playsound").execute(caller, args);
    }

    @Command(
            aliases = { "replaceitem" },
            description = "Can replace items in any inventory, including the inventories of mobs such as zombies",
            permissions = { REPLACEITEM },
            toolTip = "/replaceitem <entity <entity> | block <x> <y> <z>> <slot> <item> <slot> <item> [amount] [data value]",
            min = 6,
            version = 2
    )
    public void replaceitem(MessageReceiver caller, String[] args) {
        natives.get("replaceitem").execute(caller, args);
    }

    @Command(
            aliases = { "save-all", "saveall" },
            description = "Saves world data",
            permissions = { SAVE$ALL },
            toolTip = "/save-all",
            version = 2
    )
    public void saveall(MessageReceiver caller, String[] args) {
        natives.get("save-all").execute(caller, args);
    }

    @Command(
            aliases = { "save-off", "saveoff" },
            description = "Turns off world data saving",
            permissions = { SAVE$OFF },
            toolTip = "/save-off",
            version = 2
    )
    public void saveoff(MessageReceiver caller, String[] args) {
        natives.get("save-off").execute(caller, args);
    }

    @Command(
            aliases = { "save-on", "saveon" },
            description = "Turns on world data saving",
            permissions = { SAVE$ON },
            toolTip = "/save-on",
            version = 2
    )
    public void saveon(MessageReceiver caller, String[] args) {
        natives.get("save-on").execute(caller, args);
    }

    @Command(
            aliases = { "scoreboard" },
            description = "SCORE(BOARD)!",
            permissions = { SCOREBOARD },
            toolTip = "/scoreboard <objectives|players|teams>",
            min = 1,
            version = 2
    )
    public void scoreboard(MessageReceiver caller, String[] args) {
        natives.get("scoreboard").execute(caller, args);
    }

    @Command(
            aliases = { "setblock" },
            description = "Sets a block",
            permissions = { SETBLOCK },
            toolTip = "/setblock <x> <y> <z> <TileName> [dataValue] [oldBlockHandling] [dataTag]",
            min = 4,
            version = 2
    )
    public void setblock(MessageReceiver caller, String[] args) {
        natives.get("setblock").execute(caller, args);
    }

    @Command(
            aliases = { "spawnpoint" },
            description = "Spawnpoint setting (Player based)",
            permissions = { SPAWNPOINT },
            toolTip = "/spawnpoint [player [<x> <y> <z>]]",
            version = 2
    )
    public void spawnpoint(MessageReceiver caller, String[] args) {
        natives.get("spawnpoint").execute(caller, args);
    }

    @Command(
            aliases = { "spreadplayers" },
            description = "Spreads out them players",
            permissions = { SPREADPLAYERS },
            toolTip = "/spreadplayers <x> <z> <spreadDistance> <maxRange> <respectTeams true|false> <player ...>",
            min = 4,
            version = 2
    )
    public void spreadplayers(MessageReceiver caller, String[] args) {
        natives.get("spreadplayers").execute(caller, args);
    }

    @Command(
            aliases = { "stats" },
            description = "Alternative and more featureful way of interacting with CommandStats",
            permissions = { STATS },
            toolTip = "/stats <entity <selector>|block [x] [y] [z]> <mode>",
            min = 3,
            version = 2
    )
    public void stats(MessageReceiver caller, String[] args) {
        natives.get("stats").execute(caller, args);
    }

    @Command(
            aliases = { "summon", "mspawn", "mobspawn", "spawnmob" },
            description = "Summons an entity",
            permissions = { SUMMON },
            toolTip = "/summon <EntityName> [x] [y] [z] [dataTag]",
            min = 1,
            version = 2
    )
    public void summon(MessageReceiver caller, String[] args) {
        natives.get("summon").execute(caller, args);
    }

    @Command(
            aliases = { "teleport", "tp" },
            description = "Teleports a player",
            permissions = { TELEPORT, TELEPORT$OTHER },
            toolTip = "/tp [target] <player | <<x> <y> <z> <rotX> <rotY>> | /tp <target> <x> <y> <z> <rotX> <rotY> <world_fqname> [load]",
            min = 1,
            version = 2
    )
    public void teleport(MessageReceiver caller, String[] args) {
        natives.get("teleport").execute(caller, args);
    }

    @Command(
            aliases = { "testfor" },
            description = "Counts entities (players, mobs, items, etc.) matching specified conditions.",
            permissions = { TESTFOR },
            toolTip = "/testfor <player|targetselector> [datatag]",
            min = 1,
            version = 2
    )
    public void testfor(MessageReceiver caller, String[] args) {
        natives.get("testfor").execute(caller, args);
    }

    @Command(
            aliases = { "testforblock" },
            description = "Tests whether a certain block is in a specific location.",
            permissions = { TESTFORBLOCK },
            toolTip = "/testforblock <x> <y> <z> <TileName> [dataValue] [dataTag]",
            min = 4,
            version = 2
    )
    public void testforblock(MessageReceiver caller, String[] args) {
        natives.get("testforblock").execute(caller, args);
    }

    @Command(
            aliases = { "testforblocks" },
            description = "Compares two areas of a world",
            permissions = { TESTFORBLOCKS },
            toolTip = "/testforblocks <x1> <y1> <z1> <x2> <y2> <z2> [mode]",
            min = 6,
            version = 2
    )
    public void testforblocks(MessageReceiver caller, String[] args) {
        natives.get("testforblocks").execute(caller, args);
    }

    @Command(
            aliases = { "time" },
            description = "Changes or queries the world's game time.",
            permissions = { TIME },
            toolTip = "/time <add|query|set> <value>",
            min = 2,
            version = 2
    )
    public void time(MessageReceiver caller, String[] args) {
        natives.get("time").execute(caller, args);
    }

    @Command(
            aliases = { "title" },
            description = "Can make text display on a players screen in the form of a title and/or subtitle using JSON",
            permissions = { TITLE },
            toolTip = "/title <params...>",
            min = 1,
            version = 2
    )
    public void title(MessageReceiver caller, String[] args) {
        natives.get("title").execute(caller, args);
    }

    @Command(
            aliases = { "toggledownfall" },
            description = "Toggles the weather.",
            permissions = { TOGGLEDOWNFALL },
            toolTip = "/Toggles the weather.",
            version = 2
    )
    public void toggledownfall(MessageReceiver caller, String[] args) {
        natives.get("toggledownfall").execute(caller, args);
    }

    @Command(
            aliases = { "trigger" },
            description = "Functions the same way as /scoreboard players set or /scoreboard players add, but can only modify objectives with the trigger criteria (referred to as \"triggers\") and can only modify the score of the player running the command",
            permissions = { TRIGGER },
            toolTip = "/trigger <objective> <add:set> <value>",
            min = 3,
            version = 2
    )
    public void trigger(MessageReceiver caller, String[] args) {
        natives.get("trigger").execute(caller, args);
    }

    @Command(
            aliases = { "weather" },
            description = "Sets the weather.",
            permissions = { WEATHER },
            toolTip = "/weather <clear|rain|thunder> [duration in seconds]",
            min = 1,
            version = 2
    )
    public void weather(MessageReceiver caller, String[] args) {
        natives.get("weather").execute(caller, args);
    }

    @Command(
            aliases = { "worldborder" },
            description = "World border modification",
            permissions = { WORLDBORDER },
            toolTip = "/worldborder <<set|add <sizeInBlocks> <timeInSeconds>>:center <x> <z>:damage <buffer|amount>:warning <time|distance>:get>",
            min = 1,
            version = 2
    )
    public void worldborder(MessageReceiver caller, String[] args) {
        natives.get("worldborder").execute(caller, args);
    }

    @Command(
            aliases = { "xp", "experience" },
            description = "Adds experience to a player.",
            permissions = { XP },
            toolTip = "/xp <amount[L]> [player]",
            min = 1,
            version = 2
    )
    public void xp(MessageReceiver caller, String[] args) {
        natives.get("xp").execute(caller, args);
    }
    /* vanilla end */

    @Command(
            aliases = { "home" },
            description = "home info",
            permissions = { HOME },
            toolTip = "/home [playername]",
            version = 2
    )
    public void homeCommand(MessageReceiver caller, String[] parameters) {
        natives.get("home").execute(caller, parameters);
    }

    @Command(
            aliases = { "sethome" },
            description = "sethome info",
            permissions = { HOME$SET },
            toolTip = "/sethome [player]",
            version = 2
    )
    public void setHomeCommand(MessageReceiver caller, String[] parameters) {
        natives.get("sethome").execute(caller, parameters);
    }

    @Command(aliases = { "spawn" },
            description = "spawn info",
            permissions = { SPAWN },
            toolTip = "/spawn [worldname] [player]",
            min = 1,
            max = 3
    )
    public void spawnCommand(MessageReceiver caller, String[] parameters) {
        natives.get("spawn").execute(caller, parameters);
    }

    @TabComplete(commands = { "spawn" })
    public List<String> matchWorldNamePlayerName(MessageReceiver caller, String[] args) {
        return args.length == 1 ? matchToKnownWorld(args)
                : args.length == 2 ? matchToOnlinePlayer(args)
                : null;
    }

    @Command(
            aliases = { "listwarps", "warps" },
            description = "lwarps info",
            permissions = { WARP$LIST },
            toolTip = "/listwarps"
    )
    public void listWarpsCommand(MessageReceiver caller, String[] parameters) {
        natives.get("listwarps").execute(caller, parameters);
    }

    @Command(
            aliases = { "delwarp", "removewarp" },
            description = "delwarp info",
            permissions = { WARP$REMOVE },
            toolTip = "/delwarp <name>",
            min = 1,
            version = 2
    )
    public void delWarpCommand(MessageReceiver caller, String[] parameters) {
        natives.get("delwarp").execute(caller, parameters);
    }

    @Command(
            aliases = { "setwarp" },
            description = "setwarp info",
            permissions = { WARP$SET },
            toolTip = "/setwarp <name> [G <group>|P <player>]",
            min = 1,
            version = 2
    )
    public void setWarpCommand(MessageReceiver caller, String[] parameters) {
        natives.get("setwarp").execute(caller, parameters);
    }

    @Command(
            aliases = { "warp" },
            description = "warp info",
            permissions = { WARP$USE },
            toolTip = "/warp <name>",
            min = 1,
            version = 2
    )
    public void warpUse(MessageReceiver caller, String[] parameters) {
        natives.get("warp").execute(caller, parameters);
    }

    @TabComplete(commands = { "warp", "delwarp" })
    public List<String> matchWarpNames(MessageReceiver caller, String[] args) {
        return args.length == 1 ? matchToWarpNames(args, caller) : null;
    }

    @Command(
            aliases = { "world" },
            description = "World base command",
            permissions = { WORLD },
            toolTip = "/world <create|load|delete>",
            version = 2
    )
    public void world(MessageReceiver caller, String[] args) {
        Canary.help().getHelp(caller, "world");
    }

    @Command(
            aliases = { "createworld" },
            description = "creates a world",
            permissions = { WORLD$CREATE },
            toolTip = "/createworld <name> [seed] [dimensionType] [worldType]",
            max = 4,
            min = 1,
            version = 2
    )
    public void createWorld(MessageReceiver caller, String[] args) {
        natives.get("world.create").execute(caller, args);
    }

    @Command(
            aliases = { "create" },
            parent = "world",
            description = "creates a world",
            permissions = { WORLD$CREATE },
            toolTip = "/world create <name> [seed] [dimensionType] [worldType]",
            helpLookup = "world create",
            max = 4,
            min = 1
    )
    public void worldCreate(MessageReceiver caller, String[] args) {
        natives.get("world.create").execute(caller, args);
    }

    @TabComplete(commands = { "createworld", "world create" })
    public List<String> createWorldTabComplete(MessageReceiver caller, String[] args) {
        switch (args.length) {
            case 3:
                return matchToDimension(args);
            case 4:
                return matchToWorldType(args);
            default:
                return null;
        }
    }

    @Command(
            aliases = { "deleteworld" },
            description = "Deletes a world",
            permissions = { WORLD$DELETE },
            toolTip = "/deleteworld <world_fqName>",
            min = 1,
            version = 2
    )
    public void deleteworld(MessageReceiver caller, String[] args) {
        natives.get("world.delete").execute(caller, args);
    }

    @Command(
            aliases = { "delete" },
            parent = "world",
            description = "Deletes a world",
            permissions = { WORLD$DELETE },
            toolTip = "/world delete <world_fqName>",
            helpLookup = "world delete",
            min = 1,
            version = 2
    )
    public void worldDelete(MessageReceiver caller, String[] args) {
        natives.get("world.delete").execute(caller, args);
    }

    @TabComplete(commands = { "deleteworld", "world delete", "world info" })
    public List<String> deleteworldTabComplete(MessageReceiver caller, String[] args) {
        return args.length == 1 ? matchToKnownWorld(args) : null;
    }

    @Command(
            aliases = { "info" },
            parent = "world",
            description = "Displays information about a world",
            permissions = { WORLD$INFO },
            toolTip = "/world info <world_fqName>",
            helpLookup = "world info",
            min = 1,
            version = 2
    )
    public void worldInfo(MessageReceiver caller, String[] args) {
        natives.get("world.info").execute(caller, args);
    }

    @Command(
            aliases = { "list" },
            parent = "world",
            description = "lists worlds",
            permissions = { WORLD$LIST },
            toolTip = "/world list",
            helpLookup = "world list",
            version = 2
    )
    public void worldList(MessageReceiver caller, String[] args) {
        natives.get("world.list").execute(caller, args);
    }

    @Command(
            aliases = { "loadworld" },
            description = "loads a world",
            permissions = { WORLD$LOAD },
            toolTip = "/loadworld <worldName> [dimensionType]",
            min = 1,
            version = 2
    )
    public void loadWorld(MessageReceiver caller, String[] args) {
        natives.get("world.load").execute(caller, args);
    }

    @Command(
            aliases = { "load" },
            parent = "world",
            description = "loads a world",
            permissions = { WORLD$LOAD },
            toolTip = "/world load <worldName> [dimensionType]",
            helpLookup = "world load",
            min = 1,
            version = 2
    )
    public void worldLoad(MessageReceiver caller, String[] args) {
        natives.get("world.load").execute(caller, args);
    }

    @Command(
            aliases = { "unloadworld" },
            description = "unloads a world",
            permissions = { WORLD$LOAD },
            toolTip = "/unloadworld <worldName> [dimensionType]",
            min = 1,
            version = 2
    )
    public void unloadWorld(MessageReceiver caller, String[] args) {
        natives.get("world.unload").execute(caller, args);
    }

    @Command(
            aliases = { "unload" },
            parent = "world",
            description = "unloads a world",
            permissions = { WORLD$LOAD },
            toolTip = "/world unload <worldName> [dimensionType]",
            helpLookup = "world unload",
            min = 1,
            version = 2
    )
    public void worldUnload(MessageReceiver caller, String[] args) {
        natives.get("world.unload").execute(caller, args);
    }

    @TabComplete(commands = { "loadworld", "world load", "unloadworld", "world unload" })
    public List<String> matchWorldNameDimension(MessageReceiver caller, String[] args) {
        return args.length == 1 ? matchToKnownWorld(args)
                : args.length == 2 ? matchToDimension(args)
                : null;
    }

    @Command(
            aliases = { "mob" },
            description = "Gets a Mob count or destroys mobs within a radius.",
            permissions = { MOB },
            toolTip = "/mob count [world [dimension]] or /mob clear <h|p|t|u|a> [radius] [world [dimension]]",
            min = 1,
            version = 2
    )
    public void mob(MessageReceiver caller, String[] args) {
        Canary.help().getHelp(caller, "mob");
    }

    @Command(
            aliases = { "clear" },
            parent = "mob",
            description = "Destroys mobs within a radius.",
            permissions = { MOB$CLEAR },
            toolTip = "/mob clear <h|p|t|u|a> [radius] [world <dimension>]  NOTE: (h = Hostiles p = Passives t = Tamed u = Utility (Like Items) and a = all)",
            helpLookup = "mob clear",
            min = 1,
            version = 2
    )
    public void mobclear(MessageReceiver caller, String[] args) {
        natives.get("mob.clear").execute(caller, args);
    }

    @Command(
            aliases = { "count" },
            parent = "mob",
            description = "Gets a Mob count.",
            permissions = { MOB$COUNT },
            toolTip = "/mob count [world]",
            helpLookup = "mob count",
            version = 2
    )
    public void mobcount(MessageReceiver caller, String[] args) {
        natives.get("mob.count").execute(caller, args);
    }

    @TabComplete(commands = { "mob" })
    public List<String> mobTabComplete(MessageReceiver caller, String[] args) {
        return args.length == 1 ? matchTo(args, new String[]{ "clear", "count" })
                : args.length == 2 ?
                args[0].equals("clear") ? matchTo(args, new String[]{ "h", "ht", "hp", "hu", "htp", "htu", "htpu", "t", "tp", "tu", "tpu", "p", "pu", "u", "a" })
                        : args[0].equals("count") ? matchToLoadedWorld(args)
                        : null
                : null;
    }

    @Command(
            aliases = { "mobspawner" },
            description = "Sets or Checks MobSpawner information",
            permissions = { MOBSPAWNER },
            toolTip = "/mobspawner <set|check>",
            min = 1,
            version = 2
    )
    public void mobspawner(MessageReceiver caller, String[] args) {
        Canary.help().getHelp(caller, "mobspawner");
    }

    @Command(
            aliases = { "set" },
            parent = "mobspawner",
            description = "Sets the MobSpawner's data",
            permissions = { MOBSPAWNER$SET },
            toolTip = "/mobspawner set <*see tab complete*>",
            helpLookup = "mobspawner set",
            min = 1,
            version = 2
    )
    public void mobspawnerset(MessageReceiver caller, String[] args) {
        natives.get("mobspawner.set").execute(caller, args);
    }

    @Command(
            aliases = { "check" },
            parent = "mobspawner",
            description = "Checks the MobSpawner's data",
            permissions = { MOBSPAWNER$CHECK },
            toolTip = "/mobspawner check",
            helpLookup = "mobspawner check",
            version = 2
    )
    public void mobspawnercheck(MessageReceiver caller, String[] args) {
        natives.get("mobspawner.check").execute(caller, args);
    }

    @TabComplete(commands = { "mobspawner" })
    public List<String> mobspawnerTabComplete(MessageReceiver caller, String[] args) {
        return args.length == 1 ? matchTo(args, new String[]{ "set", "check" })
                : args.length > 2 && args[1].equals("set") ?
                matchTo(args, new String[]{ "id:", "delay:", "minDelay:", "maxDelay:", "count:", "maxNearby:", "playerRange:", "spawnRange:" })
                : null;
    }

    @TabComplete(commands = { "playerinfo", "home", "op", "playermod permission add",
            "playermod permission check", "playermod prefix", "playermod remove",
            "playermod group list"
    })
    public List<String> matchKnownPlayer(MessageReceiver caller, String[] args) {
        return args.length == 1 ? matchToKnownPlayer(args) : null;
    }

    @TabComplete(commands = { "kick", "mute", "god" })
    public List<String> matchOnlinePlayer(MessageReceiver caller, String[] args) {
        return args.length == 1 ? matchToOnlinePlayer(args) : null;
    }
}
