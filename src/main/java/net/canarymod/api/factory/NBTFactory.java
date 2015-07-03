package net.canarymod.api.factory;

import net.canarymod.api.nbt.BaseTag;
import net.canarymod.api.nbt.ByteArrayTag;
import net.canarymod.api.nbt.ByteTag;
import net.canarymod.api.nbt.CompoundTag;
import net.canarymod.api.nbt.DoubleTag;
import net.canarymod.api.nbt.FloatTag;
import net.canarymod.api.nbt.IntArrayTag;
import net.canarymod.api.nbt.IntTag;
import net.canarymod.api.nbt.ListTag;
import net.canarymod.api.nbt.LongTag;
import net.canarymod.api.nbt.NBTTagType;
import net.canarymod.api.nbt.ShortTag;
import net.canarymod.api.nbt.StringTag;

/**
 * NamedBinaryTag Manufacturing Factory
 *
 * @author Jason (darkdiplomat)
 */
public interface NBTFactory {

    /**
     * Creates a new {@link CompoundTag}
     *
     * @param name
     *         the name of the tag
     *
     * @return a new {@link CompoundTag}
     */
    CompoundTag newCompoundTag(String name);

    /**
     * Creates a new {@link ByteTag}
     *
     * @param value
     *         the {@code byte} value
     *
     * @return a new {@link ByteTag}
     */
    ByteTag newByteTag(byte value);

    /**
     * Creates a new {@link ByteArrayTag}
     *
     * @param value
     *         the {@code byte[]} value
     *
     * @return a new {@link ByteArrayTag}
     */
    ByteArrayTag newByteArrayTag(byte[] value);

    /**
     * Creates a new {@link DoubleTag}
     *
     * @param value
     *         the {@code double} value
     *
     * @return a new {@link DoubleTag}
     */
    DoubleTag newDoubleTag(double value);

    /**
     * Creates a new {@link FloatTag}
     *
     * @param value
     *         the {@code float} value
     *
     * @return a new {@link FloatTag}
     */
    FloatTag newFloatTag(float value);

    /**
     * Creates a new {@link IntTag}
     *
     * @param value
     *         the {@code int} value
     *
     * @return a new {@link IntTag}
     */
    IntTag newIntTag(int value);

    /**
     * Creates a new {@link IntArrayTag}
     *
     * @param value
     *         the {@code int[]} value
     *
     * @return a new {@link IntArrayTag}
     */
    IntArrayTag newIntArrayTag(int[] value);

    /**
     * Creates a new {@link ListTag}
     *
     * @return a new {@link ListTag}
     */
    <E extends BaseTag> ListTag<E> newListTag();

    /**
     * Creates a new {@link LongTag}
     *
     * @param value
     *         the {@code long} value
     *
     * @return a new {@link LongTag}
     */
    LongTag newLongTag(long value);

    /**
     * Creates a new {@link ShortTag}
     *
     * @param value
     *         the {@code short} value
     *
     * @return a new {@link ShortTag}
     */
    ShortTag newShortTag(short value);

    /**
     * Creates a new {@link StringTag}
     *
     * @param value
     *         the {@code String} value
     *
     * @return a new {@link StringTag}
     */
    StringTag newStringTag(String value);

    /**
     * Creates a new {@link BaseTag} from the specifed type (unless type is UNKNOWN)
     *
     * @param type
     *         the {@link NBTTagType} to create
     * @param value
     *         the value of the tag if needed
     *
     * @return new {@link BaseTag} or null if invalid
     */
    BaseTag newTagFromType(NBTTagType type, Object value);

    /**
     * Creates a new {@link BaseTag} from the specifed JSON string
     *
     * @param json
     *         the json string
     *
     * @return new {@link BaseTag} or {@code null} if the json syntax is incorrect
     */
    BaseTag newTagFromJSON(String json);
}
