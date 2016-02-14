package net.canarymod.metrics;

import net.canarymod.Canary;
import org.mcstats.Metrics;

import java.io.File;
import java.io.IOException;

/**
 * Canary implementation of Metrics
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class CanaryMetrics extends Metrics {
    private static final File CONFIG_FILE = new File("config/metrics.cfg");

    private final String fsv = String.format("%s %s (MC: %s)", Canary.getSpecificationTitle(), Canary.getSpecificationVersion(), Canary.getServer().getServerVersion());

    public CanaryMetrics(String pluginName, String pluginVersion) throws IOException {
        super(pluginName, pluginVersion);
    }

    @Override
    public final String getFullServerVersion() {
        return fsv;
    }

    @Override
    public final int getPlayersOnline() {
        return Canary.getServer().getNumPlayersOnline();
    }

    @Override
    public File getConfigFile() {
        return CONFIG_FILE;
    }
}
