package net.canarymod.plugin.impl;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import net.canarymod.Canary;
import net.canarymod.CanaryClassLoader;
import net.canarymod.Translator;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.*;
import net.canarymod.hook.Dispatcher;
import net.canarymod.hook.Hook;
import net.canarymod.plugin.Plugin;
import net.canarymod.plugin.PluginDescriptor;
import net.canarymod.plugin.PluginListener;
import net.canarymod.plugin.Priority;
import net.visualillusionsent.utils.LocaleHelper;

import java.lang.annotation.Annotation;

/**
 * *******************************
 * Clojure Plugin base class
 * @author DanThiffault
 * ********************************
 */
public class ClojurePlugin extends Plugin {
    private PluginDescriptor desc;
    private PluginListener pluginListener = new ClojurePluginListener();
    private  CommandListener commandListener = new ClojureCommandListener();
    private CanaryClassLoader cl;

    public ClojurePlugin(PluginDescriptor desc, CanaryClassLoader cl) {
        this.desc = desc;
        this.cl = cl;
        Thread.currentThread().setContextClassLoader(cl);
    }

    @Override
    public boolean enable() {
        getLogman().info("Enabling clojure plugin " + desc.getName());
        final String clojureNameSpace = desc.getCanaryInf().getString("clj-ns");
        final String clojureMain = desc.getCanaryInf().getString("clj-main");

        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read(clojureNameSpace), Clojure.read(":reload-all"));
        IFn entryPointFn = Clojure.var(clojureNameSpace, clojureMain);
        entryPointFn.invoke(this);

        return true;
    }

    @Override
    public void disable() {
        getLogman().info("Disabling clojure plugin " + desc.getName());
        Canary.hooks().unregisterPluginListeners(this);
        Canary.commands().unregisterCommands(this);
    }

    @SuppressWarnings("UnusedDeclaration")
    /**
     * Register a hook through this plugin. Called internally from clojure code.
     */
    public void registerHook(String hookName, IFn hookHandler, Priority priority) {
        try {
            final Class<?> hookClass = cl.loadClass(hookName);
            Canary.hooks().registerHook(pluginListener, this, hookClass, new ClojureDispatcher(hookHandler), priority);
        } catch (ClassNotFoundException e) {
            getLogman().error("Could not find hook class", e);
        }
    }

    public void registerCommand(IFn commandHandler, Command meta, boolean force) throws CommandDependencyException {
        ClojureCommand cmd = new ClojureCommand(meta, this, Translator.getInstance(), commandHandler);
        Canary.commands().registerCommand(cmd, this, force);
    }

    private class ClojureCommand extends CanaryCommand {
        private IFn commandHandler;

        private ClojureCommand(Command meta, CommandOwner owner, LocaleHelper translator, IFn commandHandler) {
            super(meta, owner, translator);
            this.commandHandler = commandHandler;
        }

        @Override
        protected void execute(MessageReceiver caller, String[] parameters) {
            commandHandler.invoke(new Object[] { caller, parameters});
        }
    }

    /**
     * Create a dispatcher by wrapping an anonymous clojure function
     */
    private class ClojureDispatcher extends Dispatcher {
        private IFn hookHandler;

        private ClojureDispatcher(IFn hookHandler) {
            this.hookHandler = hookHandler;
        }

        @Override
        public void execute(PluginListener listener, Hook hook) {
            hookHandler.invoke(hook);
        }
    }

    /**
     * Empty implementation of a PluginListener
     */
    private class ClojurePluginListener implements PluginListener {}

    /**
     * Empty implementation of a CommandListener
     */
    private class ClojureCommandListener implements CommandListener {}
}
