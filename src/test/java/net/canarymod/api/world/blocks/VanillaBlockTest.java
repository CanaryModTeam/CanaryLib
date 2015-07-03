package net.canarymod.api.world.blocks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * VanillaBlock translations test
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class VanillaBlockTest {

    @Test
    public void testVanillaBlockTranslations() {
        for (VanillaBlock vanillaBlock : VanillaBlock.values()) {
            BlockType blockType = vanillaBlock.getType();
            if (vanillaBlock.equals(VanillaBlock.NULL)) {
                assertNull(blockType);
                assertEquals(VanillaBlock.NULL, VanillaBlock.enumerate(blockType));
                continue;
            }
            assertNotNull("BlockType failure with VanillaBlock." + vanillaBlock.name(), blockType);
            assertEquals("Enumerate failure with VanillaBlock." + vanillaBlock.name(), vanillaBlock, VanillaBlock.enumerate(blockType));
        }
    }
}
