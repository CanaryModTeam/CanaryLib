package net.canarymod.api.inventory;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Item Types
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public final class ItemType {
    /* Blocks */
    // Air not present, because Mojang
    public static final ItemType Stone = new ItemType(1, true, "minecraft:stone");
    public static final ItemType Granite = new ItemType(1, 1, true, "minecraft:stone");
    public static final ItemType PolishedGranite = new ItemType(1, 2, true, "minecraft:stone");
    public static final ItemType Diorite = new ItemType(1, 3, true, "minecraft:stone");
    public static final ItemType PolishedDiorite = new ItemType(1, 4, true, "minecraft:stone");
    public static final ItemType Andesite = new ItemType(1, 5, true, "minecraft:stone");
    public static final ItemType PolishedAndesite = new ItemType(1, 6, true, "minecraft:stone");
    public static final ItemType Grass = new ItemType(2, true, "minecraft:grass");
    public static final ItemType Dirt = new ItemType(3, 0, "minecraft:dirt");
    public static final ItemType CoarseDirt = new ItemType(3, 1, "minecraft:dirt");
    public static final ItemType Podzol = new ItemType(3, 2, true, "minecraft:dirt");
    public static final ItemType Cobble = new ItemType(4, true, "minecraft:cobblestone");
    public static final ItemType OakWood = new ItemType(5, 0, true, "minecraft:planks");
    public static final ItemType SpruceWood = new ItemType(5, 1, true, "minecraft:planks");
    public static final ItemType BirchWood = new ItemType(5, 2, true, "minecraft:planks");
    public static final ItemType JungleWood = new ItemType(5, 3, true, "minecraft:planks");
    public static final ItemType AcaciaWood = new ItemType(5, 4, true, "minecraft:planks");
    public static final ItemType DarkOakWood = new ItemType(5, 5, true, "minecraft:planks");
    public static final ItemType OakSapling = new ItemType(6, 0, true, "minecraft:sapling");
    public static final ItemType SpruceSapling = new ItemType(6, 1, true, "minecraft:sapling");
    public static final ItemType BirchSapling = new ItemType(6, 2, true, "minecraft:sapling");
    public static final ItemType JungleSapling = new ItemType(6, 3, true, "minecraft:sapling");
    public static final ItemType AcaciaSapling = new ItemType(6, 4, true, "minecraft:sapling");
    public static final ItemType DarkOakSapling = new ItemType(6, 5, true, "minecraft:sapling");
    public static final ItemType Bedrock = new ItemType(7, true, "minecraft:bedrock");
    public static final ItemType WaterFlowing = new ItemType(8, true, "minecraft:flowing_water");
    public static final ItemType Water = new ItemType(9, true, "minecraft:water");
    public static final ItemType LavaFlowing = new ItemType(10, true, "minecraft:flowing_lava");
    public static final ItemType Lava = new ItemType(11, true, "minecraft:lava");
    public static final ItemType Sand = new ItemType(12, true, "minecraft:sand");
    public static final ItemType Gravel = new ItemType(13, true, "minecraft:gravel");
    public static final ItemType GoldOre = new ItemType(14, true, "minecraft:gold_ore");
    public static final ItemType IronOre = new ItemType(15, true, "minecraft:iron_ore");
    public static final ItemType CoalOre = new ItemType(16, true, "minecraft:coal_ore");
    public static final ItemType OakLog = new ItemType(17, 0, true, "minecraft:log");
    public static final ItemType PineLog = new ItemType(17, 1, true, "minecraft:log");
    public static final ItemType BirchLog = new ItemType(17, 2, true, "minecraft:log");
    public static final ItemType JungleLog = new ItemType(17, 3, true, "minecraft:log");
    public static final ItemType OakLeaves = new ItemType(18, 0, true, "minecraft:leaves");
    public static final ItemType PineLeaves = new ItemType(18, 1, true, "minecraft:leaves");
    public static final ItemType BirchLeaves = new ItemType(18, 2, true, "minecraft:leaves");
    public static final ItemType JungleLeaves = new ItemType(18, 3, true, "minecraft:leaves");
    public static final ItemType Sponge = new ItemType(19, true, "minecraft:sponge"); // THE SPONGE IS A LIE!
    public static final ItemType Glass = new ItemType(20, true, "minecraft:glass");
    public static final ItemType LapislazuliOre = new ItemType(21, true, "minecraft:lapis_ore");
    public static final ItemType LapisBlock = new ItemType(22, true, "minecraft:lapis_block");
    public static final ItemType Dispenser = new ItemType(23, true, "minecraft:dispenser");
    public static final ItemType Sandstone = new ItemType(24, 0, true, "minecraft:sandstone");
    public static final ItemType SandstoneOrnate = new ItemType(24, 1, true, "minecraft:sandstone");
    public static final ItemType SandstoneBlank = new ItemType(24, 2, true, "minecraft:sandstone");
    public static final ItemType NoteBlock = new ItemType(25, true, "minecraft:noteblock");
    // Bed not present, because Mojang
    public static final ItemType PoweredRail = new ItemType(27, true, "minecraft:golden_rail");
    public static final ItemType DetectorRail = new ItemType(28, true, "minecraft:detector_rail");
    public static final ItemType StickyPiston = new ItemType(29, true, "minecraft:sticky_piston");
    public static final ItemType SpiderWeb = new ItemType(30, true, "minecraft:web");
    public static final ItemType Shrub = new ItemType(31, 0, true, "minecraft:tallgrass");
    public static final ItemType TallGrass = new ItemType(31, 1, true, "minecraft:tallgrass");
    public static final ItemType TallFern = new ItemType(31, 2, true, "minecraft:tallgrass");
    public static final ItemType DeadBush = new ItemType(32, 0, "minecraft:deadbush");
    public static final ItemType Piston = new ItemType(33, true, "minecraft:piston");
    // Piston head not present, because Mojang
    public static final ItemType WoolWhite = new ItemType(35, 0, true, "minecraft:wool");
    public static final ItemType WoolOrange = new ItemType(35, 1, true, "minecraft:wool");
    public static final ItemType WoolMagenta = new ItemType(35, 2, true, "minecraft:wool");
    public static final ItemType WoolLightBlue = new ItemType(35, 3, true, "minecraft:wool");
    public static final ItemType WoolYellow = new ItemType(35, 4, true, "minecraft:wool");
    public static final ItemType WoolLightGreen = new ItemType(35, 5, true, "minecraft:wool");
    public static final ItemType WoolPink = new ItemType(35, 6, true, "minecraft:wool");
    public static final ItemType WoolGray = new ItemType(35, 7, true, "minecraft:wool");
    public static final ItemType WoolLightGray = new ItemType(35, 8, true, "minecraft:wool");
    public static final ItemType WoolCyan = new ItemType(35, 9, true, "minecraft:wool");
    public static final ItemType WoolPurple = new ItemType(35, 10, true, "minecraft:wool");
    public static final ItemType WoolBlue = new ItemType(35, 11, true, "minecraft:wool");
    public static final ItemType WoolBrown = new ItemType(35, 12, true, "minecraft:wool");
    public static final ItemType WoolDarkGreen = new ItemType(35, 13, true, "minecraft:wool");
    public static final ItemType WoolRed = new ItemType(35, 14, true, "minecraft:wool");
    public static final ItemType WoolBlack = new ItemType(35, 15, true, "minecraft:wool");
    // Piston extension not present, because Mojang
    public static final ItemType YellowFlower = new ItemType(37, true, "minecraft:yellow_flower");
    public static final ItemType Poppy = new ItemType(38, 0, true, "minecraft:red_flower");
    public static final ItemType BlueOrchid = new ItemType(38, 1, true, "minecraft:red_flower");
    public static final ItemType Allium = new ItemType(38, 2, true, "minecraft:red_flower");
    public static final ItemType AzureBluet = new ItemType(38, 3, true, "minecraft:red_flower");
    public static final ItemType RedTulip = new ItemType(38, 4, true, "minecraft:red_flower");
    public static final ItemType OrangeTulip = new ItemType(38, 5, true, "minecraft:red_flower");
    public static final ItemType WhiteTulip = new ItemType(38, 6, true, "minecraft:red_flower");
    public static final ItemType PinkTulip = new ItemType(38, 7, true, "minecraft:red_flower");
    public static final ItemType OxeyeDaisy = new ItemType(38, 8, true, "minecraft:red_flower");
    public static final ItemType BrownMushroom = new ItemType(39, true, "minecraft:brown_mushroom");
    public static final ItemType RedMushroom = new ItemType(40, true, "minecraft:red_mushroom");
    public static final ItemType GoldBlock = new ItemType(41, true, "minecraft:gold_block");
    public static final ItemType IronBlock = new ItemType(42, true, "minecraft:iron_block");
    public static final ItemType DoubleOrnateStoneSlab = new ItemType(43, 0, true, "minecraft:double_stone_slab");
    public static final ItemType DoubleSandStoneTrimSlab = new ItemType(43, 1, true, "minecraft:double_stone_slab");
    public static final ItemType DoubleWoodSlab = new ItemType(43, 2, true, "minecraft:double_stone_slab");
    public static final ItemType DoubleCobbleSlab = new ItemType(43, 3, true, "minecraft:double_stone_slab");
    public static final ItemType DoubleBrickBlockSlab = new ItemType(43, 4, true, "minecraft:double_stone_slab");
    public static final ItemType DoubleStoneBricksSlab = new ItemType(43, 5, true, "minecraft:double_stone_slab");
    public static final ItemType DoubleNetherBrickSlab = new ItemType(43, 6, true, "minecraft:double_stone_slab");
    public static final ItemType DoubleQuartzSlab = new ItemType(43, 9, true, "minecraft:double_stone_slab");
    public static final ItemType DoubleStoneSlab = new ItemType(43, 8, true, "minecraft:double_stone_slab");
    public static final ItemType DoubleSandstoneSlab = new ItemType(43, 11, true, "minecraft:double_stone_slab");
    public static final ItemType OrnateStoneSlab = new ItemType(44, 0, true, "minecraft:stone_slab");
    public static final ItemType SandStoneTrimSlab = new ItemType(44, 1, true, "minecraft:stone_slab");
    public static final ItemType WoodSlab = new ItemType(44, 2, true, "minecraft:stone_slab");
    public static final ItemType CobbleSlab = new ItemType(44, 3, true, "minecraft:stone_slab");
    public static final ItemType BrickSlab = new ItemType(44, 4, true, "minecraft:stone_slab");
    public static final ItemType StoneBricksSlab = new ItemType(44, 5, true, "minecraft:stone_slab");
    public static final ItemType NetherBricksSlab = new ItemType(44, 6, true, "minecraft:stone_slab");
    public static final ItemType QuartzSlab = new ItemType(44, 7, true, "minecraft:stone_slab");
    public static final ItemType StoneSlab = new ItemType(44, 10, true, "minecraft:stone_slab");
    public static final ItemType SandstoneSlab = new ItemType(44, 11, true, "minecraft:stone_slab");
    public static final ItemType BrickBlock = new ItemType(45, true, "minecraft:brick_block");
    public static final ItemType Tnt = new ItemType(46, true, "minecraft:tnt");
    public static final ItemType Bookshelf = new ItemType(47, true, "minecraft:bookshelf");
    public static final ItemType MossyCobble = new ItemType(48, true, "minecraft:mossy_cobblestone");
    public static final ItemType Obsidian = new ItemType(49, true, "minecraft:obsidian");
    public static final ItemType Torch = new ItemType(50, true, "minecraft:torch");
    public static final ItemType FireBlock = new ItemType(51, true, "minecraft:fire");
    public static final ItemType MobSpawner = new ItemType(52, true, "minecraft:mob_spawner");
    public static final ItemType WoodenStairs = new ItemType(53, true, "minecraft:oak_stairs");
    public static final ItemType Chest = new ItemType(54, true, "minecraft:chest");
    // Redstone wire not present, because Mojang
    public static final ItemType DiamondOre = new ItemType(56, true, "minecraft:diamond_ore");
    public static final ItemType DiamondBlock = new ItemType(57, true, "minecraft:diamond_block");
    public static final ItemType Workbench = new ItemType(58, true, "minecraft:crafting_table");
    // Wheat not present, because Mojang
    public static final ItemType Soil = new ItemType(60, true, "minecraft:farmland");
    public static final ItemType Furnace = new ItemType(61, true, "minecraft:furnace");
    public static final ItemType BurningFurnace = new ItemType(62, true, "minecraft:lit_furnace");
    // Standing sign not present, because Mojang
    // Wooden door not present, because Mojang
    public static final ItemType Ladder = new ItemType(65, true, "minecraft:ladder");
    public static final ItemType Rail = new ItemType(66, true, "minecraft:rail");
    public static final ItemType CobbleStairs = new ItemType(67, true, "minecraft:stone_stairs");
    // Wall sign not present, because Mojang
    public static final ItemType Lever = new ItemType(69, true, "minecraft:lever");
    public static final ItemType StonePlate = new ItemType(70, true, "minecraft:stone_pressure_plate");
    // Iron door not present, because Mojang
    public static final ItemType WoodPlate = new ItemType(72, true, "minecraft:wooden_pressure_plate");
    public static final ItemType RedstoneOre = new ItemType(73, true, "minecraft:redstone_ore");
    // Lit redstone ore not present, because Mojang
    // Unlit redstone torch not present, because Mojang
    public static final ItemType RedstoneTorchOn = new ItemType(76, true, "minecraft:redstone_torch");
    public static final ItemType StoneButton = new ItemType(77, true, "minecraft:stone_button");
    public static final ItemType Snow = new ItemType(78, true, "minecraft:snow_layer");
    public static final ItemType Ice = new ItemType(79, true, "minecraft:ice");
    public static final ItemType SnowBlock = new ItemType(80, true, "minecraft:snow");
    public static final ItemType Cactus = new ItemType(81, true, "minecraft:cactus");
    public static final ItemType Clay = new ItemType(82, true, "minecraft:clay");
    // Reeds not present, because Mojang
    public static final ItemType Jukebox = new ItemType(84, true, "minecraft:jukebox");
    public static final ItemType Fence = new ItemType(85, true, "minecraft:fence");
    public static final ItemType Pumpkin = new ItemType(86, true, "minecraft:pumpkin");
    public static final ItemType Netherrack = new ItemType(87, true, "minecraft:netherrack");
    public static final ItemType SoulSand = new ItemType(88, true, "minecraft:soul_sand");
    public static final ItemType GlowStone = new ItemType(89, true, "minecraft:glowstone");
    public static final ItemType Portal = new ItemType(90, true, "minecraft:portal");
    public static final ItemType JackOLantern = new ItemType(91, true, "minecraft:lit_pumpkin");
    // The cake is a lie, because Mojang
    // Redstone repeater (both states) not present, because Mojang
    public static final ItemType WhiteGlass = new ItemType(95, 0, true, "minecraft:stained_glass");
    public static final ItemType OrangeGlass = new ItemType(95, 1, true, "minecraft:stained_glass");
    public static final ItemType MagentaGlass = new ItemType(95, 2, true, "minecraft:stained_glass");
    public static final ItemType LightBlueGlass = new ItemType(95, 3, true, "minecraft:stained_glass");
    public static final ItemType YellowGlass = new ItemType(95, 4, true, "minecraft:stained_glass");
    public static final ItemType LimeGlass = new ItemType(95, 5, true, "minecraft:stained_glass");
    public static final ItemType PinkGlass = new ItemType(95, 6, true, "minecraft:stained_glass");
    public static final ItemType GrayGlass = new ItemType(95, 7, true, "minecraft:stained_glass");
    public static final ItemType LightGrayGlass = new ItemType(95, 8, true, "minecraft:stained_glass");
    public static final ItemType CyanGlass = new ItemType(95, 9, true, "minecraft:stained_glass");
    public static final ItemType PurpleGlass = new ItemType(95, 10, true, "minecraft:stained_glass");
    public static final ItemType BlueGlass = new ItemType(95, 11, true, "minecraft:stained_glass");
    public static final ItemType BrownGlass = new ItemType(95, 12, true, "minecraft:stained_glass");
    public static final ItemType GreenGlass = new ItemType(95, 13, true, "minecraft:stained_glass");
    public static final ItemType RedGlass = new ItemType(95, 14, true, "minecraft:stained_glass");
    public static final ItemType BlackGlass = new ItemType(95, 15, true, "minecraft:stained_glass");
    public static final ItemType Trapdoor = new ItemType(96, true, "minecraft:trapdoor");
    public static final ItemType StoneSilverFishBlock = new ItemType(97, 0, true, "minecraft:monster_egg");
    public static final ItemType CobbleSilverFishBlock = new ItemType(97, 1, true, "minecraft:monster_egg");
    public static final ItemType StoneBrickSilverFishBlock = new ItemType(97, 2, true, "minecraft:monster_egg");
    public static final ItemType MossyBrickSilverFishBlock = new ItemType(97, 3, true, "minecraft:monster_egg");
    public static final ItemType CrackedSilverFishBlock = new ItemType(97, 4, true, "minecraft:monster_egg");
    public static final ItemType OrnateSilverFishBlock = new ItemType(97, 5, true, "minecraft:monster_egg");
    public static final ItemType StoneBrick = new ItemType(98, 0, true, "minecraft:stonebrick");
    public static final ItemType MossyStoneBrick = new ItemType(98, 1, true, "minecraft:stonebrick");
    public static final ItemType CrackedStoneBrick = new ItemType(98, 2, true, "minecraft:stonebrick");
    public static final ItemType OrnateStoneBrick = new ItemType(98, 3, true, "minecraft:stonebrick");
    public static final ItemType HugeBrownMushroom = new ItemType(99, true, "minecraft:brown_mushroom_block");
    public static final ItemType HugeRedMushroom = new ItemType(100, true, "minecraft:red_mushroom_block");
    public static final ItemType IronBars = new ItemType(101, true, "minecraft:iron_bars");
    public static final ItemType GlassPane = new ItemType(102, true, "minecraft:glass_pane");
    public static final ItemType Melon = new ItemType(103, true, "minecraft:melon_block");
    // Melon and pumpkin stem not present, because Mojang
    public static final ItemType Vines = new ItemType(106, true, "minecraft:vine");
    public static final ItemType FenceGate = new ItemType(107, true, "minecraft:fence_gate");
    public static final ItemType BrickStairs = new ItemType(108, true, "minecraft:brick_stairs");
    public static final ItemType StoneBrickStairs = new ItemType(109, true, "minecraft:stone_brick_stairs");
    public static final ItemType Mycelium = new ItemType(110, true, "minecraft:mycelium");
    public static final ItemType Lilypad = new ItemType(111, true, "minecraft:waterlily");
    public static final ItemType NetherBrick = new ItemType(112, true, "minecraft:nether_brick");
    public static final ItemType NetherBrickFence = new ItemType(113, true, "minecraft:nether_brick_fence");
    public static final ItemType NetherBrickStairs = new ItemType(114, true, "minecraft:nether_brick_stairs");
    // Nether wart not present, because Mojang
    public static final ItemType EnchantmentTable = new ItemType(116, true, "minecraft:enchanting_table");
    // Brewing stand and cauldron not present, because Mojang
    public static final ItemType EndPortal = new ItemType(119, true, "minecraft:end_portal");
    public static final ItemType EndPortalFrame = new ItemType(120, true, "minecraft:end_portal_frame");
    public static final ItemType EndStone = new ItemType(121, true, "minecraft:end_stone");
    public static final ItemType EnderDragonEgg = new ItemType(122, true, "minecraft:dragon_egg");
    public static final ItemType RedstoneLampOff = new ItemType(123, true, "minecraft:redstone_lamp");
    // Lit redstone lamp not present, because Mojang
    public static final ItemType DoubleOakWoodSlab = new ItemType(125, 0, true, "minecraft:double_wooden_slab");
    public static final ItemType DoubleSpruceWoodSlab = new ItemType(125, 1, true, "minecraft:double_wooden_slab");
    public static final ItemType DoubleBirchWoodSlab = new ItemType(125, 2, true, "minecraft:double_wooden_slab");
    public static final ItemType DoubleJungleWoodSlab = new ItemType(125, 3, true, "minecraft:double_wooden_slab");
    public static final ItemType DoubleAcaciaWoodSlab = new ItemType(125, 4, true, "minecraft:double_wooden_slab");
    public static final ItemType DoubleDarkOakWoodSlab = new ItemType(125, 5, true, "minecraft:double_wooden_slab");
    public static final ItemType OakWoodSlab = new ItemType(126, 0, true, "minecraft:wooden_slab");
    public static final ItemType SpruceWoodSlab = new ItemType(126, 1, true, "minecraft:wooden_slab");
    public static final ItemType BirchWoodSlab = new ItemType(126, 2, true, "minecraft:wooden_slab");
    public static final ItemType JungleWoodSlab = new ItemType(126, 3, true, "minecraft:wooden_slab");
    public static final ItemType AcaciaWoodSlab = new ItemType(126, 4, true, "minecraft:wooden_slab");
    public static final ItemType DarkOakWoodSlab = new ItemType(126, 5, true, "minecraft:wooden_slab");
    public static final ItemType CocoaPlant = new ItemType(127, true, "minecraft:cocoa");
    public static final ItemType SandstoneStairs = new ItemType(128, true, "minecraft:sandstone_stairs");
    public static final ItemType EmeraldOre = new ItemType(129, true, "minecraft:emerald_ore");
    public static final ItemType EnderChest = new ItemType(130, true, "minecraft:ender_chest");
    public static final ItemType TripwireHook = new ItemType(131, true, "minecraft:tripwire_hook");
    // Tripwire not present, because Mojang
    public static final ItemType EmeraldBlock = new ItemType(133, true, "minecraft:emerald_block");
    public static final ItemType PineWoodStairs = new ItemType(134, true, "minecraft:spruce_stairs");
    public static final ItemType BirchWoodStairs = new ItemType(135, true, "minecraft:birch_stairs");
    public static final ItemType JungleWoodStairs = new ItemType(136, true, "minecraft:jungle_stairs");
    public static final ItemType CommandBlock = new ItemType(137, true, "minecraft:command_block");
    public static final ItemType Beacon = new ItemType(138, true, "minecraft:beacon");
    public static final ItemType CobblestoneWall = new ItemType(139, 0, true, "minecraft:cobblestone_wall");
    public static final ItemType MossyCobbleWall = new ItemType(139, 1, true, "minecraft:cobblestone_wall");
    // Flower pot not present, because Mojang
    public static final ItemType Carrots = new ItemType(141, true, "minecraft:carrots");
    public static final ItemType Potatoes = new ItemType(142, true, "minecraft:potatoes");
    public static final ItemType WoodenButton = new ItemType(143, true, "minecraft:wooden_button");
    // Skull (any type) not present, because Mojang
    public static final ItemType Anvil = new ItemType(145, true, "minecraft:anvil");
    public static final ItemType TrappedChest = new ItemType(146, true, "minecraft:trapped_chest");
    public static final ItemType LightWeightedPressurePlate = new ItemType(147, true, "minecraft:light_weighted_pressure_plate");
    public static final ItemType HeavyWeightedPressurePlate = new ItemType(148, true, "minecraft:heavy_weighted_pressure_plate");
    // Powered and unpowered comparator not present, because Mojang
    public static final ItemType DaylightSensor = new ItemType(151, true, "minecraft:daylight_detector");
    public static final ItemType RedstoneBlock = new ItemType(152, true, "minecraft:redstone_block");
    public static final ItemType NetherQuartzOre = new ItemType(153, true, "minecraft:quartz_ore");
    public static final ItemType Hopper = new ItemType(154, true, "minecraft:hopper");
    public static final ItemType QuartzBlock = new ItemType(155, 0, true, "minecraft:quartz_block");
    public static final ItemType OrnateQuartzBlock = new ItemType(155, 1, true, "minecraft:quartz_block");
    public static final ItemType QuartzPillarVertical = new ItemType(155, 2, true, "minecraft:quartz_block");
    public static final ItemType QuartzPillarHorizontal = new ItemType(155, 3, true, "minecraft:quartz_block");
    public static final ItemType QuartzPillarCap = new ItemType(155, 4, true, "minecraft:quartz_block");
    public static final ItemType QuartzStairs = new ItemType(156, true, "minecraft:quartz_stairs");
    public static final ItemType ActivatorRail = new ItemType(157, true, "minecraft:activator_rail");
    public static final ItemType Dropper = new ItemType(158, true, "minecraft:dropper");
    public static final ItemType WhiteStainedClay = new ItemType(159, 0, true, "minecraft:stained_hardened_clay");
    public static final ItemType OrangeStainedClay = new ItemType(159, 1, true, "minecraft:stained_hardened_clay");
    public static final ItemType MagentaStainedClay = new ItemType(159, 2, true, "minecraft:stained_hardened_clay");
    public static final ItemType LightBlueStainedClay = new ItemType(159, 3, true, "minecraft:stained_hardened_clay");
    public static final ItemType YellowStainedClay = new ItemType(159, 4, true, "minecraft:stained_hardened_clay");
    public static final ItemType LimeStainedClay = new ItemType(159, 5, true, "minecraft:stained_hardened_clay");
    public static final ItemType PinkStainedClay = new ItemType(159, 6, true, "minecraft:stained_hardened_clay");
    public static final ItemType GrayStainedClay = new ItemType(159, 7, true, "minecraft:stained_hardened_clay");
    public static final ItemType LightGrayStainedClay = new ItemType(159, 8, true, "minecraft:stained_hardened_clay");
    public static final ItemType CyanStainedClay = new ItemType(159, 9, true, "minecraft:stained_hardened_clay");
    public static final ItemType PurpleStainedClay = new ItemType(159, 10, true, "minecraft:stained_hardened_clay");
    public static final ItemType BlueStainedClay = new ItemType(159, 11, true, "minecraft:stained_hardened_clay");
    public static final ItemType BrownStainedClay = new ItemType(159, 12, true, "minecraft:stained_hardened_clay");
    public static final ItemType GreenStainedClay = new ItemType(159, 13, true, "minecraft:stained_hardened_clay");
    public static final ItemType RedStainedClay = new ItemType(159, 14, true, "minecraft:stained_hardened_clay");
    public static final ItemType BlackStainedClay = new ItemType(159, 15, true, "minecraft:stained_hardened_clay");
    public static final ItemType WhiteGlassPane = new ItemType(160, 0, true, "minecraft:stained_glass_pane");
    public static final ItemType OrangeGlassPane = new ItemType(160, 1, true, "minecraft:stained_glass_pane");
    public static final ItemType MagentaGlassPane = new ItemType(160, 2, true, "minecraft:stained_glass_pane");
    public static final ItemType LightBlueGlassPane = new ItemType(160, 3, true, "minecraft:stained_glass_pane");
    public static final ItemType YellowGlassPane = new ItemType(160, 4, true, "minecraft:stained_glass_pane");
    public static final ItemType LimeGlassPane = new ItemType(160, 5, true, "minecraft:stained_glass_pane");
    public static final ItemType PinkGlassPane = new ItemType(160, 6, true, "minecraft:stained_glass_pane");
    public static final ItemType GrayGlassPane = new ItemType(160, 7, true, "minecraft:stained_glass_pane");
    public static final ItemType LightGrayGlassPane = new ItemType(160, 8, true, "minecraft:stained_glass_pane");
    public static final ItemType CyanGlassPane = new ItemType(160, 9, true, "minecraft:stained_glass_pane");
    public static final ItemType PurpleGlassPane = new ItemType(160, 10, true, "minecraft:stained_glass_pane");
    public static final ItemType BlueGlassPane = new ItemType(160, 11, true, "minecraft:stained_glass_pane");
    public static final ItemType BrownGlassPane = new ItemType(160, 12, true, "minecraft:stained_glass_pane");
    public static final ItemType GreenGlassPane = new ItemType(160, 13, true, "minecraft:stained_glass_pane");
    public static final ItemType RedGlassPane = new ItemType(160, 14, true, "minecraft:stained_glass_pane");
    public static final ItemType BlackGlassPane = new ItemType(160, 15, true, "minecraft:stained_glass_pane");
    public static final ItemType AcaciaLeaves = new ItemType(161, true, "minecraft:leaves2");
    public static final ItemType DarkOakLeaves = new ItemType(161, 1, true, "minecraft:leaves2");
    public static final ItemType AcaciaLog = new ItemType(162, true, "minecraft:log2");
    public static final ItemType DarkOakLog = new ItemType(162, 1, true, "minecraft:log2");
    public static final ItemType AcaciaStairs = new ItemType(163, true, "minecraft:acacia_stairs");
    public static final ItemType DarkOakStairs = new ItemType(164, true, "minecraft:dark_oak_stairs");
    public static final ItemType HayBale = new ItemType(170, true, "minecraft:hay_block");
    public static final ItemType WhiteCarpet = new ItemType(171, 0, true, "minecraft:carpet");
    public static final ItemType OrangeCarpet = new ItemType(171, 1, true, "minecraft:carpet");
    public static final ItemType MagentaCarpet = new ItemType(171, 2, true, "minecraft:carpet");
    public static final ItemType LightBlueCarpet = new ItemType(171, 3, true, "minecraft:carpet");
    public static final ItemType YellowCarpet = new ItemType(171, 4, true, "minecraft:carpet");
    public static final ItemType LimeCarpet = new ItemType(171, 5, true, "minecraft:carpet");
    public static final ItemType PinkCarpet = new ItemType(171, 6, true, "minecraft:carpet");
    public static final ItemType GrayCarpet = new ItemType(171, 7, true, "minecraft:carpet");
    public static final ItemType LightGrayCarpet = new ItemType(171, 8, true, "minecraft:carpet");
    public static final ItemType CyanCarpet = new ItemType(171, 9, true, "minecraft:carpet");
    public static final ItemType PurpleCarpet = new ItemType(171, 10, true, "minecraft:carpet");
    public static final ItemType BlueCarpet = new ItemType(171, 11, true, "minecraft:carpet");
    public static final ItemType BrownCarpet = new ItemType(171, 12, true, "minecraft:carpet");
    public static final ItemType GreenCarpet = new ItemType(171, 13, true, "minecraft:carpet");
    public static final ItemType RedCarpet = new ItemType(171, 14, true, "minecraft:carpet");
    public static final ItemType BlackCarpet = new ItemType(171, 15, true, "minecraft:carpet");
    public static final ItemType HardenedClay = new ItemType(172, true, "minecraft:hardened_clay");
    public static final ItemType CoalBlock = new ItemType(173, true, "minecraft:coal_block");
    public static final ItemType PackedIce = new ItemType(174, true, "minecraft:packed_ice");
    public static final ItemType Sunflower = new ItemType(175, true, "minecraft:double_plant");
    public static final ItemType Lilac = new ItemType(175, 1, true, "minecraft:double_plant");
    public static final ItemType DoubleGrass = new ItemType(175, 2, true, "minecraft:double_plant");
    public static final ItemType LargeFern = new ItemType(175, 3, true, "minecraft:double_plant");
    public static final ItemType RoseBush = new ItemType(175, 4, true, "minecraft:double_plant");
    public static final ItemType Peony = new ItemType(175, 5, true, "minecraft:double_plant");
    // Standing Banner not present cause Mojang (176
    // Wall Banner not present cause Mojang (177
    // DaylightSensorInverted not present cause Mojang (178
    public static final ItemType RedSandstone = new ItemType(179, 0, true, "minecraft:red_sandstone");
    public static final ItemType RedSandstoneOrnate = new ItemType(179, 1, true, "minecraft:red_sandstone");
    public static final ItemType RedSandstoneBlank = new ItemType(179, 2, true, "minecraft:red_sandstone");
    public static final ItemType RedSandstoneStairs = new ItemType(180, true, "minecraft_red_sandstone_stairs");
    public static final ItemType RedSandstoneSlab = new ItemType(181, true, "minecraft:stone_slab2");
    public static final ItemType DoubleRedSandstoneSlab = new ItemType(182, true, "minecraft:double_stone_slab2");
    public static final ItemType SpruceFenceGate = new ItemType(183, true, "minecraft:spruce_fence_gate");
    public static final ItemType BirchFenceGate = new ItemType(184, true, "minecraft:birch_fence_gate");
    public static final ItemType JungleFenceGate = new ItemType(185, true, "minecraft:jungle_fence_gate");
    public static final ItemType DarkOakFenceGate = new ItemType(186, true, "minecraft:dark_oak_fence_gate");
    public static final ItemType AcaciaFenceGate = new ItemType(187, true, "minecraft:acacia_fence_gate");
    public static final ItemType SpruceFence = new ItemType(188, true, "minecraft:spruce_fence");
    public static final ItemType BirchFence = new ItemType(189, true, "minecraft:birch_fence");
    public static final ItemType JungleFence = new ItemType(190, true, "minecraft:jungle_fence");
    public static final ItemType DarkOakFence = new ItemType(191, true, "minecraft:dark_oak_fence");
    public static final ItemType AcaciaFence = new ItemType(192, true, "minecraft:acacia_fence");

    /* Items */
    public static final ItemType IronSpade = new ItemType(256, "minecraft:iron_shovel");
    public static final ItemType IronPickaxe = new ItemType(257, "minecraft:iron_pickaxe");
    public static final ItemType IronAxe = new ItemType(258, "minecraft:iron_axe");
    public static final ItemType FlintAndSteel = new ItemType(259, "minecraft:flint_and_steel");
    public static final ItemType Apple = new ItemType(260, "minecraft:apple");
    public static final ItemType Bow = new ItemType(261, "minecraft:bow");
    public static final ItemType Arrow = new ItemType(262, "minecraft:arrow");
    public static final ItemType Coal = new ItemType(263, "minecraft:coal");
    public static final ItemType Charcoal = new ItemType(263, 1, "minecraft:coal");
    public static final ItemType Diamond = new ItemType(264, "minecraft:diamond");
    public static final ItemType IronIngot = new ItemType(265, "minecraft:iron_ingot");
    public static final ItemType GoldIngot = new ItemType(266, "minecraft:gold_ingot");
    public static final ItemType IronSword = new ItemType(267, "minecraft:iron_sword");
    public static final ItemType WoodSword = new ItemType(268, "minecraft:wooden_sword");
    public static final ItemType WoodSpade = new ItemType(269, "minecraft:wooden_shovel");
    public static final ItemType WoodPickaxe = new ItemType(270, "minecraft:wooden_pickaxe");
    public static final ItemType WoodAxe = new ItemType(271, "minecraft:wooden_axe");
    public static final ItemType StoneSword = new ItemType(272, "minecraft:stone_sword");
    public static final ItemType StoneSpade = new ItemType(273, "minecraft:stone_shovel");
    public static final ItemType StonePickaxe = new ItemType(274, "minecraft:stone_pickaxe");
    public static final ItemType StoneAxe = new ItemType(275, "minecraft:stone_axe");
    public static final ItemType DiamondSword = new ItemType(276, "minecraft:diamond_sword");
    public static final ItemType DiamondSpade = new ItemType(277, "minecraft:diamond_shovel");
    public static final ItemType DiamondPickaxe = new ItemType(278, "minecraft:diamond_pickaxe");
    public static final ItemType DiamondAxe = new ItemType(279, "minecraft:diamond_axe");
    public static final ItemType Stick = new ItemType(280, "minecraft:stick");
    public static final ItemType Bowl = new ItemType(281, "minecraft:bowl");
    public static final ItemType MushroomSoup = new ItemType(282, "minecraft:mushroom_stew");
    public static final ItemType GoldSword = new ItemType(283, "minecraft:golden_sword");
    public static final ItemType GoldSpade = new ItemType(284, "minecraft:golden_shovel");
    public static final ItemType GoldPickaxe = new ItemType(285, "minecraft:golden_pickaxe");
    public static final ItemType GoldAxe = new ItemType(286, "minecraft:golden_axe");
    public static final ItemType String = new ItemType(287, "minecraft:string");
    public static final ItemType Feather = new ItemType(288, "minecraft:feather");
    public static final ItemType Gunpowder = new ItemType(289, "minecraft:gunpowder");
    public static final ItemType WoodHoe = new ItemType(290, "minecraft:wooden_hoe");
    public static final ItemType StoneHoe = new ItemType(291, "minecraft:stone_hoe");
    public static final ItemType IronHoe = new ItemType(292, "minecraft:iron_hoe");
    public static final ItemType DiamondHoe = new ItemType(293, "minecraft:diamond_hoe");
    public static final ItemType GoldHoe = new ItemType(294, "minecraft:golden_hoe");
    public static final ItemType Seeds = new ItemType(295, "minecraft:wheat_seeds");
    public static final ItemType Wheat = new ItemType(296, "minecraft:wheat");
    public static final ItemType Bread = new ItemType(297, "minecraft:bread");
    public static final ItemType LeatherHelmet = new ItemType(298, "minecraft:leather_helmet");
    public static final ItemType LeatherChestplate = new ItemType(299, "minecraft:leather_chestplate");
    public static final ItemType LeatherLeggings = new ItemType(300, "minecraft:leather_leggings");
    public static final ItemType LeatherBoots = new ItemType(301, "minecraft:leather_boots");
    public static final ItemType ChainmailHelmet = new ItemType(302, "minecraft:chainmail_helmet");
    public static final ItemType ChainmailChestplate = new ItemType(303, "minecraft:chainmail_chestplate");
    public static final ItemType ChainmailLeggings = new ItemType(304, "minecraft:chainmail_leggings");
    public static final ItemType ChainmailBoots = new ItemType(305, "minecraft:chainmail_boots");
    public static final ItemType IronHelmet = new ItemType(306, "minecraft:iron_helmet");
    public static final ItemType IronChestplate = new ItemType(307, "minecraft:iron_chestplate");
    public static final ItemType IronLeggings = new ItemType(308, "minecraft:iron_leggings");
    public static final ItemType IronBoots = new ItemType(309, "minecraft:iron_boots");
    public static final ItemType DiamondHelmet = new ItemType(310, "minecraft:diamond_helmet");
    public static final ItemType DiamondChestplate = new ItemType(311, "minecraft:diamond_chestplate");
    public static final ItemType DiamondLeggings = new ItemType(312, "minecraft:diamond_leggings");
    public static final ItemType DiamondBoots = new ItemType(313, "minecraft:diamond_boots");
    public static final ItemType GoldHelmet = new ItemType(314, "minecraft:golden_helmet");
    public static final ItemType GoldChestplate = new ItemType(315, "minecraft:golden_chestplate");
    public static final ItemType GoldLeggings = new ItemType(316, "minecraft:golden_leggings");
    public static final ItemType GoldBoots = new ItemType(317, "minecraft:golden_boots");
    public static final ItemType Flint = new ItemType(318, "minecraft:flint");
    public static final ItemType Pork = new ItemType(319, "minecraft:porkchop");
    public static final ItemType GrilledPork = new ItemType(320, "minecraft:cooked_porkchop");
    public static final ItemType Painting = new ItemType(321, "minecraft:painting");
    public static final ItemType GoldenApple = new ItemType(322, "minecraft:golden_apple");
    public static final ItemType Sign = new ItemType(323, true, "minecraft:sign");
    public static final ItemType WoodDoor = new ItemType(324, true, "minecraft:wooden_door");
    public static final ItemType Bucket = new ItemType(325, "minecraft:bucket");
    public static final ItemType WaterBucket = new ItemType(326, true, "minecraft:water_bucket");
    public static final ItemType LavaBucket = new ItemType(327, true, "minecraft:lava_bucket");
    public static final ItemType Minecart = new ItemType(328, "minecraft:minecart");
    public static final ItemType Saddle = new ItemType(329, "minecraft:saddle");
    public static final ItemType IronDoor = new ItemType(330, true, "minecraft:iron_door");
    public static final ItemType RedStone = new ItemType(331, true, "minecraft:redstone");
    public static final ItemType SnowBall = new ItemType(332, "minecraft:snowball");
    public static final ItemType OakBoat = new ItemType(333, "minecraft:boat");
    /**
     * @deprecated Being replaced by {@link OakBoat}
     */
    @Deprecated
    public static final ItemType Boat = OakBoat;
    public static final ItemType Leather = new ItemType(334, "minecraft:leather");
    public static final ItemType MilkBucket = new ItemType(335, "minecraft:milk_bucket");
    public static final ItemType ClayBrick = new ItemType(336, "minecraft:brick");
    public static final ItemType ClayBall = new ItemType(337, "minecraft:clay_ball");
    public static final ItemType Reed = new ItemType(338, true, "minecraft:reeds");
    public static final ItemType Paper = new ItemType(339, "minecraft:paper");
    public static final ItemType Book = new ItemType(340, "minecraft:book");
    public static final ItemType SlimeBall = new ItemType(341, "minecraft:slime_ball");
    public static final ItemType StorageMinecart = new ItemType(342, "minecraft:chest_minecart");
    public static final ItemType PoweredMinecart = new ItemType(343, "minecraft:furnace_minecart");
    public static final ItemType Egg = new ItemType(344, "minecraft:egg");
    public static final ItemType Compass = new ItemType(345, "minecraft:compass");
    public static final ItemType FishingRod = new ItemType(346, "minecraft:fishing_rod");
    public static final ItemType Watch = new ItemType(347, "minecraft:clock");
    public static final ItemType GlowstoneDust = new ItemType(348, "minecraft:glowstone_dust");
    public static final ItemType RawFish = new ItemType(349, 0, "minecraft:fish");
    public static final ItemType RawSalmon = new ItemType(349, 1, "minecraft:fish");
    public static final ItemType ClownFish = new ItemType(349, 2, "minecraft:fish");
    public static final ItemType PufferFish = new ItemType(349, 3, "minecraft:fish");
    public static final ItemType CookedFish = new ItemType(350, 0, "minecraft:cooked_fished");
    public static final ItemType CookedSalmon = new ItemType(350, 1, "minecraft:cooked_fished");
    public static final ItemType CookedClownFish = new ItemType(350, 2, "minecraft:cooked_fished");
    public static final ItemType CookedPufferFish = new ItemType(350, 3, "minecraft:cooked_fished");
    public static final ItemType InkSack = new ItemType(351, 0, "minecraft:dye");
    public static final ItemType RoseRed = new ItemType(351, 1, "minecraft:dye");
    public static final ItemType CactusGreen = new ItemType(351, 2, "minecraft:dye");
    public static final ItemType CocoaBeans = new ItemType(351, 3, "minecraft:dye");
    public static final ItemType LapisLazuli = new ItemType(351, 4, "minecraft:dye");
    public static final ItemType PurpleDye = new ItemType(351, 5, "minecraft:dye");
    public static final ItemType CyanDye = new ItemType(351, 6, "minecraft:dye");
    public static final ItemType LightGrayDye = new ItemType(351, 7, "minecraft:dye");
    public static final ItemType GrayDye = new ItemType(351, 8, "minecraft:dye");
    public static final ItemType PinkDye = new ItemType(351, 9, "minecraft:dye");
    public static final ItemType LimeDye = new ItemType(351, 10, "minecraft:dye");
    public static final ItemType DandelionYellow = new ItemType(351, 11, "minecraft:dye");
    public static final ItemType LightBlueDye = new ItemType(351, 12, "minecraft:dye");
    public static final ItemType MagentaDye = new ItemType(351, 13, "minecraft:dye");
    public static final ItemType OrangeDye = new ItemType(351, 14, "minecraft:dye");
    public static final ItemType Bonemeal = new ItemType(351, 15, "minecraft:dye");
    public static final ItemType Bone = new ItemType(352, "minecraft:bone");
    public static final ItemType Sugar = new ItemType(353, "minecraft:sugar");
    public static final ItemType Cake = new ItemType(354, "minecraft:cake");
    public static final ItemType Bed = new ItemType(355, true, "minecraft:bed");
    public static final ItemType RedstoneRepeater = new ItemType(356, true, "minecraft:repeater");
    public static final ItemType Cookie = new ItemType(357, "minecraft:cookie");
    public static final ItemType Map = new ItemType(358, "minecraft:filled_map");
    public static final ItemType Shears = new ItemType(359, "minecraft:shears");
    public static final ItemType MelonSlice = new ItemType(360, "minecraft:melon");
    public static final ItemType PumpkinSeeds = new ItemType(361, "minecraft:pumpkin_seeds");
    public static final ItemType MelonSeeds = new ItemType(362, "minecraft:melon_seeds");
    public static final ItemType RawBeef = new ItemType(363, "minecraft:beef");
    public static final ItemType Steak = new ItemType(364, "minecraft:cooked_beef");
    public static final ItemType RawChicken = new ItemType(365, "minecraft:chicken");
    public static final ItemType CookedChicken = new ItemType(366, "minecraft:cooked_chicken");
    public static final ItemType RottenFlesh = new ItemType(367, "minecraft:rotten_flesh");
    public static final ItemType EnderPearl = new ItemType(368, "minecraft:ender_pearl");
    public static final ItemType BlazeRod = new ItemType(369, "minecraft:blaze_rod");
    public static final ItemType GhastTear = new ItemType(370, "minecraft:ghast_tear");
    public static final ItemType GoldNugget = new ItemType(371, "minecraft:gold_nugget");
    public static final ItemType NetherWart = new ItemType(372, "minecraft:nether_wart");
    public static final ItemType Potion = new ItemType(373, "minecraft:potion");
    public static final ItemType GlassBottle = new ItemType(374, "minecraft:glass_bottle");
    public static final ItemType SpiderEye = new ItemType(375, "minecraft:spider_eye");
    public static final ItemType FermentedSpiderEye = new ItemType(376, "minecraft:fermented_spider_eye");
    public static final ItemType BlazePowder = new ItemType(377, "minecraft:blaze_powder");
    public static final ItemType MagmaCream = new ItemType(378, "minecraft:magma_cream");
    public static final ItemType BrewingStand = new ItemType(379, true, "minecraft:brewing_stand");
    public static final ItemType Cauldron = new ItemType(380, true, "minecraft:cauldron");
    public static final ItemType EyeofEnder = new ItemType(381, "minecraft:ender_eye");
    public static final ItemType GlisteringMelon = new ItemType(382, "minecraft:speckled_melon");
    public static final ItemType SpawnEgg = new ItemType(383, "minecraft:spawn_egg");
    public static final ItemType BottleOEnchanting = new ItemType(384, "minecraft:experience_bottle");
    public static final ItemType FireCharge = new ItemType(385, "minecraft:fire_charge");
    public static final ItemType BookAndQuill = new ItemType(386, "minecraft:writable_book");
    public static final ItemType WrittenBook = new ItemType(387, "minecraft:written_book");
    public static final ItemType Emerald = new ItemType(388, "minecraft:emerald");
    public static final ItemType ItemFrame = new ItemType(389, "minecraft:item_frame");
    public static final ItemType FlowerPot = new ItemType(390, true, "minecraft:flower_pot");
    public static final ItemType Carrot = new ItemType(391, "minecraft:carrot");
    public static final ItemType Potato = new ItemType(392, "minecraft:potato");
    public static final ItemType BakedPotato = new ItemType(393, "minecraft:baked_potato");
    public static final ItemType PoisonousPotato = new ItemType(394, "minecraft:poisonous_potato");
    public static final ItemType EmptyMap = new ItemType(395, "minecraft:map");
    public static final ItemType GoldenCarrot = new ItemType(396, "minecraft:golden_carrot");
    public static final ItemType SkeletonHead = new ItemType(397, 0, true, "minecraft:skull");
    public static final ItemType WitherSkeletonHead = new ItemType(397, 1, true, "minecraft:skull");
    public static final ItemType ZombieHead = new ItemType(397, 2, true, "minecraft:skull");
    public static final ItemType HumanHead = new ItemType(397, 3, true, "minecraft:skull");
    public static final ItemType CreeperHead = new ItemType(397, 4, true, "minecraft:skull");
    public static final ItemType CarrotOnAStick = new ItemType(398, "minecraft:carrot_on_a_stick");
    public static final ItemType NetherStar = new ItemType(399, "minecraft:nether_star");
    public static final ItemType PumpkinPie = new ItemType(400, "minecraft:pumpkin_pie");
    public static final ItemType FireworkRocket = new ItemType(401, "minecraft:fireworks");
    public static final ItemType FireworkStar = new ItemType(402, "minecraft:firework_charge");
    public static final ItemType EnchantedBook = new ItemType(403, "minecraft:enchanted_book");
    public static final ItemType RedstoneComparator = new ItemType(404, true, "minecraft:comparator");
    public static final ItemType NetherBricks = new ItemType(405, "minecraft:netherbrick");
    public static final ItemType NetherQuartz = new ItemType(406, "minecraft:quartz");
    public static final ItemType MinecartTNT = new ItemType(407, "minecraft:tnt_minecart");
    public static final ItemType MinecartHopper = new ItemType(408, "minecraft:hopper_minecart");
    public static final ItemType PrismarineShard = new ItemType(409, "minecraft:prismarine_shard");
    public static final ItemType PrismarineCrystals = new ItemType(410, "minecraft:prismarine_cystals");
    public static final ItemType RawRabbit = new ItemType(411, "minecraft:rabbit");
    public static final ItemType CookedRabbit = new ItemType(412, "minecraft:cooked_rabbit");
    public static final ItemType RabbitStew = new ItemType(413, "minecraft:rabbit_stew");
    public static final ItemType RabbitFoot = new ItemType(414, "minecraft:rabbit_foot");
    public static final ItemType RabbitHide = new ItemType(415, "minecraft:rabbit_hide");
    public static final ItemType ArmorStand = new ItemType(416, true, "minecraft:armor_stand");
    public static final ItemType IronHorseArmor = new ItemType(417, "minecraft:iron_horse_armor");
    public static final ItemType GoldHorseArmor = new ItemType(418, "minecraft:golden_horse_armor");
    public static final ItemType DiamondHorseArmor = new ItemType(419, "minecraft:diamond_horse_armor");
    public static final ItemType Lead = new ItemType(420, "minecraft:lead");
    public static final ItemType NameTag = new ItemType(421, "minecraft:name_tag");
    public static final ItemType MinecartCommandBlock = new ItemType(422, "minecraft:command_block_minecart");
    public static final ItemType RawMutton = new ItemType(423, "minecraft:mutton");
    public static final ItemType CookedMutton = new ItemType(424, "minecraft:cooked_mutton");
    public static final ItemType Banner = new ItemType(425, true, "minecraft:banner");
    public static final ItemType EndCrystal = new ItemType(426, true, "minecraft:end_crystal");
    public static final ItemType SpruceDoor = new ItemType(427, true, "minecraft:spruce_door");
    public static final ItemType BirchDoor = new ItemType(428, true, "minecraft:birch_door");
    public static final ItemType JungleDoor = new ItemType(429, true, "minecraft:jungle_door");
    public static final ItemType AcaciaDoor = new ItemType(430, true, "minecraft:acacia_door");
    public static final ItemType DarkOakDoor = new ItemType(431, true, "minecraft:dark_oak_door");
    public static final ItemType ChorusFruit = new ItemType(432, true, "minecraft:chorus_fruit");
    public static final ItemType PoppedChorusFruit = new ItemType(433, true, "minecraft:chorus_fruit_popped");
    public static final ItemType Beetroot = new ItemType(434, true, "minecraft:beetroot");
    public static final ItemType BeetrootSeeds = new ItemType(435, true, "minecraft_beetroot_seeds");
    public static final ItemType BeetrootSoup = new ItemType(436, true, "minecraft:beetroot_soup");
    public static final ItemType DragonsBreath = new ItemType(437, true, "minecraft:dragon_breath");
    public static final ItemType SplashPotion = new ItemType(438, true, "minecraft:splash_potion");
    public static final ItemType SpectralArrow = new ItemType(439, true, "minecraft:spectral_arrow");
    public static final ItemType TippedArrow = new ItemType(440, true, "minecraft:tipped_arrow");
    public static final ItemType LingeringPotion = new ItemType(441, true, "minecraft:lingering_potion");
    public static final ItemType Shield = new ItemType(442, true, "minecraft:shield");
    public static final ItemType Elytra = new ItemType(443, true, "minecraft:elytra");
    public static final ItemType SpruceBoat = new ItemType(444, true, "minecraft:spruce_boat");
    public static final ItemType BirchBoat = new ItemType(445, true, "minecraft:birch_boat");
    public static final ItemType JungleBoat = new ItemType(446, true, "minecraft:jungle_boat");
    public static final ItemType AcaciaBoat = new ItemType(447, true, "minecraft:acacia_boat");
    public static final ItemType DarkOakBoat = new ItemType(448, true, "minecraft:dark_oak_boat");

    /* Records */
    public static final ItemType GoldRecord = new ItemType(2256, "minecraft:record_13");
    public static final ItemType GreenRecord = new ItemType(2257, "minecraft:record_cat");
    public static final ItemType BlocksRecord = new ItemType(2258, "minecraft:record_blocks");
    public static final ItemType ChirpRecord = new ItemType(2259, "minecraft:record_chirp");
    public static final ItemType FarRecord = new ItemType(2260, "minecraft:record_far");
    public static final ItemType MallRecord = new ItemType(2261, "minecraft:record_mall");
    public static final ItemType MellohiRecord = new ItemType(2262, "minecraft:record_mellohi");
    public static final ItemType StalRecord = new ItemType(2263, "minecraft:record_stal");
    public static final ItemType StradRecord = new ItemType(2264, "minecraft:record_strad");
    public static final ItemType WardRecord = new ItemType(2265, "minecraft:record_ward");
    public static final ItemType ElevenRecord = new ItemType(2266, "minecraft:record_11");
    public static final ItemType WaitRecord = new ItemType(2267, "minecraft:record_wait");

    private final int id;
    private final int data;
    private final boolean blockCreating;
    private final String machineName;
    private static HashMap<Entry<String, Integer>, ItemType> itemTypes;

    public ItemType(int id) {
        this(id, 0, false, "unnamed_item_" + id + "_0");
    }

    public ItemType(int id, int data) {
        this(id, data, false, "unnamed_item_" + id + "_" + data);
    }

    public ItemType(int id, String name) {
        this(id, 0, false, name);
    }

    public ItemType(int id, boolean isBlockCreating) {
        this(id, 0, isBlockCreating, "unnamed_item_" + id + "_0");
    }

    public ItemType(int id, int data, String name) {
        this(id, data, false, name);
    }

    public ItemType(int id, boolean isBlockCreating, String machineName) {
        this(id, 0, isBlockCreating, machineName);
    }

    public ItemType(int id, int data, boolean isBlockCreating, String machineName) {
        if (itemTypes == null) {
            itemTypes = new HashMap<Entry<String, Integer>, ItemType>();
        }
        if (machineName == null) {
            throw new ItemTypeException("ItemType name cannot be null");
        }

        Entry<String, Integer> uniqueType = new SimpleImmutableEntry<String, Integer>(machineName, data);
        if (itemTypes.containsKey(uniqueType)) {
            throw new ItemTypeException("ItemType '" + machineName + ":" + data + "' is already is registered!");
        }
        this.id = id;
        this.data = data;
        this.blockCreating = isBlockCreating;
        this.machineName = machineName;

        @SuppressWarnings("LeakingThisInConstructor")
        ItemType ignored = itemTypes.put(uniqueType, this);
    }

    /**
     * Get the ID of this ItemType
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Get the data of the ItemType
     *
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * Get a custom ItemType.
     *
     * @param name
     *         the machine name or the display name of the block type in question
     *
     * @return the ItemType if found; {@code null} if the requested ItemType does not exist.
     */
    public static ItemType getCustomItemType(String name) {
        return ItemType.getCustomItemType(name, 0);
    }

    /**
     * Get a custom ItemType.
     *
     * @param name
     *         the machine name of the block type in question
     * @param data
     *         the data of the block type in question
     *
     * @return the ItemType if found; {@code null} if the requested ItemType does not exist.
     */
    public static ItemType getCustomItemType(String name, int data) {
        Entry<String, Integer> custom = new SimpleImmutableEntry<String, Integer>(name, data);
        if (itemTypes.containsKey(custom)) {
            return itemTypes.get(custom);
        }

        for (ItemType t : itemTypes.values()) {
            if (t.data == data && t.machineName.equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Returns an ItemType according to its name.
     * This returns null if there is no ItemType with this name.
     *
     * @param name
     *         The machine name or the display name
     *
     * @return the ItemType if found; {@code null} if not
     */
    public static ItemType fromString(String name) {
        for (ItemType t : itemTypes.values()) {
            if (t.machineName.equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Get the ItemType according to the given ID.
     * This will return null if there is no ItemType with this id.
     *
     * @param id
     *         the id to get type from
     *
     * @return the ItemType if found; {@code null} if not
     */
    public static ItemType fromId(int id) {
        for (ItemType type : itemTypes.values()) {
            if (type.id == id) {
                return type;
            }
        }
        return null;
    }

    /**
     * Gets an ItemType according to the given ID and Data values.
     * This will return null if there is no ItemType with this id.
     *
     * @param id
     *         the id to get type from
     * @param data
     *         the data (damage) to get type from
     *
     * @return the ItemType if found; {@code null} if not
     */
    public static ItemType fromIdAndData(int id, int data) {
        for (ItemType type : itemTypes.values()) {
            if (type.id == id && type.data == data) {
                return type;
            }
        }
        return fromId(id);
    }

    /**
     * Gets an ItemType according to the given machine name and data value.
     * This will return null if there is no ItemType with this id.
     *
     * @param machineName
     *         the machine name to get type from
     * @param data
     *         the data (damage) to get type from
     *
     * @return the ItemType if found; {@code null} if not
     */
    public static ItemType fromStringAndData(String machineName, int data) {
        Entry<String, Integer> needle = new SimpleImmutableEntry<String, Integer>(machineName, data);
        if (itemTypes.containsKey(needle)) {
            return itemTypes.get(needle);
        }

        for (ItemType type : itemTypes.values()) {
            if (type.data == data && type.machineName.equalsIgnoreCase(machineName)) {
                return type;
            }
        }
        return fromString(machineName);
    }

    /**
     * Returns a "machine readable" name.
     * That is: a representation of the Item Type name
     * in lowercase letters without whitespaces.
     *
     * @return the machine name
     */
    public String getMachineName() {
        return machineName;
    }

    /**
     * Checks the Item ID if it is an Item that creates a Block
     *
     * @param itemId
     *         the Item ID to check
     *
     * @return {@code true} if creates blocks; {@code false} if not
     */
    public static boolean isBlockCreating(int itemId) {
        return fromId(itemId).blockCreating;
    }

    public boolean isBlockCreating() {
        return blockCreating;
    }

    /**
     * Gets an array of all ItemTypes
     *
     * @return all ItemTypes
     */
    public static ItemType[] values() {
        return itemTypes.values().toArray(new ItemType[itemTypes.size()]);
    }
}
