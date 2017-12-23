package net.canarymod.util;

import com.mojang.authlib.GameProfile;
import net.canarymod.Canary;
import net.canarymod.api.BoundingBox;
import net.canarymod.api.CommandBlockLogic;
import net.canarymod.api.DamageType;
import net.canarymod.api.GameMode;
import net.canarymod.api.NetServerHandler;
import net.canarymod.api.PlayerListAction;
import net.canarymod.api.PlayerListData;
import net.canarymod.api.Server;
import net.canarymod.api.attributes.AttributeMap;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.EntityItem;
import net.canarymod.api.entity.EntityType;
import net.canarymod.api.entity.living.LivingBase;
import net.canarymod.api.entity.living.humanoid.HumanCapabilities;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.inventory.Inventory;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.inventory.PlayerInventory;
import net.canarymod.api.nbt.BaseTag;
import net.canarymod.api.nbt.CompoundTag;
import net.canarymod.api.packet.Packet;
import net.canarymod.api.potion.Potion;
import net.canarymod.api.potion.PotionEffect;
import net.canarymod.api.potion.PotionEffectType;
import net.canarymod.api.statistics.Achievement;
import net.canarymod.api.statistics.Achievements;
import net.canarymod.api.statistics.Stat;
import net.canarymod.api.statistics.Statistics;
import net.canarymod.api.world.World;
import net.canarymod.api.world.blocks.Sign;
import net.canarymod.api.world.position.Direction;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.world.position.Position;
import net.canarymod.api.world.position.Vector3D;
import net.canarymod.chat.ReceiverType;
import net.canarymod.hook.player.TeleportHook;
import net.canarymod.permissionsystem.PermissionProvider;
import net.canarymod.user.Group;

import java.util.List;
import java.util.UUID;

/**
 * Special NullPointer safe empty Player
 *
 * @author Jason Jones (darkdiplomat)
 */
public class NullPlayer implements Player {
    private static NullPlayerInventory inventory = new NullPlayerInventory();

    @Override
    public void initPlayerData() {
    }

    @Override
    public void chat(String message) {
    }

    @Override
    public Location getSpawnPosition() {
        return getLocation();
    }

    @Override
    public void setSpawnPosition(Location spawn) {
    }

    @Override
    public boolean executeCommand(String[] command) {
        return false;
    }

    @Override
    public void sendPacket(Packet packet) {
    }

    @Override
    public NetServerHandler getNetServerHandler() {
        return null;
    }

    @Override
    public boolean safeHasPermission(String permission) {
        return true;
    }

    @Override
    public ReceiverType getReceiverType() {
        return ReceiverType.PLAYER;
    }

    @Override
    public Player asPlayer() {
        return null;
    }

    @Override
    public Server asServer() {
        return null;
    }

    @Override
    public CommandBlockLogic asCommandBlock() {
        return null;
    }

    @Override
    public Inventory getEnderChestInventory() {
        return null;
    }

    @Override
    public void teleportTo(Location location, TeleportHook.TeleportCause cause) {
    }

    @Override
    public void kick(String reason) {
    }

    @Override
    public void kickNoHook(String reason) {
    }

    @Override
    public Direction getCardinalDirection() {
        return Direction.ERROR;
    }

    @Override
    public int getPing() {
        return -1;
    }

    @Override
    public PlayerListData getPlayerListData(PlayerListAction action) {
        return null;
    }

    @Override
    public void sendPlayerListData(PlayerListData data) {

    }

    @Override
    public boolean isSleeping() {
        return false;
    }

    @Override
    public boolean isDeeplySleeping() {
        return false;
    }

    @Override
    public boolean isSleepingIgnored() {
        return false;
    }

    @Override
    public void setSleepingIgnored(boolean ignored) {

    }

    @Override
    public boolean isUsingItem() {
        return false;
    }

    @Override
    public Item getItemInUse() {
        return null;
    }

    @Override
    public void refreshCreativeMode() {
    }

    @Override
    public void updateCapabilities() {
    }

    @Override
    public void openInventory(Inventory inventory) {
    }

    @Override
    public void createAndOpenWorkbench() {
    }

    @Override
    public void createAndOpenAnvil() {
    }

    @Override
    public void createAndOpenEnchantmentTable(int bookshelves) {
    }

    @Override
    public void openSignEditWindow(Sign sign) {
    }

    @Override
    public void openBook(Item writtenbook) {

    }

    @Override
    public void closeWindow() {
    }

    @Override
    public String getLocale() {
        return "en_us";
    }

    @Override
    public void sendChatComponent(ChatComponent chatComponent) {
    }

    @Override
    public String getPreviousIP() {
        return "127.0.0.1";
    }

    @Override
    public void hidePlayer(Player player) {
    }

    @Override
    public void hideFrom(Player player) {

    }

    @Override
    public void hidePlayerGlobal() {
    }

    @Override
    public void hideFromAll() {

    }

    @Override
    public void showPlayer(Player player) {
    }

    @Override
    public void showTo(Player player) {

    }

    @Override
    public void showPlayerGlobal() {
    }

    @Override
    public void showToAll() {

    }

    @Override
    public boolean isPlayerHidden(Player player, Player isHidden) {
        return true;
    }

    @Override
    public boolean isHiddenFrom(Player player) {
        return false;
    }

    @Override
    public boolean isHiddenFromAll() {
        return false;
    }

    @Override
    public void setCompassTarget(int x, int y, int z) {
    }

    @Override
    public GameProfile getGameProfile() {
        return null;
    }

    @Override
    public ChatComponent getDisplayNameComponent() {
        return null;
    }

    @Override
    public void setDisplayNameComponent(ChatComponent component) {

    }

    @Override
    public Inventory getSecondInventory() {
        return null;
    }

    @Override
    public void showTitle(ChatComponent title) {

    }

    @Override
    public void showTitle(ChatComponent title, ChatComponent subtitle) {

    }

    @Override
    public PermissionProvider getPermissionProvider() {
        return getGroup().getPermissionProvider();
    }

    @Override
    public Group getGroup() {
        return Canary.usersAndGroups().getDefaultGroup();
    }

    @Override
    public boolean isOnline() {
        return false;
    }

    @Override
    public void setGroup(Group group) {
    }

    @Override
    public void addGroup(Group group) {
    }

    @Override
    public boolean removeGroup(Group g) {
        return false;
    }

    @Override
    public boolean removeGroup(String g) {
        return false;
    }

    @Override
    public boolean isInGroup(Group group, boolean parents) {
        return false;
    }

    @Override
    public boolean isInGroup(String group, boolean parents) {
        return false;
    }

    @Override
    public String getUUIDString() {
        return getUUID().toString();
    }

    @Override
    public boolean isMuted() {
        return true;
    }

    @Override
    public void setMuted(boolean muted) {
    }

    @Override
    public Group[] getPlayerGroups() {
        return new Group[]{getGroup()};
    }

    @Override
    public String getFirstJoined() {
        return "0";
    }

    @Override
    public long getTimePlayed() {
        return 0;
    }

    @Override
    public GameMode getMode() {
        return GameMode.SURVIVAL;
    }

    @Override
    public int getModeId() {
        return 0;
    }

    @Override
    public void setMode(GameMode mode) {
    }

    @Override
    public void setModeId(int mode) {
    }

    @Override
    public boolean isOperator() {
        return false;
    }

    @Override
    public boolean isAdmin() {
        return false;
    }

    @Override
    public boolean canBuild() {
        return false;
    }

    @Override
    public void setCanBuild(boolean canModify) {
    }

    @Override
    public boolean canIgnoreRestrictions() {
        return false;
    }

    @Override
    public void setCanIgnoreRestrictions(boolean canIgnore) {
    }

    @Override
    public void addExhaustion(float exhaustion) {
    }

    @Override
    public void setExhaustion(float exhaustion) {
    }

    @Override
    public float getExhaustionLevel() {
        return 0;
    }

    @Override
    public void addSaturation(float saturation) {

    }

    @Override
    public void setSaturation(float saturation) {

    }

    @Override
    public float getSaturationLevel() {
        return 0;
    }

    @Override
    public void setHunger(int hunger) {
    }

    @Override
    public int getHunger() {
        return 0;
    }

    @Override
    public void addExperience(int experience) {
    }

    @Override
    public void removeExperience(int experience) {
    }

    @Override
    public int getExperience() {
        return 0;
    }

    @Override
    public void setExperience(int xp) {
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void setLevel(int level) {
    }

    @Override
    public void addLevel(int level) {
    }

    @Override
    public void removeLevel(int level) {
    }

    @Override
    public void setHome(Location loc) {
    }

    @Override
    public Location getHome() {
        return null;
    }

    @Override
    public boolean hasHome() {
        return false;
    }

    @Override
    public String[] getAllowedIPs() {
        return new String[0];
    }

    @Override
    public String getIP() {
        return "127.0.0.1";
    }

    @Override
    public String getLastJoined() {
        return null;
    }

    @Override
    public void setStat(Stat stat, int value) {
    }

    @Override
    public void setStat(Statistics stat, int value) {
    }

    @Override
    public void increaseStat(Stat stat, int value) {
    }

    @Override
    public void increaseStat(Statistics stat, int value) {
    }

    @Override
    public void decreaseStat(Stat stat, int value) {
    }

    @Override
    public void decreaseStat(Statistics stat, int value) {
    }

    @Override
    public int getStat(Stat stat) {
        return 0;
    }

    @Override
    public int getStat(Statistics stat) {
        return 0;
    }

    @Override
    public boolean hasAchievement(Achievement achievement) {
        return false;
    }

    @Override
    public boolean hasAchievement(Achievements achievement) {
        return false;
    }

    @Override
    public void removeAchievement(Achievement achievement) {
    }

    @Override
    public void removeAchievement(Achievements achievement) {
    }

    @Override
    public void awardAchievement(Achievement achievement) {
    }

    @Override
    public void awardAchievement(Achievements achievement) {
    }

    @Override
    public String getDisplayName() {
        return "NullPlayer";
    }

    @Override
    public void setDisplayName(String display) {
    }

    @Override
    public boolean showingDisplayName() {
        return false;
    }

    @Override
    public void setShowDisplayName(boolean show) {

    }

    @Override
    public boolean isEating() {
        return false;
    }

    @Override
    public List<Entity> getNearbyEntities(double radius) {
        return null;
    }

    @Override
    public List<Entity> getNearbyEntities(Vector3D vector) {
        return null;
    }

    @Override
    public List<Entity> getNearbyEntities(double radius, EntityType... filter) {
        return null;
    }

    @Override
    public List<Entity> getNearbyEntities(Vector3D vector, EntityType... filter) {
        return null;
    }

    @Override
    public BoundingBox getBoundingBox() {
        return null;
    }

    @Override
    public void destroyItemHeld() {
    }

    @Override
    public Item getItemHeld() {
        return null;
    }

    @Override
    public void dropItem(Item item) {
    }

    @Override
    public PlayerInventory getInventory() {
        return inventory;
    }

    @Override
    public EntityItem[] dropInventory() {
        return new EntityItem[0];
    }

    @Override
    public void giveItem(Item item) {
    }

    @Override
    public String getPrefix() {
        return null;
    }

    @Override
    public void setPrefix(String prefix) {
    }

    @Override
    public boolean isBlocking() {
        return false;
    }

    @Override
    public boolean isShooting() {
        return false;
    }

    @Override
    public HumanCapabilities getCapabilities() {
        return null;
    }

    @Override
    public float getHealth() {
        return 1;
    }

    @Override
    public void setHealth(float health) {
    }

    @Override
    public void increaseHealth(float health) {
    }

    @Override
    public double getMaxHealth() {
        return 1;
    }

    @Override
    public void setMaxHealth(double maxHealth) {
    }

    @Override
    public boolean canSee(LivingBase entity) {
        return false;
    }

    @Override
    public int getDeathTicks() {
        return 0;
    }

    @Override
    public void setDeathTicks(int ticks) {
    }

    @Override
    public int getInvulnerabilityTicks() {
        return 0;
    }

    @Override
    public void setInvulnerabilityTicks(int ticks) {
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public void setAge(int age) {
    }

    @Override
    public void kill() {
    }

    @Override
    public void dealDamage(DamageType type, float damage) {
    }

    @Override
    public void knockBack(double xForce, double zForce) {

    }

    @Override
    public void addPotionEffect(PotionEffect effect) {

    }

    @Override
    public void addPotionEffect(PotionEffectType type, int duration, int amplifier) {

    }

    @Override
    public void removePotionEffect(PotionEffectType type) {

    }

    @Override
    public void removeAllPotionEffects() {

    }

    @Override
    public boolean isPotionActive(Potion potion) {
        return false;
    }

    @Override
    public PotionEffect getActivePotionEffect(Potion potion) {
        return null;
    }

    @Override
    public List<PotionEffect> getAllActivePotionEffects() {
        return null;
    }

    @Override
    public void setRevengeTarget(LivingBase target) {

    }

    @Override
    public LivingBase getRevengeTarget() {
        return null;
    }

    @Override
    public void setLastAssailant(LivingBase entity) {

    }

    @Override
    public LivingBase getLastAssailant() {
        return null;
    }

    @Override
    public void lookAt(double x, double y, double z) {

    }

    @Override
    public void lookAt(Location location) {

    }

    @Override
    public void lookAt(Entity entity) {

    }

    @Override
    public int getArrowCountInEntity() {
        return 0;
    }

    @Override
    public void setArrowCountInEntity(int arrows) {

    }

    @Override
    public void swingArm() {

    }

    @Override
    public void attackEntity(LivingBase target, float damage) {

    }

    @Override
    public float getHeadRotation() {
        return 0;
    }

    @Override
    public void setHeadRotation(float rot) {

    }

    @Override
    public AttributeMap getAttributeMap() {
        return null;
    }

    @Override
    public Entity getTargetLookingAt() {
        return null;
    }

    @Override
    public Entity getTargetLookingAt(int searchRadius) {
        return null;
    }

    @Override
    public boolean lootDrop() {
        return false;
    }

    @Override
    public void setLootDrop(boolean lootDrop) {

    }

    @Override
    public boolean xpDrop() {
        return false;
    }

    @Override
    public void setXPDrop(boolean xpDrop) {

    }

    @Override
    public double getX() {
        return Double.MIN_NORMAL;
    }

    @Override
    public double getY() {
        return Double.MIN_NORMAL;
    }

    @Override
    public double getZ() {
        return Double.MIN_NORMAL;
    }

    @Override
    public double getMotionX() {
        return 0;
    }

    @Override
    public double getMotionY() {
        return 0;
    }

    @Override
    public double getMotionZ() {
        return 0;
    }

    @Override
    public float getPitch() {
        return 0;
    }

    @Override
    public float getRotation() {
        return 0;
    }

    @Override
    public Position getPosition() {
        return new Position(0, 0, 0);
    }

    @Override
    public Location getLocation() {
        return new Location(Canary.getServer().getDefaultWorld(), 0, 0, 0, 0, 0);
    }

    @Override
    public float getEyeHeight() {
        return 0;
    }

    @Override
    public int getID() {
        return -1;
    }

    @Override
    public UUID getUUID() {
        return UUID.fromString("00000000-0000-0000-0000-000000000000");
    }

    @Override
    public void setX(double x) {

    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(double y) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public void setZ(double z) {

    }

    @Override
    public void setZ(int z) {

    }

    @Override
    public void setMotionX(double motionX) {

    }

    @Override
    public void setMotionY(double motionY) {

    }

    @Override
    public void setMotionZ(double motionZ) {

    }

    @Override
    public void setPitch(float pitch) {

    }

    @Override
    public void setRotation(float rotation) {

    }

    @Override
    public Vector3D getMotion() {
        return Vector3D.zero;
    }

    @Override
    public Vector3D getForwardVector() {
        return Vector3D.forward;
    }

    @Override
    public void translate(Vector3D factor) {

    }

    @Override
    public void moveEntity(double motionX, double motionY, double motionZ) {

    }

    @Override
    public void teleportTo(double x, double y, double z) {

    }

    @Override
    public void teleportTo(double x, double y, double z, World world) {

    }

    @Override
    public void teleportTo(double x, double y, double z, float pitch, float rotation) {

    }

    @Override
    public void teleportTo(double x, double y, double z, float pitch, float rotation, World dim) {

    }

    @Override
    public void teleportTo(Location location) {

    }

    @Override
    public void teleportTo(Position position) {

    }

    @Override
    public World getWorld() {
        return Canary.getServer().getDefaultWorld();
    }

    @Override
    public boolean isSprinting() {
        return false;
    }

    @Override
    public void setSprinting(boolean sprinting) {

    }

    @Override
    public boolean isSneaking() {
        return false;
    }

    @Override
    public void setSneaking(boolean sneaking) {

    }

    @Override
    public void setFireTicks(int ticks) {

    }

    @Override
    public int getFireTicks() {
        return 0;
    }

    @Override
    public boolean isLiving() {
        return false;
    }

    @Override
    public boolean isItem() {
        return false;
    }

    @Override
    public boolean isMob() {
        return false;
    }

    @Override
    public boolean isAnimal() {
        return false;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }

    @Override
    public boolean isGolem() {
        return false;
    }

    @Override
    public boolean isNPC() {
        return false;
    }

    @Override
    public EntityItem dropLoot(int itemId, int amount) {
        return null;
    }

    @Override
    public EntityItem dropLoot(Item item) {
        return null;
    }

    @Override
    public String getName() {
        return "NullPlayer";
    }

    @Override
    public void notice(String message) {

    }

    @Override
    public void notice(CharSequence message) {

    }

    @Override
    public void notice(CharSequence... messages) {

    }

    @Override
    public void notice(Iterable<? extends CharSequence> messages) {

    }

    @Override
    public void message(String message) {

    }

    @Override
    public void message(CharSequence message) {

    }

    @Override
    public void message(CharSequence... messages) {

    }

    @Override
    public void message(Iterable<? extends CharSequence> messages) {

    }

    @Override
    public void message(ChatComponent... chatComponents) {

    }

    @Override
    public boolean hasPermission(String node) {
        return true;
    }

    @Override
    public String getFqName() {
        return "NullPlayer";
    }

    @Override
    public boolean canSpawn() {
        return false;
    }

    @Override
    public boolean spawn() {
        return false;
    }

    @Override
    public boolean spawn(Entity rider) {
        return false;
    }

    @Override
    public boolean isRiding() {
        return false;
    }

    @Override
    public boolean isRidden() {
        return false;
    }

    @Override
    public Entity getRiding() {
        return null;
    }

    @Override
    public Entity getRider() {
        return null;
    }

    @Override
    public void setRider(Entity rider) {

    }

    @Override
    public void mount(Entity entity) {
    }

    @Override
    public void dismount() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public CompoundTag getNBT() {
        return Canary.factory().getNBTFactory().newCompoundTag("tag");
    }

    @Override
    public void setNBT(BaseTag tag) {
    }

    @Override
    public boolean isInvisible() {
        return false;
    }

    @Override
    public void setInvisible(boolean invisible) {
    }

    @Override
    public CompoundTag getMetaData() {
        return null;
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.GENERIC_ENTITY;
    }

    @Override
    public boolean isAmbient() {
        return false;
    }

    @Override
    public boolean isOnGround() {
        return false;
    }

    @Override
    public boolean isInWeb() {
        return false;
    }

    @Override
    public boolean isInWater() {
        return false;
    }

    @Override
    public boolean isInLava() {
        return false;
    }

    @Override
    public boolean hasDisplayName() {
        return false;
    }
}