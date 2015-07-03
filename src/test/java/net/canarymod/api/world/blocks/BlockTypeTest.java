package net.canarymod.api.world.blocks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test BlockType
 *
 * @author Todd (Rusli)
 */
public class BlockTypeTest {
    @Test
    public void testFromString() {
        BlockType bt = BlockType.fromString("minecraft:dirt");
        assertEquals("minecraft:dirt", bt.getMachineName());
        assertEquals(3, bt.getId());
        assertEquals(0, bt.getData());

        bt = BlockType.fromString("minecraft:foo");
        assertNull(bt);

        bt = BlockType.fromString(null);
        assertNull(bt);
    }

    @Test
    public void testFromStringDataAppended() {
        BlockType btd = BlockType.fromString("minecraft:stone:1");
        assertEquals(BlockType.Granite, btd);
        assertEquals("minecraft:stone", btd.getMachineName());
        assertEquals(1, btd.getId());
        assertEquals(1, btd.getData());
    }

    @Test
    public void testDeprecatedTypes() {
        BlockType depbt = BlockType.fromString("minecraft:planks:0");
        assertEquals(BlockType.OakPlanks, depbt);
        assertEquals(BlockType.OakWood, depbt);

        depbt = BlockType.fromString("minecraft:planks:1");
        assertEquals(BlockType.SprucePlanks, depbt);
        assertEquals(BlockType.SpruceWood, depbt);

        depbt = BlockType.fromString("minecraft:planks:2");
        assertEquals(BlockType.BirchPlanks, depbt);
        assertEquals(BlockType.BirchWood, depbt);

        depbt = BlockType.fromString("minecraft:planks:3");
        assertEquals(BlockType.JunglePlanks, depbt);
        assertEquals(BlockType.JungleWood, depbt);

        depbt = BlockType.fromString("minecraft:planks:4");
        assertEquals(BlockType.AcaciaPlanks, depbt);
        assertEquals(BlockType.AcaciaWood, depbt);

        depbt = BlockType.fromString("minecraft:planks:5");
        assertEquals(BlockType.DarkOakPlanks, depbt);
        assertEquals(BlockType.DarkOakWood, depbt);
    }

    @Test
    public void testFromStringAndData() {
        BlockType bt = BlockType.fromStringAndData("minecraft:dirt", 2);
        assertEquals("minecraft:dirt", bt.getMachineName());
        assertEquals(3, bt.getId());
        assertEquals(2, bt.getData());

        bt = BlockType.fromStringAndData("minecraft:foo", 0);
        assertNull(bt);

        bt = BlockType.fromStringAndData(null, 0);
        assertNull(bt);
    }

    @Test
    public void testFromId() {
        BlockType bt = BlockType.fromId(3);
        assertEquals("minecraft:dirt", bt.getMachineName());
        assertEquals(3, bt.getId());
        assertEquals(0, bt.getData());

        bt = BlockType.fromId(42);
        assertEquals("minecraft:iron_block", bt.getMachineName());
        assertEquals(42, bt.getId());
        assertEquals(0, bt.getData());

        bt = BlockType.fromId(-1);
        assertNull(bt);

        bt = BlockType.fromId(500);
        assertNull(bt);
    }

    @Test
    public void testFromIdAndData() {
        BlockType bt = BlockType.fromIdAndData(3, 2);
        assertEquals("minecraft:dirt", bt.getMachineName());
        assertEquals(3, bt.getId());
        assertEquals(2, bt.getData());

        bt = BlockType.fromIdAndData(3, 5);
        assertNull(bt);

        bt = BlockType.fromIdAndData(-1, 0);
        assertNull(bt);

        bt = BlockType.fromIdAndData(500, 0);
        assertNull(bt);
    }
}
