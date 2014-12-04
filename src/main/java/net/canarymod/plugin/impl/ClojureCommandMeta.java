package net.canarymod.plugin.impl;

import net.canarymod.commandsys.Command;

import java.lang.annotation.Annotation;

/**
* *******************************
* Value object to hold clojure command meta information (avoiding annotations)
* @author DanThiffault
* ********************************
*/
public class ClojureCommandMeta implements Command {
    private String[] aliases;
    private String[] permissions;
    private String description;
    private String toolTip;
    private String parent;
    private String helpLookup;
    private String[] searchTerms;
    private int min;
    private int max;
    private int version;

    public ClojureCommandMeta(String[] aliases, String[] permissions, String description, String toolTip, String parent, String helpLookup, String[] searchTerms, int min, int max, int version) {
        this.aliases = aliases;
        this.permissions = permissions;
        this.description = description;
        this.toolTip = toolTip;
        this.parent = parent;
        this.helpLookup = helpLookup;
        this.searchTerms = searchTerms;
        this.min = min;
        this.max = max;
        this.version = version;
    }

    @Override
    public String[] aliases() {
        return aliases;
    }

    @Override
    public String[] permissions() {
        return permissions;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String toolTip() {
        return toolTip;
    }

    @Override
    public String parent() {
        return parent;
    }

    @Override
    public String helpLookup() {
        return helpLookup;
    }

    @Override
    public String[] searchTerms() {
        return searchTerms;
    }

    @Override
    public int min() {
        return min;
    }

    @Override
    public int max() {
        return max;
    }

    @Override
    public int version() {
        return version;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return ClojureCommandMeta.class;
    }
}
