package net.canarymod.api.entity.effect;

/**
 * LightningBolt wrapper interface
 *
 * @author Jason (darkdiplomat)
 */
public interface LightningBolt extends WeatherEffect {

    /**
     * Gets the ticks that the LightningBolt will live for.<br>
     * When this reaches 0, the LightningBolt is destroyed
     *
     * @return the living time
     */
    int getLivingTime();

    /**
     * Sets the ticks that the LightningBolt will live for.
     *
     * @param time
     *         the living time
     */
    void setLivingTime(int time);

    /**
     * Gets the state of the LightingBolt.
     *
     * @return {@code 2} for play effects;<br>
     * {@code < 0} for living time decrement and setting blocks a blaze;<br>
     * {@code >= 0} for striking entities
     */
    int getLightningState();

    /**
     * Sets the state of the LightingBolt.
     *
     * @param state
     *         {@code 2} for play effects;<br>
     *         {@code < 0} for living time decrement and setting blocks a blaze;<br>
     *         {@code >= 0} for striking entities
     */
    void setLightingState(int state);
}
