package net.canarymod.api.world.effects;

/**
 * Sound Effects!
 *
 * @author Jason (darkdiplomat)
 */
public class SoundEffect {

    /**
     * The Sounds!
     *
     * @author Jason (darkdiplomat)
     */
    public enum Type {
        AMBIENT_CAVE("ambient.cave"),
        BLOCK_ANVIL_BREAK("block.anvil.break"),
        BLOCK_ANVIL_DESTROY("block.anvil.destroy"),
        BLOCK_ANVIL_FALL("block.anvil.fall"),
        BLOCK_ANVIL_HIT("block.anvil.hit"),
        BLOCK_ANVIL_LAND("block.anvil.land"),
        BLOCK_ANVIL_PLACE("block.anvil.place"),
        BLOCK_ANVIL_STEP("block.anvil.step"),
        BLOCK_ANVIL_USE("block.anvil.use"),
        ENTITY_ARMORSTAND_BREAK("entity.armorstand.break"),
        ENTITY_ARMORSTAND_FALL("entity.armorstand.fall"),
        ENTITY_ARMORSTAND_HIT("entity.armorstand.hit"),
        ENTITY_ARMORSTAND_PLACE("entity.armorstand.place"),
        ITEM_ARMOR_EQUIP_CHAIN("item.armor.equip_chain"),
        ITEM_ARMOR_EQUIP_DIAMOND("item.armor.equip_diamond"),
        ITEM_ARMOR_EQUIP_GENERIC("item.armor.equip_generic"),
        ITEM_ARMOR_EQUIP_GOLD("item.armor.equip_gold"),
        ITEM_ARMOR_EQUIP_IRON("item.armor.equip_iron"),
        ITEM_ARMOR_EQUIP_LEATHER("item.armor.equip_leather"),
        ENTITY_ARROW_HIT("entity.arrow.hit"),
        ENTITY_ARROW_HIT_PLAYER("entity.arrow.hit_player"),
        ENTITY_ARROW_SHOOT("entity.arrow.shoot"),
        ENTITY_BAT_AMBIENT("entity.bat.ambient"),
        ENTITY_BAT_DEATH("entity.bat.death"),
        ENTITY_BAT_HURT("entity.bat.hurt"),
        ENTITY_BAT_LOOP("entity.bat.loop"),
        ENTITY_BAT_TAKEOFF("entity.bat.takeoff"),
        ENTITY_BLAZE_AMBIENT("entity.blaze.ambient"),
        ENTITY_BLAZE_BURN("entity.blaze.burn"),
        ENTITY_BLAZE_DEATH("entity.blaze.death"),
        ENTITY_BLAZE_HURT("entity.blaze.hurt"),
        ENTITY_BLAZE_SHOOT("entity.blaze.shoot"),
        ENTITY_BOBBER_SPLASH("entity.bobber.splash"),
        ENTITY_BOBBER_THROW("entity.bobber.throw"),
        ITEM_BOTTLE_FILL("item.bottle.fill"),
        ITEM_BOTTLE_FILL_DRAGONBREATH("item.bottle.fill_dragonbreath"),
        BLOCK_BREWING_STAND_BREW("block.brewing_stand.brew"),
        ITEM_BUCKET_EMPTY("item.bucket.empty"),
        ITEM_BUCKET_EMPTY_LAVA("item.bucket.empty_lava"),
        ITEM_BUCKET_FILL("item.bucket.fill"),
        ITEM_BUCKET_FILL_LAVA("item.bucket.fill_lava"),
        ENTITY_CAT_AMBIENT("entity.cat.ambient"),
        ENTITY_CAT_DEATH("entity.cat.death"),
        ENTITY_CAT_HISS("entity.cat.hiss"),
        ENTITY_CAT_HURT("entity.cat.hurt"),
        ENTITY_CAT_PURR("entity.cat.purr"),
        ENTITY_CAT_PURREOW("entity.cat.purreow"),
        BLOCK_CHEST_CLOSE("block.chest.close"),
        BLOCK_CHEST_LOCKED("block.chest.locked"),
        BLOCK_CHEST_OPEN("block.chest.open"),
        ENTITY_CHICKEN_AMBIENT("entity.chicken.ambient"),
        ENTITY_CHICKEN_DEATH("entity.chicken.death"),
        ENTITY_CHICKEN_EGG("entity.chicken.egg"),
        ENTITY_CHICKEN_HURT("entity.chicken.hurt"),
        ENTITY_CHICKEN_STEP("entity.chicken.step"),
        BLOCK_CHORUS_FLOWER_DEATH("block.chorus_flower.death"),
        BLOCK_CHORUS_FLOWER_GROW("block.chorus_flower.grow"),
        ITEM_CHORUS_FRUIT_TELEPORT("item.chorus_fruit.teleport"),
        BLOCK_CLOTH_BREAK("block.cloth.break"),
        BLOCK_CLOTH_FALL("block.cloth.fall"),
        BLOCK_CLOTH_HIT("block.cloth.hit"),
        BLOCK_CLOTH_PLACE("block.cloth.place"),
        BLOCK_CLOTH_STEP("block.cloth.step"),
        BLOCK_COMPARATOR_CLICK("block.comparator.click"),
        ENTITY_COW_AMBIENT("entity.cow.ambient"),
        ENTITY_COW_DEATH("entity.cow.death"),
        ENTITY_COW_HURT("entity.cow.hurt"),
        ENTITY_COW_MILK("entity.cow.milk"),
        ENTITY_COW_STEP("entity.cow.step"),
        ENTITY_CREEPER_DEATH("entity.creeper.death"),
        ENTITY_CREEPER_HURT("entity.creeper.hurt"),
        ENTITY_CREEPER_PRIMED("entity.creeper.primed"),
        BLOCK_DISPENSER_DISPENSE("block.dispenser.dispense"),
        BLOCK_DISPENSER_FAIL("block.dispenser.fail"),
        BLOCK_DISPENSER_LAUNCH("block.dispenser.launch"),
        BLOCK_ENCHANTMENT_TABLE_USE("block.enchantment_table.use"),
        ENTITY_DONKEY_AMBIENT("entity.donkey.ambient"),
        ENTITY_DONKEY_ANGRY("entity.donkey.angry"),
        ENTITY_DONKEY_CHEST("entity.donkey.chest"),
        ENTITY_DONKEY_DEATH("entity.donkey.death"),
        ENTITY_DONKEY_HURT("entity.donkey.hurt"),
        ENTITY_EGG_THROW("entity.egg.throw"),
        ENTITY_ELDER_GUARDIAN_AMBIENT("entity.elder_guardian.ambient"),
        ENTITY_ELDERGUARDIAN_AMBIENTLAND("entity.elder_guardian.ambient_land"),
        ENTITY_ELDER_GUARDIAN_CURSE("entity.elder_guardian.curse"),
        ENTITY_ELDER_GUARDIAN_DEATH("entity.elder_guardian.death"),
        ENTITY_ELDER_GUARDIAN_DEATH_LAND("entity.elder_guardian.death_land"),
        ENTITY_ELDER_GUARDIAN_HURT("entity.elder_guardian.hurt"),
        ENTITY_ELDER_GUARDIAN_HURT_LAND("entity.elder_guardian.hurt_land"),
        BLOCK_ENDERCHEST_CLOSE("block.enderchest.close"),
        BLOCK_ENDERCHEST_OPEN("block.enderchest.open"),
        ENTITY_ENDERDRAGON_AMBIENT("entity.enderdragon.ambient"),
        ENTITY_ENDERDRAGON_DEATH("entity.enderdragon.death"),
        ENTITY_ENDERDRAGON_FIREBALL_EPLD("entity.enderdragon_fireball.explode"),
        ENTITY_ENDERDRAGON_FLAP("entity.enderdragon.flap"),
        ENTITY_ENDERDRAGON_GROWL("entity.enderdragon.growl"),
        ENTITY_ENDERDRAGON_HURT("entity.enderdragon.hurt"),
        ENTITY_ENDERDRAGON_SHOOT("entity.enderdragon.shoot"),
        ENTITY_ENDEREYE_LAUNCH("entity.endereye.launch"),
        ENTITY_ENDERMEN_AMBIENT("entity.endermen.ambient"),
        ENTITY_ENDERMEN_DEATH("entity.endermen.death"),
        ENTITY_ENDERMEN_HURT("entity.endermen.hurt"),
        ENTITY_ENDERMEN_SCREAM("entity.endermen.scream"),
        ENTITY_ENDERMEN_STARE("entity.endermen.stare"),
        ENTITY_ENDERMEN_TELEPORT("entity.endermen.teleport"),
        ENTITY_ENDERMITE_AMBIENT("entity.endermite.ambient"),
        ENTITY_ENDERMITE_DEATH("entity.endermite.death"),
        ENTITY_ENDERMITE_HURT("entity.endermite.hurt"),
        ENTITY_ENDERMITE_STEP("entity.endermite.step"),
        ENTITY_ENDERPEARL_THROW("entity.enderpearl.throw"),
        BLOCK_END_GATEWAY_SPAWN("block.end_gateway.spawn"),
        ENTITY_EXPERIENCE_BOTTLE_THROW("entity.experience_bottle.throw"),
        ENTITY_EXPERIENCE_ORB_PICKUP("entity.experience_orb.pickup"),
        ENTITY_EXPERIENCE_ORB_TOUCH("entity.experience_orb.touch"),
        BLOCK_FENCE_GATE_CLOSE("block.fence_gate.close"),
        BLOCK_FENCE_GATE_OPEN("block.fence_gate.open"),
        ITEM_FIRECHARGE_USE("item.firecharge.use"),
        ENTITY_FIREWORK_BLAST("entity.firework.blast"),
        ENTITY_FIREWORK_BLAST_FAR("entity.firework.blast_far"),
        ENTITY_FIREWORK_LARGE_BLAST("entity.firework.large_blast"),
        ENTITY_FIREWORK_LARGE_BLAST_FAR("entity.firework.large_blast_far"),
        ENTITY_FIREWORK_LAUNCH("entity.firework.launch"),
        ENTITY_FIREWORK_SHOOT("entity.firework.shoot"),
        ENTITY_FIREWORK_TWINKLE("entity.firework.twinkle"),
        ENTITY_FIREWORK_TWINKLE_FAR("entity.firework.twinkle_far"),
        BLOCK_FIRE_AMBIENT("block.fire.ambient"),
        BLOCK_FIRE_EXTINGUISH("block.fire.extinguish"),
        ITEM_FLINTANDSTEEL_USE("item.flintandsteel.use"),
        BLOCK_FURNACE_FIRE_CRACKLE("block.furnace.fire_crackle"),
        ENTITY_GENERIC_BIG_FALL("entity.generic.big_fall"),
        ENTITY_GENERIC_BURN("entity.generic.burn"),
        ENTITY_GENERIC_DEATH("entity.generic.death"),
        ENTITY_GENERIC_DRINK("entity.generic.drink"),
        ENTITY_GENERIC_EAT("entity.generic.eat"),
        ENTITY_GENERIC_EXPLODE("entity.generic.explode"),
        ENTITY_GENERIC_EXTINGUISH_FIRE("entity.generic.extinguish_fire"),
        ENTITY_GENERIC_HURT("entity.generic.hurt"),
        ENTITY_GENERIC_SMALL_FALL("entity.generic.small_fall"),
        ENTITY_GENERIC_SPLASH("entity.generic.splash"),
        ENTITY_GENERIC_SWIM("entity.generic.swim"),
        ENTITY_GHAST_AMBIENT("entity.ghast.ambient"),
        ENTITY_GHAST_DEATH("entity.ghast.death"),
        ENTITY_GHAST_HURT("entity.ghast.hurt"),
        ENTITY_GHAST_SCREAM("entity.ghast.scream"),
        ENTITY_GHAST_SHOOT("entity.ghast.shoot"),
        ENTITY_GHAST_WARN("entity.ghast.warn"),
        BLOCK_GLASS_BREAK("block.glass.break"),
        BLOCK_GLASS_FALL("block.glass.fall"),
        BLOCK_GLASS_HIT("block.glass.hit"),
        BLOCK_GLASS_PLACE("block.glass.place"),
        BLOCK_GLASS_STEP("block.glass.step"),
        BLOCK_GRASS_BREAK("block.grass.break"),
        BLOCK_GRASS_FALL("block.grass.fall"),
        BLOCK_GRASS_HIT("block.grass.hit"),
        BLOCK_GRASS_PLACE("block.grass.place"),
        BLOCK_GRASS_STEP("block.grass.step"),
        BLOCK_GRAVEL_BREAK("block.gravel.break"),
        BLOCK_GRAVEL_FALL("block.gravel.fall"),
        BLOCK_GRAVEL_HIT("block.gravel.hit"),
        BLOCK_GRAVEL_PLACE("block.gravel.place"),
        BLOCK_GRAVEL_STEP("block.gravel.step"),
        ENTITY_GUARDIAN_AMBIENT("entity.guardian.ambient"),
        ENTITY_GUARDIAN_AMBIENT_LAND("entity.guardian.ambient_land"),
        ENTITY_GUARDIAN_ATTACK("entity.guardian.attack"),
        ENTITY_GUARDIAN_DEATH("entity.guardian.death"),
        ENTITY_GUARDIAN_DEATH_LAND("entity.guardian.death_land"),
        ENTITY_GUARDIAN_FLOP("entity.guardian.flop"),
        ENTITY_GUARDIAN_HURT("entity.guardian.hurt"),
        ENTITY_GUARDIAN_HURT_LAND("entity.guardian.hurt_land"),
        ITEM_HOE_TILL("item.hoe.till"),
        ENTITY_HORSE_AMBIENT("entity.horse.ambient"),
        ENTITY_HORSE_ANGRY("entity.horse.angry"),
        ENTITY_HORSE_ARMOR("entity.horse.armor"),
        ENTITY_HORSE_BREATHE("entity.horse.breathe"),
        ENTITY_HORSE_DEATH("entity.horse.death"),
        ENTITY_HORSE_EAT("entity.horse.eat"),
        ENTITY_HORSE_GALLOP("entity.horse.gallop"),
        ENTITY_HORSE_HURT("entity.horse.hurt"),
        ENTITY_HORSE_JUMP("entity.horse.jump"),
        ENTITY_HORSE_LAND("entity.horse.land"),
        ENTITY_HORSE_SADDLE("entity.horse.saddle"),
        ENTITY_HORSE_STEP("entity.horse.step"),
        ENTITY_HORSE_STEP_WOOD("entity.horse.step_wood"),
        ENTITY_HOSTILE_BIG_FALL("entity.hostile.big_fall"),
        ENTITY_HOSTILE_DEATH("entity.hostile.death"),
        ENTITY_HOSTILE_HURT("entity.hostile.hurt"),
        ENTITY_HOSTILE_SMALL_FALL("entity.hostile.small_fall"),
        ENTITY_HOSTILE_SPLASH("entity.hostile.splash"),
        ENTITY_HOSTILE_SWIM("entity.hostile.swim"),
        ENTITY_HUSK_AMBIENT("entity.husk.ambient"),
        ENTITY_HUSK_DEATH("entity.husk.death"),
        ENTITY_HUSK_HURT("entity.husk.hurt"),
        ENTITY_HUSK_STEP("entity.husk.step"),
        ENTITY_IRONGOLEM_ATTACK("entity.irongolem.attack"),
        ENTITY_IRONGOLEM_DEATH("entity.irongolem.death"),
        ENTITY_IRONGOLEM_HURT("entity.irongolem.hurt"),
        ENTITY_IRONGOLEM_STEP("entity.irongolem.step"),
        BLOCK_IRON_DOOR_CLOSE("block.iron_door.close"),
        BLOCK_IRON_DOOR_OPEN("block.iron_door.open"),
        BLOCK_IRON_TRAPDOOR_CLOSE("block.iron_trapdoor.close"),
        BLOCK_IRON_TRAPDOOR_OPEN("block.iron_trapdoor.open"),
        ENTITY_ITEMFRAME_ADD_ITEM("entity.itemframe.add_item"),
        ENTITY_ITEMFRAME_BREAK("entity.itemframe.break"),
        ENTITY_ITEMFRAME_PLACE("entity.itemframe.place"),
        ENTITY_ITEMFRAME_REMOVE_ITEM("entity.itemframe.remove_item"),
        ENTITY_ITEMFRAME_ROTATE_ITEM("entity.itemframe.rotate_item"),
        ENTITY_ITEM_BREAK("entity.item.break"),
        ENTITY_ITEM_PICKUP("entity.item.pickup"),
        BLOCK_LADDER_BREAK("block.ladder.break"),
        BLOCK_LADDER_FALL("block.ladder.fall"),
        BLOCK_LADDER_HIT("block.ladder.hit"),
        BLOCK_LADDER_PLACE("block.ladder.place"),
        BLOCK_LADDER_STEP("block.ladder.step"),
        BLOCK_LAVA_AMBIENT("block.lava.ambient"),
        BLOCK_LAVA_EXTINGUISH("block.lava.extinguish"),
        BLOCK_LAVA_POP("block.lava.pop"),
        ENTITY_LEASHKNOT_BREAK("entity.leashknot.break"),
        ENTITY_LEASHKNOT_PLACE("entity.leashknot.place"),
        BLOCK_LEVER_CLICK("block.lever.click"),
        ENTITY_LIGHTNING_IMPACT("entity.lightning.impact"),
        ENTITY_LIGHTNING_THUNDER("entity.lightning.thunder"),
        ENTITY_LINGERINGPOTION_THROW("entity.lingeringpotion.throw"),
        ENTITY_MAGMACUBE_DEATH("entity.magmacube.death"),
        ENTITY_MAGMACUBE_HURT("entity.magmacube.hurt"),
        ENTITY_MAGMACUBE_JUMP("entity.magmacube.jump"),
        ENTITY_MAGMACUBE_SQUISH("entity.magmacube.squish"),
        BLOCK_METAL_BREAK("block.metal.break"),
        BLOCK_METAL_FALL("block.metal.fall"),
        BLOCK_METAL_HIT("block.metal.hit"),
        BLOCK_METAL_PLACE("block.metal.place"),
        BLOCK_METAL_PRESSPLATE_CLICK_OFF("block.metal_pressureplate.click_off"),
        BLOCK_METAL_PRESSPLATE_CLICK_ON("block.metal_pressureplate.click_on"),
        BLOCK_METAL_STEP("block.metal.step"),
        ENTITY_MINECART_INSIDE("entity.minecart.inside"),
        ENTITY_MINECART_RIDING("entity.minecart.riding"),
        ENTITY_MOOSHROOM_SHEAR("entity.mooshroom.shear"),
        ENTITY_MULE_AMBIENT("entity.mule.ambient"),
        ENTITY_MULE_DEATH("entity.mule.death"),
        ENTITY_MULE_HURT("entity.mule.hurt"),
        MUSIC_CREATIVE("music.creative"),
        MUSIC_CREDITS("music.credits"),
        MUSIC_DRAGON("music.dragon"),
        MUSIC_END("music.end"),
        MUSIC_GAME("music.game"),
        MUSIC_MENU("music.menu"),
        MUSIC_NETHER("music.nether"),
        BLOCK_NOTE_BASEDRUM("block.note.basedrum"),
        BLOCK_NOTE_BASS("block.note.bass"),
        BLOCK_NOTE_HARP("block.note.harp"),
        BLOCK_NOTE_HAT("block.note.hat"),
        BLOCK_NOTE_PLING("block.note.pling"),
        BLOCK_NOTE_SNARE("block.note.snare"),
        ENTITY_PAINTING_BREAK("entity.painting.break"),
        ENTITY_PAINTING_PLACE("entity.painting.place"),
        ENTITY_PIG_AMBIENT("entity.pig.ambient"),
        ENTITY_PIG_DEATH("entity.pig.death"),
        ENTITY_PIG_HURT("entity.pig.hurt"),
        ENTITY_PIG_SADDLE("entity.pig.saddle"),
        ENTITY_PIG_STEP("entity.pig.step"),
        BLOCK_PISTON_CONTRACT("block.piston.contract"),
        BLOCK_PISTON_EXTEND("block.piston.extend"),
        ENTITY_PLAYER_ATTACK_CRIT("entity.player.attack.crit"),
        ENTITY_PLAYER_ATTACK_KNOCKBACK("entity.player.attack.knockback"),
        ENTITY_PLAYER_ATTACK_NODAMAGE("entity.player.attack.nodamage"),
        ENTITY_PLAYER_ATTACK_STRONG("entity.player.attack.strong"),
        ENTITY_PLAYER_ATTACK_SWEEP("entity.player.attack.sweep"),
        ENTITY_PLAYER_ATTACK_WEAK("entity.player.attack.weak"),
        ENTITY_PLAYER_BIG_FALL("entity.player.big_fall"),
        ENTITY_PLAYER_BREATH("entity.player.breath"),
        ENTITY_PLAYER_BURP("entity.player.burp"),
        ENTITY_PLAYER_DEATH("entity.player.death"),
        ENTITY_PLAYER_HURT("entity.player.hurt"),
        ENTITY_PLAYER_LEVELUP("entity.player.levelup"),
        ENTITY_PLAYER_SMALL_FALL("entity.player.small_fall"),
        ENTITY_PLAYER_SPLASH("entity.player.splash"),
        ENTITY_PLAYER_SWIM("entity.player.swim"),
        ENTITY_POLAR_BEAR_AMBIENT("entity.polar_bear.ambient"),
        ENTITY_POLAR_BEAR_BABY_AMBIENT("entity.polar_bear.baby_ambient"),
        ENTITY_POLAR_BEAR_DEATH("entity.polar_bear.death"),
        ENTITY_POLAR_BEAR_HURT("entity.polar_bear.hurt"),
        ENTITY_POLAR_BEAR_STEP("entity.polar_bear.step"),
        ENTITY_POLAR_BEAR_WARNING("entity.polar_bear.warning"),
        BLOCK_PORTAL_AMBIENT("block.portal.ambient"),
        BLOCK_PORTAL_TRAVEL("block.portal.travel"),
        BLOCK_PORTAL_TRIGGER("block.portal.trigger"),
        ENTITY_RABBIT_AMBIENT("entity.rabbit.ambient"),
        ENTITY_RABBIT_ATTACK("entity.rabbit.attack"),
        ENTITY_RABBIT_DEATH("entity.rabbit.death"),
        ENTITY_RABBIT_HURT("entity.rabbit.hurt"),
        ENTITY_RABBIT_JUMP("entity.rabbit.jump"),
        RECORD_11("record.11"),
        RECORD_13("record.13"),
        RECORD_BLOCKS("record.blocks"),
        RECORD_CAT("record.cat"),
        RECORD_CHIRP("record.chirp"),
        RECORD_FAR("record.far"),
        RECORD_MALL("record.mall"),
        RECORD_MELLOHI("record.mellohi"),
        RECORD_STAL("record.stal"),
        RECORD_STRAD("record.strad"),
        RECORD_WAIT("record.wait"),
        RECORD_WARD("record.ward"),
        BLOCK_REDSTONE_TORCH_BURNOUT("block.redstone_torch.burnout"),
        BLOCK_SAND_BREAK("block.sand.break"),
        BLOCK_SAND_FALL("block.sand.fall"),
        BLOCK_SAND_HIT("block.sand.hit"),
        BLOCK_SAND_PLACE("block.sand.place"),
        BLOCK_SAND_STEP("block.sand.step"),
        ENTITY_SHEEP_AMBIENT("entity.sheep.ambient"),
        ENTITY_SHEEP_DEATH("entity.sheep.death"),
        ENTITY_SHEEP_HURT("entity.sheep.hurt"),
        ENTITY_SHEEP_SHEAR("entity.sheep.shear"),
        ENTITY_SHEEP_STEP("entity.sheep.step"),
        ITEM_SHIELD_BLOCK("item.shield.block"),
        ITEM_SHIELD_BREAK("item.shield.break"),
        ITEM_SHOVEL_FLATTEN("item.shovel.flatten"),
        ENTITY_SHULKER_AMBIENT("entity.shulker.ambient"),
        ENTITY_SHULKER_BULLET_HIT("entity.shulker_bullet.hit"),
        ENTITY_SHULKER_BULLET_HURT("entity.shulker_bullet.hurt"),
        ENTITY_SHULKER_CLOSE("entity.shulker.close"),
        ENTITY_SHULKER_DEATH("entity.shulker.death"),
        ENTITY_SHULKER_HURT("entity.shulker.hurt"),
        ENTITY_SHULKER_HURT_CLOSED("entity.shulker.hurt_closed"),
        ENTITY_SHULKER_OPEN("entity.shulker.open"),
        ENTITY_SHULKER_SHOOT("entity.shulker.shoot"),
        ENTITY_SHULKER_TELEPORT("entity.shulker.teleport"),
        ENTITY_SILVERFISH_AMBIENT("entity.silverfish.ambient"),
        ENTITY_SILVERFISH_DEATH("entity.silverfish.death"),
        ENTITY_SILVERFISH_HURT("entity.silverfish.hurt"),
        ENTITY_SILVERFISH_STEP("entity.silverfish.step"),
        ENTITY_SKELETON_AMBIENT("entity.skeleton.ambient"),
        ENTITY_SKELETON_DEATH("entity.skeleton.death"),
        ENTITY_SKELETON_HORSE_AMBIENT("entity.skeleton_horse.ambient"),
        ENTITY_SKELETON_HORSE_DEATH("entity.skeleton_horse.death"),
        ENTITY_SKELETON_HORSE_HURT("entity.skeleton_horse.hurt"),
        ENTITY_SKELETON_HURT("entity.skeleton.hurt"),
        ENTITY_SKELETON_SHOOT("entity.skeleton.shoot"),
        ENTITY_SKELETON_STEP("entity.skeleton.step"),
        ENTITY_SLIME_ATTACK("entity.slime.attack"),
        BLOCK_SLIME_BREAK("block.slime.break"),
        ENTITY_SLIME_DEATH("entity.slime.death"),
        BLOCK_SLIME_FALL("block.slime.fall"),
        BLOCK_SLIME_HIT("block.slime.hit"),
        ENTITY_SLIME_HURT("entity.slime.hurt"),
        ENTITY_SLIME_JUMP("entity.slime.jump"),
        BLOCK_SLIME_PLACE("block.slime.place"),
        ENTITY_SLIME_SQUISH("entity.slime.squish"),
        BLOCK_SLIME_STEP("block.slime.step"),
        ENTITY_SMALL_MAGMACUBE_DEATH("entity.small_magmacube.death"),
        ENTITY_SMALL_MAGMACUBE_HURT("entity.small_magmacube.hurt"),
        ENTITY_SMALL_MAGMACUBE_SQUISH("entity.small_magmacube.squish"),
        ENTITY_SMALL_SLIME_DEATH("entity.small_slime.death"),
        ENTITY_SMALL_SLIME_HURT("entity.small_slime.hurt"),
        ENTITY_SMALL_SLIME_JUMP("entity.small_slime.jump"),
        ENTITY_SMALL_SLIME_SQUISH("entity.small_slime.squish"),
        ENTITY_SNOWBALL_THROW("entity.snowball.throw"),
        ENTITY_SNOWMAN_AMBIENT("entity.snowman.ambient"),
        ENTITY_SNOWMAN_DEATH("entity.snowman.death"),
        ENTITY_SNOWMAN_HURT("entity.snowman.hurt"),
        ENTITY_SNOWMAN_SHOOT("entity.snowman.shoot"),
        BLOCK_SNOW_BREAK("block.snow.break"),
        BLOCK_SNOW_FALL("block.snow.fall"),
        BLOCK_SNOW_HIT("block.snow.hit"),
        BLOCK_SNOW_PLACE("block.snow.place"),
        BLOCK_SNOW_STEP("block.snow.step"),
        ENTITY_SPIDER_AMBIENT("entity.spider.ambient"),
        ENTITY_SPIDER_DEATH("entity.spider.death"),
        ENTITY_SPIDER_HURT("entity.spider.hurt"),
        ENTITY_SPIDER_STEP("entity.spider.step"),
        ENTITY_SPLASH_POTION_BREAK("entity.splash_potion.break"),
        ENTITY_SPLASH_POTION_THROW("entity.splash_potion.throw"),
        ENTITY_SQUID_AMBIENT("entity.squid.ambient"),
        ENTITY_SQUID_DEATH("entity.squid.death"),
        ENTITY_SQUID_HURT("entity.squid.hurt"),
        ENTITY_STRAY_AMBIENT("entity.stray.ambient"),
        ENTITY_STRAY_DEATH("entity.stray.death"),
        ENTITY_STRAY_HURT("entity.stray.hurt"),
        ENTITY_STRAY_STEP("entity.stray.step"),
        BLOCK_STONE_BREAK("block.stone.break"),
        BLOCK_STONE_BUTTON_CLICK_OFF("block.stone_button.click_off"),
        BLOCK_STONE_BUTTON_CLICK_ON("block.stone_button.click_on"),
        BLOCK_STONE_FALL("block.stone.fall"),
        BLOCK_STONE_HIT("block.stone.hit"),
        BLOCK_STONE_PLACE("block.stone.place"),
        BLOCK_STONE_PRESSPLATE_CLICK_OFF("block.stone_pressureplate.click_off"),
        BLOCK_STONE_PRESSPLATE_CLICK_ON("block.stone_pressureplate.click_on"),
        BLOCK_STONE_STEP("block.stone.step"),
        ENCHANT_THORNS_HIT("enchant.thorns.hit"),
        ENTITY_TNT_PRIMED("entity.tnt.primed"),
        BLOCK_TRIPWIRE_ATTACH("block.tripwire.attach"),
        BLOCK_TRIPWIRE_CLICK_OFF("block.tripwire.click_off"),
        BLOCK_TRIPWIRE_CLICK_ON("block.tripwire.click_on"),
        BLOCK_TRIPWIRE_DETACH("block.tripwire.detach"),
        UI_BUTTON_CLICK("ui.button.click"),
        ENTITY_VILLAGER_AMBIENT("entity.villager.ambient"),
        ENTITY_VILLAGER_DEATH("entity.villager.death"),
        ENTITY_VILLAGER_HURT("entity.villager.hurt"),
        ENTITY_VILLAGER_NO("entity.villager.no"),
        ENTITY_VILLAGER_TRADING("entity.villager.trading"),
        ENTITY_VILLAGER_YES("entity.villager.yes"),
        BLOCK_WATERLILY_PLACE("block.waterlily.place"),
        BLOCK_WATER_AMBIENT("block.water.ambient"),
        WEATHER_RAIN("weather.rain"),
        WEATHER_RAIN_ABOVE("weather.rain.above"),
        ENTITY_WITCH_AMBIENT("entity.witch.ambient"),
        ENTITY_WITCH_DEATH("entity.witch.death"),
        ENTITY_WITCH_DRINK("entity.witch.drink"),
        ENTITY_WITCH_HURT("entity.witch.hurt"),
        ENTITY_WITCH_THROW("entity.witch.throw"),
        ENTITY_WITHER_AMBIENT("entity.wither.ambient"),
        ENTITY_WITHER_BREAK_BLOCK("entity.wither.break_block"),
        ENTITY_WITHER_DEATH("entity.wither.death"),
        ENTITY_WITHER_HURT("entity.wither.hurt"),
        ENTITY_WITHER_SHOOT("entity.wither.shoot"),
        ENTITY_WITHER_SPAWN("entity.wither.spawn"),
        ENTITY_WITHER_SKELETON_AMBIENT("entity.wither_skeleton.ambient"),
        ENTITY_WITHER_SKELETON_DEATH("entity.wither_skeleton.death"),
        ENTITY_WITHER_SKELETON_HURT("entity.wither_skeleton.hurt"),
        ENTITY_WITHER_SKELETON_STEP("entity.wither_skeleton.step"),
        ENTITY_WOLF_AMBIENT("entity.wolf.ambient"),
        ENTITY_WOLF_DEATH("entity.wolf.death"),
        ENTITY_WOLF_GROWL("entity.wolf.growl"),
        ENTITY_WOLF_HOWL("entity.wolf.howl"),
        ENTITY_WOLF_HURT("entity.wolf.hurt"),
        ENTITY_WOLF_PANT("entity.wolf.pant"),
        ENTITY_WOLF_SHAKE("entity.wolf.shake"),
        ENTITY_WOLF_STEP("entity.wolf.step"),
        ENTITY_WOLF_WHINE("entity.wolf.whine"),
        BLOCK_WOODEN_DOOR_CLOSE("block.wooden_door.close"),
        BLOCK_WOODEN_DOOR_OPEN("block.wooden_door.open"),
        BLOCK_WOODEN_TRAPDOOR_CLOSE("block.wooden_trapdoor.close"),
        BLOCK_WOODEN_TRAPDOOR_OPEN("block.wooden_trapdoor.open"),
        BLOCK_WOOD_BREAK("block.wood.break"),
        BLOCK_WOOD_BUTTON_CLICK_OFF("block.wood_button.click_off"),
        BLOCK_WOOD_BUTTON_CLICK_ON("block.wood_button.click_on"),
        BLOCK_WOOD_FALL("block.wood.fall"),
        BLOCK_WOOD_HIT("block.wood.hit"),
        BLOCK_WOOD_PLACE("block.wood.place"),
        BLOCK_WOOD_PRESSPLATE_CLICK_OFF("block.wood_pressureplate.click_off"),
        BLOCK_WOOD_PRESSPLATE_CLICK_ON("block.wood_pressureplate.click_on"),
        BLOCK_WOOD_STEP("block.wood.step"),
        ENTITY_ZOMBIE_AMBIENT("entity.zombie.ambient"),
        ENTITY_ZOMBIE_ATTACK_DOOR_WOOD("entity.zombie.attack_door_wood"),
        ENTITY_ZOMBIE_ATTACK_IRON_DOOR("entity.zombie.attack_iron_door"),
        ENTITY_ZOMBIE_BREAK_DOOR_WOOD("entity.zombie.break_door_wood"),
        ENTITY_ZOMBIE_DEATH("entity.zombie.death"),
        ENTITY_ZOMBIE_HORSE_AMBIENT("entity.zombie_horse.ambient"),
        ENTITY_ZOMBIE_HORSE_DEATH("entity.zombie_horse.death"),
        ENTITY_ZOMBIE_HORSE_HURT("entity.zombie_horse.hurt"),
        ENTITY_ZOMBIE_HURT("entity.zombie.hurt"),
        ENTITY_ZOMBIE_INFECT("entity.zombie.infect"),
        ENTITY_ZOMBIE_PIG_AMBIENT("entity.zombie_pig.ambient"),
        ENTITY_ZOMBIE_PIG_ANGRY("entity.zombie_pig.angry"),
        ENTITY_ZOMBIE_PIG_DEATH("entity.zombie_pig.death"),
        ENTITY_ZOMBIE_PIG_HURT("entity.zombie_pig.hurt"),
        ENTITY_ZOMBIE_STEP("entity.zombie.step"),
        ENTITY_ZOMBIE_VILLAGER_AMBIENT("entity.zombie_villager.ambient"),
        ENTITY_ZOMBIE_VILLAGER_CONVERTED("entity.zombie_villager.converted"),
        ENTITY_ZOMBIE_VILLAGER_CURE("entity.zombie_villager.cure"),
        ENTITY_ZOMBIE_VILLAGER_DEATH("entity.zombie_villager.death"),
        ENTITY_ZOMBIE_VILLAGER_HURT("entity.zombie_villager.hurt"),
        ENTITY_ZOMBIE_VILLAGER_STEP("entity.zombie_villager.step"),
        ;

        private String mcName;

        Type(String name) {
            mcName = name;
        }

        public String getMcName() {
            return mcName;
        }
    }

    public Type type;
    public double x, y, z;
    public float volume, pitch;

    /**
     * Constructs a new SoundEffect
     *
     * @param type
     *         the SoundEffect Type
     * @param x
     *         the x coordinate
     * @param y
     *         the y coordinate
     * @param z
     *         the z coordinate
     * @param volume
     *         the volume of the sound (between 0.0 and 1.0)
     * @param pitch
     *         the frequency of the sound (between 0.0 and 1.0)
     */
    public SoundEffect(Type type, double x, double y, double z, float volume, float pitch) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
        this.volume = volume;
        this.pitch = pitch;
    }
}
