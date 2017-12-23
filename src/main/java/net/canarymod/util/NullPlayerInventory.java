package net.canarymod.util;

import net.canarymod.api.inventory.InventoryType;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.inventory.ItemType;
import net.canarymod.api.inventory.PlayerInventory;

/**
 * Special NullPointer safe empty PlayerInventory
 *
 * @author Jason Jones (darkdiplomat)
 */
public class NullPlayerInventory implements PlayerInventory {
    @Override
    public Item getHelmetSlot() {
        return null;
    }

    @Override
    public void setHelmetSlot(Item item) {

    }

    @Override
    public Item getChestplateSlot() {
        return null;
    }

    @Override
    public void setChestPlateSlot(Item item) {

    }

    @Override
    public Item getLeggingsSlot() {
        return null;
    }

    @Override
    public void setLeggingsSlot(Item item) {

    }

    @Override
    public Item getBootsSlot() {
        return null;
    }

    @Override
    public void setBootsSlot(Item item) {

    }

    @Override
    public int getSelectedHotbarSlotId() {
        return -1;
    }

    @Override
    public Item getItemInHand() {
        return null;
    }

    @Override
    public Item getItemOnCursor() {
        return null;
    }

    @Override
    public void setItemOnCursor(Item item) {

    }

    @Override
    public void addItem(Item item) {

    }

    @Override
    public void addItem(ItemType type) {

    }

    @Override
    public void addItem(int itemId) {

    }

    @Override
    public void addItem(String machineName) {

    }

    @Override
    public void addItem(int itemId, short damage) {

    }

    @Override
    public void addItem(int itemId, int amount) {

    }

    @Override
    public void addItem(ItemType type, int amount) {

    }

    @Override
    public void addItem(String machineName, int amount) {

    }

    @Override
    public void addItem(int itemId, int amount, short damage) {

    }

    @Override
    public void clearContents() {

    }

    @Override
    public Item[] clearInventory() {
        return new Item[27];
    }

    @Override
    public void decreaseItemStackSize(int itemId, int amount) {

    }

    @Override
    public void decreaseItemStackSize(int itemId, int amount, short damage) {

    }

    @Override
    public void decreaseItemStackSize(Item item) {

    }

    @Override
    public Item[] getContents() {
        return new Item[27];
    }

    @Override
    public int getEmptySlot() {
        return -1;
    }

    @Override
    public String getInventoryName() {
        return "NullPlayerInventory";
    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    @Override
    public Item getItem(ItemType type) {
        return null;
    }

    @Override
    public Item getItem(int id) {
        return null;
    }

    @Override
    public Item getItem(String machineName) {
        return null;
    }

    @Override
    public Item getItem(ItemType type, int amount) {
        return null;
    }

    @Override
    public Item getItem(int id, int amount) {
        return null;
    }

    @Override
    public Item getItem(String machineName, int amount) {
        return null;
    }

    @Override
    public Item getItem(int id, int amount, short damage) {
        return null;
    }

    @Override
    public int getSize() {
        return 27;
    }

    @Override
    public Item getSlot(int slot) {
        return null;
    }

    @Override
    public boolean hasItem(int itemId) {
        return false;
    }

    @Override
    public boolean hasItem(String machineName) {
        return false;
    }

    @Override
    public boolean hasItem(ItemType type) {
        return false;
    }

    @Override
    public boolean hasItem(int itemId, short damage) {
        return false;
    }

    @Override
    public boolean hasItemStack(ItemType type, int amount) {
        return false;
    }

    @Override
    public boolean hasItemStack(int itemId, int amount) {
        return false;
    }

    @Override
    public boolean hasItemStack(String machineName, int amount) {
        return false;
    }

    @Override
    public boolean hasItemStack(int itemId, int amount, int damage) {
        return false;
    }

    @Override
    public boolean hasItemStack(String machineName, int minAmount, int maxAmount) {
        return false;
    }

    @Override
    public boolean hasItemStack(ItemType type, int minAmount, int maxAmount) {
        return false;
    }

    @Override
    public boolean hasItemStack(int itemId, int minAmount, int maxAmount, int damage) {
        return false;
    }

    @Override
    public boolean insertItem(Item item) {
        return false;
    }

    @Override
    public void setSlot(Item item) {

    }

    @Override
    public void setSlot(int itemId, int amount, int slot) {

    }

    @Override
    public void setSlot(int itemId, int amount, int damage, int slot) {

    }

    @Override
    public void setSlot(String machineName, int amount, int slot) {

    }

    @Override
    public void setSlot(ItemType type, int amount, int slot) {

    }

    @Override
    public Item removeItem(Item item) {
        return null;
    }

    @Override
    public Item removeItem(int id) {
        return null;
    }

    @Override
    public Item removeItem(int id, int damage) {
        return null;
    }

    @Override
    public Item removeItem(String machineName) {
        return null;
    }

    @Override
    public Item removeItem(ItemType type) {
        return null;
    }

    @Override
    public void setContents(Item[] items) {

    }

    @Override
    public void setInventoryName(String value) {

    }

    @Override
    public void setSlot(int index, Item value) {

    }

    @Override
    public boolean canOpenRemote() {
        return false;
    }

    @Override
    public void setCanOpenRemote(boolean remote) {

    }

    @Override
    public void update() {

    }

    @Override
    public InventoryType getInventoryType() {
        return InventoryType.PLAYER;
    }

    @Override
    public boolean canInsertItems(Item item) {
        return false;
    }
}
