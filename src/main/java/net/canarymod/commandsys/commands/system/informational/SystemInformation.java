package net.canarymod.commandsys.commands.system.informational;

import net.canarymod.Canary;
import net.canarymod.chat.ChatFormat;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.NativeCommand;
import net.visualillusionsent.utils.DateUtils;
import net.visualillusionsent.utils.SystemUtils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.MessageFormat;
import java.util.TimeZone;

/**
 * System Information read-out command
 *
 * @author Jason (darkdiplomat)
 */
public class SystemInformation implements NativeCommand {

    @Override
    public void execute(MessageReceiver caller, String[] parameters) {

        Runtime rtime = Runtime.getRuntime();
        RuntimeMXBean rBean = ManagementFactory.getRuntimeMXBean();
        float freeMem = (rtime.freeMemory() / 1024.0F) / 1024.0F; // Pull up to MegaBytes
        float alloMem = (rtime.totalMemory() / 1024.0F) / 1024.0F; // Pull up to MegaBytes
        float maxMem = (rtime.maxMemory() / 1024.0F) / 1024.0F; // Pull up to MegaBytes
        long uptime = rBean.getUptime() / 1000; // RuntimeMXBean returns millis and getTimeUntil needs seconds
        int rawOff = TimeZone.getDefault().getRawOffset();
        int gmtH = rawOff / (60 * 60 * 1000); // GMT offset Hours
        int gmtM = (rawOff / (60 * 1000)) % 60; // GMT offset Minutes
        caller.message(ChatFormat.GOLD + "   *** " + ChatFormat.RED + "SYSTEM INFO" + ChatFormat.GOLD + " ***");
        caller.message(ChatFormat.GOLD + "OS Name: " + ChatFormat.WHITE + SystemUtils.OPERATING_SYSTEM);
        caller.message(ChatFormat.GOLD + "OS Version: " + ChatFormat.WHITE + SystemUtils.OS_VERSION);
        caller.message(ChatFormat.GOLD + "OS Architecture: " + ChatFormat.WHITE + SystemUtils.OS_ARCHITECTURE);
        caller.message(ChatFormat.GOLD + "Java Vendor: " + ChatFormat.WHITE + SystemUtils.JAVA_VENDOR);
        caller.message(ChatFormat.GOLD + "Java Version: " + ChatFormat.WHITE + SystemUtils.JAVA_VERSION);
        caller.message(ChatFormat.GOLD + "Available Processors: " + ChatFormat.WHITE + rtime.availableProcessors());
        caller.message(ChatFormat.GOLD + String.format("RAM: \u00A7F%.2fMb Free \u00A76| \u00A7F%.2fMb Allocated \u00A76| \u00A7F%.2fMb Max", freeMem, alloMem, maxMem));
        caller.message(ChatFormat.GOLD + "Server Start: " + ChatFormat.WHITE + DateUtils.longToDateTime(rBean.getStartTime()) + MessageFormat.format(" GMT{0,number,00}:{1,number,00}", gmtH, gmtM));
        caller.message(ChatFormat.GOLD + "Time Alive: " + ChatFormat.WHITE + DateUtils.getTimeUntil(uptime));
        caller.message(String.format(ChatFormat.GOLD + "Ticks Per Second (TPS):\u00A7F %.2f", Canary.getServer().getTicksPerSecond()));
    }
}
