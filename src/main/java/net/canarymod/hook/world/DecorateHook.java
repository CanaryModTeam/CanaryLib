package net.canarymod.hook.world;

import net.canarymod.api.world.World;
import net.canarymod.hook.CancelableHook;

/**
 * Called when decorating terrain with trees, glowstone etc.
 *
 * @author Brian (WWOL)
 */
public final class DecorateHook extends CancelableHook {
    public enum DecoratorType {
        BEACH,
        DESERT,
        END,
        FOREST,
        HELL,
        HILLS,
        JUNGLE,
        MUSHROOM_ISLAND,
        OCEAN,
        PLAINS,
        RIVER,
        SNOW,
        SWAMP,
        TAIGA,
        UNKNOWN;
    }

    int x;
    int z;
    World world;
    DecoratorType decoratorType;

    public DecorateHook(int x, int z, World world, String name) {
        this.x = x;
        this.z = z;
        this.world = world;
        this.decoratorType = getFromName(name);
    }

    /**
     * Gets the x coordinate
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the z coordinate
     *
     * @return z
     */
    public int getZ() {
        return z;
    }

    /**
     * Return the {@link World}
     *
     * @return world
     */
    public World getWorld() {
        return world;
    }

    /**
     * Gets the {@link DecoratorType}
     *
     * @return type
     */
    public DecoratorType getDecoratorType() {
        return decoratorType;
    }

    /**
     * Return a {@link DecoratorType} from a string
     *
     * @param name
     *
     * @return {@link DecoratorType#UNKNOWN} if of unknown type.
     */
    public DecoratorType getFromName(String name) {
        if (name.equals("BiomeGenBeach")) {
            return DecoratorType.BEACH;
        }
        else if (name.equals("BiomeGenDesert")) {
            return DecoratorType.DESERT;
        }
        else if (name.equals("BiomeGenEnd")) {
            return DecoratorType.END;
        }
        else if (name.equals("BiomeGenForest")) {
            return DecoratorType.FOREST;
        }
        else if (name.equals("BiomeGenHell")) {
            return DecoratorType.HELL;
        }
        else if (name.equals("OBiomeGenHills")) {
            return DecoratorType.HILLS;
        }
        else if (name.equals("BiomeGenJungle")) {
            return DecoratorType.JUNGLE;
        }
        else if (name.equals("BiomeGenMushroomIsland")) {
            return DecoratorType.MUSHROOM_ISLAND;
        }
        else if (name.equals("BiomeGenOcean")) {
            return DecoratorType.OCEAN;
        }
        else if (name.equals("BiomeGenPlains")) {
            return DecoratorType.PLAINS;
        }
        else if (name.equals("BiomeGenRiver")) {
            return DecoratorType.RIVER;
        }
        else if (name.equals("BiomeGenSnow")) {
            return DecoratorType.SNOW;
        }
        else if (name.equals("BiomeGenSwamp")) {
            return DecoratorType.SWAMP;
        }
        else if (name.equals("BiomeGenTaiga")) {
            return DecoratorType.TAIGA;
        }
        return DecoratorType.UNKNOWN;
    }

    @Override
    public final String toString() {
        return String.format("%s[X=%s, Z=%s, World=%s, Decorator Type=%s]", getHookName(), x, z, world, decoratorType);
    }
}
