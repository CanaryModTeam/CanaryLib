package net.canarymod.api.factory;

/**
 * Factory interface<br>
 * For creation of Entities, Items, etc...
 *
 * @author Brian (WWOL)
 * @author Jason (darkdiplomat)
 */
public interface Factory {

    /**
     * Gets the {@link ItemFactory} instance
     *
     * @return {@link ItemFactory}
     */
    ItemFactory getItemFactory();

    /**
     * Gets the {@link PotionFactory} instance
     *
     * @return {@link PotionFactory}
     */
    PotionFactory getPotionFactory();

    /**
     * Gets the {@link EntityFactory} instance
     *
     * @return {@link EntityFactory}
     */
    EntityFactory getEntityFactory();

    /**
     * Gets the {@link ObjectFactory} instance
     *
     * @return {@link ObjectFactory}
     */
    ObjectFactory getObjectFactory();

    /**
     * Gets the {@link NBTFactory} instance
     *
     * @return {@link NBTFactory}
     */
    NBTFactory getNBTFactory();

    /**
     * Gets the {@link PacketFactory} instance
     *
     * @return {@link PacketFactory}
     */
    PacketFactory getPacketFactory();

    /**
     * Gets the {@link ChatComponentFactory} instance
     *
     * @return {@link ChatComponentFactory}
     */
    ChatComponentFactory getChatComponentFactory();

    /**
     * Gets the {@link AttributeFactory} instance
     *
     * @return {@link AttributeFactory}
     */
    AttributeFactory getAttributeFactory();

    /**
     * Gets the {@link StatisticsFactory} instance
     *
     * @return {@link StatisticsFactory}
     */
    StatisticsFactory getStatisticsFactory();

    /**
     * Gets the {@link AIFactory} instance
     *
     * @return {@link AIFactory}
     */
    AIFactory getAIFactory();
}
