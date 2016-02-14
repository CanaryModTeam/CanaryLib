package net.canarymod.commandsys.commands.system.informational;

import net.canarymod.Canary;
import net.canarymod.chat.ChatFormat;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.NativeCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Command to get information about CanaryMod
 *
 * @author Jason (darkdiplomat)
 */
public class CanaryModCommand implements NativeCommand {
    private final static List<String> information;

    static {
        ArrayList<String> temp = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        temp.add(builder.append(ChatFormat.RED).append("---- ").append(ChatFormat.GOLD).append(Canary.getImplementationTitle()).append(" ").append(Canary.getImplementationVersion()).append(ChatFormat.RED).append(" ----").toString());
        builder.delete(0, builder.length());
        temp.add(builder.append(ChatFormat.GOLD).append("Build#: ").append(ChatFormat.WHITE).append(Canary.getBuildNumber()).toString());
        builder.delete(0, builder.length());
        temp.add(builder.append(ChatFormat.GOLD).append("Project Leaders: ").append(ChatFormat.WHITE).append("damagefilter, darkdiplomat").toString());
        builder.delete(0, builder.length());
        temp.add(builder.append(ChatFormat.GOLD).append("Lead Programmer: ").append(ChatFormat.WHITE).append("darkdiplomat").toString());
        builder.delete(0, builder.length());
        temp.add(builder.append(ChatFormat.GOLD).append("Programmers: ").append(ChatFormat.WHITE).append("Larry1123, somners, jamierocks").toString());
        builder.delete(0, builder.length());
        temp.add(builder.append(ChatFormat.GOLD).append("With Contributions by: ").append(ChatFormat.WHITE).append("Shadow386, 14mRh4X0r, gregthegeek, WWOL, joskuijpers, YLivay, EHudB, Swift, MossyBlog, Pwootage, and others").toString());
        builder.delete(0, builder.length());
        temp.add(builder.append(ChatFormat.GOLD).append("Website: ").append(ChatFormat.WHITE).append("http://canarymod.net").toString());
        builder.delete(0, builder.length());
        temp.add(builder.append(ChatFormat.GOLD).append("GitHub: ").append(ChatFormat.WHITE).append("http://git.io/tuPNQw").toString());
        builder.delete(0, builder.length());
        temp.add(builder.append(ChatFormat.RED).append("  Copyright (c) 2012-2016 ").append(ChatFormat.GOLD).append("CanaryMod Team").toString());
        builder.delete(0, builder.length());
        temp.add(builder.append(ChatFormat.RED).append("  Under the management of ").append(ChatFormat.GOLD).append("PlayBlack and Visual Illusions Ent.").toString());
        builder.delete(0, builder.length());
        temp.add(builder.append(ChatFormat.RED).append("  Licensed under the BSD 3-Clause License  ").toString());
        builder.delete(0, builder.length());
        temp.add(builder.append(ChatFormat.BLUE).append("  CanaryMod is NOT affiliated with, endorsed, or sponsored by Mojang AB ").toString());
        information = Collections.unmodifiableList(temp);
    }

    public void execute(MessageReceiver caller, String[] args) {
        for (String msg : information) {
            caller.message(msg);
        }
    }
}
