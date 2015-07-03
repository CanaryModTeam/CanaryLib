package net.canarymod.api.inventory;

/**
 * Generic item inventory.
 *
 * @author Chris (damagefilter)
 * @author Jos Kuijpers
 */
public interface Inventory {

    /**
     * Adds an item to this inventory.
     *
     * @param item
     *         the {@link Item} to add
     */
    void addItem(Item item);

    /**
     * Adds an item to this inventory. (amount will be 1)
     *
     * @param type
     *         The ItemType for this item.
     */
    void addItem(ItemType type);

    /**
     * Adds an item to this inventory. (amount will be 1)
     *
     * @param itemId
     *         The ID number for this item.
     */
    void addItem(int itemId);

    /**
     * Adds an item to this inventory (amount will be 1)
     *
     * @param machineName
     *         The internal name for this item.
     */
    void addItem(String machineName);

    /**
     * Adds an item to this inventory (amount will be 1)
     *
     * @param itemId
     *         the Item ID
     * @param damage
     *         the Item damage
     */
    void addItem(int itemId, short damage);

    /**
     * Adds an item to this inventory
     *
     * @param itemId
     *         ID value for this item.
     * @param amount
     *         Amount of this item.
     */
    void addItem(int itemId, int amount);

    /**
     * Adds an item to this inventory
     *
     * @param type
     *         The ItemType for this item.
     * @param amount
     *         Amount of this item.
     */
    void addItem(ItemType type, int amount);

    /**
     * Adds an item to this inventory
     *
     * @param machineName
     *         The internal name for this item.
     * @param amount
     *         Amount of this item.
     */
    void addItem(String machineName, int amount);

    /**
     * Adds an item to this inventory
     *
     * @param itemId
     *         ID value for this item.
     * @param amount
     *         Amount of this item.
     * @param damage
     *         the item damage
     */
    void addItem(int itemId, int amount, short damage);

    /**
     * Remove all items from this container
     */
    void clearContents();

    /**
     * Empties the inventory and returns a copy of it for further processing
     *
     * @return a {@link Item} array of what the inventory had
     */
    Item[] clearInventory();

    /**
     * Remove from the amount from the next available item stack with the given
     * ID
     *
     * @param itemId
     *         ID value for this item.
     * @param amount
     *         Amount of this item.
     */
    void decreaseItemStackSize(int itemId, int amount);

    /**
     * Remove from the amount from the next available item stack with the given
     * ID
     *
     * @param itemId
     *         ID value for this item.
     * @param amount
     *         Amount of this item.
     * @param damage
     *         Damage value for this item.
     */
    void decreaseItemStackSize(int itemId, int amount, short damage);

    /**
     * Remove from the amount from the next available item stack that matches the Item
     *
     * @param item
     *         the {@link Item}
     */
    void decreaseItemStackSize(Item item);

    /**
     * Get the inventory contents
     *
     * @return a {@link Item} array of what the inventory has
     */
    Item[] getContents();

    /**
     * Get the next empty slot or -1 if there are no more empty slots
     *
     * @return the slot id of an empty slot or -1 if no empty slot
     */
    int getEmptySlot();

    /**
     * Get the name of this container (something like inventory.chest)
     *
     * @return t
     */
    String getInventoryName();

    /**
     * Get the stack limit for this inventory. That is: How big cna an item
     * stack be
     *
     * @return stack limit
     */
    int getInventoryStackLimit();

    /**
     * Get item by {@link ItemType} if it exists, returns null if inventory
     * doesn't contain this item type
     *
     * @param type
     *         the {@link ItemType} to match
     *
     * @return the {@link Item} match or {@code null} if not found
     */
    Item getItem(ItemType type);

    /**
     * Get the next available item stack that has the specified ID
     *
     * @param id
     *         ID value for this item.
     *
     * @return the {@link Item} match or {@code null} if not found
     */
    Item getItem(int id);

    /**
     * Get the next available item stack that has the specified ID
     *
     * @param machineName
     *         The internal name for this item.
     *
     * @return the {@link Item} match or {@code null} if not found
     */
    Item getItem(String machineName);

    /**
     * Get item by {@link ItemType} and this amount
     *
     * @param type
     *         The ItemType of this item.
     * @param amount
     *         The amount of this item.
     *
     * @return the {@link Item} match or {@code null} if not found
     */
    Item getItem(ItemType type, int amount);

    /**
     * Get an item with the specified amount from this container. This will
     * remove the item from the container if the specified amount is available
     * and an Item will be returned (null if not available)
     *
     * @param id
     *         ID value for this item.
     * @param amount
     *         Amount of this item.
     *
     * @return the {@link Item} match or {@code null} if not found
     */
    Item getItem(int id, int amount);

    /**
     * Get an item with the specified amount from this container. This will
     * remove the item from the container if the specified amount is available
     * and an Item will be returned (null if not available)
     *
     * @param machineName
     *         The internal name for this item.
     * @param amount
     *         Amount of this item.
     *
     * @return the {@link Item} match or {@code null} if not found
     */
    Item getItem(String machineName, int amount);

    /**
     * Get an item with the specified amount from this container. This will
     * remove the item from the container if the specified amount is available
     * and an Item will be returned (null if not available)
     *
     * @param id
     *         ID value for this item.
     * @param amount
     *         Amount of this item.
     * @param damage
     *         The damage value of this item.
     *
     * @return the {@link Item} match or {@code null} if not found
     */
    Item getItem(int id, int amount, short damage);

    /**
     * Get the size of this inventory
     *
     * @return the inventory size
     */
    int getSize();

    /**
     * Get the item in the given slot
     *
     * @param slot
     *         The slot for this item.
     *
     * @return the {@link Item} in the slot or {@code null} if no Item
     */
    Item getSlot(int slot);

    /**
     * Check if this container contains any item stack with the specified ID
     *
     * @param itemId
     *         ID value for this item.
     *
     * @return {@code true} if has item; {@code false} if not
     */
    boolean hasItem(int itemId);

    /**
     * Check if this inventory contains this item.
     *
     * @param machineName
     *         The internal name for this item.
     *
     * @return {@code true} if inventory contains this item, {@code false} otherwise
     */
    boolean hasItem(String machineName);

    /**
     * Check if this inventory contains this item.
     *
     * @param type
     *         The ItemType of this item.
     *
     * @return {@code true} if inventory contains this item, {@code false} otherwise
     */
    boolean hasItem(ItemType type);

    /**
     * Check if this container contains any item stack with the specified ID
     *
     * @param itemId
     *         ID value for this item.
     * @param damage
     *         Damage value for this item.
     *
     * @return {@code true} if inventory contains this item, {@code false} otherwise
     */
    boolean hasItem(int itemId, short damage);

    /**
     * Check if this inventory contains the requested item with the requested
     * quantity
     *
     * @param type
     *         The ItemType of this item.
     * @param amount
     *         The amount of this item.
     *
     * @return {@code true} if inventory contains this item, {@code false} otherwise
     */
    boolean hasItemStack(ItemType type, int amount);

    /**
     * Check if the container has an item stack with the specified ID and the
     * specified amount.
     *
     * @param itemId
     *         ID value for this item.
     * @param amount
     *         Amount of this item.
     *
     * @return {@code true} if inventory contains this item, {@code false} otherwise
     */
    boolean hasItemStack(int itemId, int amount);

    /**
     * Check if the container has an item stack with the specified ID and the
     * specified amount.
     *
     * @param machineName
     *         The internal name for this item.
     * @param amount
     *         Amount of this item.
     *
     * @return {@code true} if inventory contains this item, {@code false} otherwise
     */
    boolean hasItemStack(String machineName, int amount);

    /**
     * Check if the container has an item stack with the specified ID and the
     * specified amount.
     *
     * @param itemId
     *         ID value for this item.
     * @param amount
     *         Amount of this item.
     * @param damage
     *         Damage value for this item.
     *
     * @return {@code true} if inventory contains this item, {@code false} otherwise
     */
    boolean hasItemStack(int itemId, int amount, int damage);

    /**
     * Check if this container has an itemstack with the specified ID, a minimum
     * amount and the maximum amount specified
     *
     * @param machineName
     *         The internal name for this item.
     * @param minAmount
     *         the minimum amount
     * @param maxAmount
     *         the maximum amount
     *
     * @return {@code true} if inventory contains this item, {@code false} otherwise
     */
    boolean hasItemStack(String machineName, int minAmount, int maxAmount);

    /**
     * Check if this container has an itemstack with the specified ID, a minimum
     * amount and the maximum amount specified
     *
     * @param type
     *         The ItemType of this item.
     * @param minAmount
     *         the minimum amount
     * @param maxAmount
     *         the maximum amount
     *
     * @return {@code true} if inventory contains this item, {@code false} otherwise
     */
    boolean hasItemStack(ItemType type, int minAmount, int maxAmount);

    /**
     * Check if this container has an itemstack with the specified ID, a minimum
     * amount and the maximum amount specified
     *
     * @param itemId
     *         ID value for this item.
     * @param minAmount
     *         the minimum amount
     * @param maxAmount
     *         the maximum amount
     * @param damage
     *         Damage value for this item.
     *
     * @return {@code true} if inventory contains this item, {@code false} otherwise
     */
    boolean hasItemStack(int itemId, int minAmount, int maxAmount, int damage);

    /**
     * Adds the item to the set, appending to stacks or with no or full stack,
     * adds a new stack. Stack sizes correspond with the max of the item
     *
     * @param item
     *         the {@link Item} to insert
     *
     * @return true if all items are in the inventory, false when items are left
     * over. item is updated to the leftover-amount.
     */
    boolean insertItem(Item item);

    /**
     * Set a slot in the inventory with this item. Item contains slot
     * information.
     *
     * @param item
     *         the {@link Item} to set
     */
    void setSlot(Item item);

    /**
     * Set item with this id at the provided slot.
     *
     * @param itemId
     *         The ID number for this item.
     * @param amount
     *         amount of this item.
     * @param slot
     *         The slot for this item.
     */
    void setSlot(int itemId, int amount, int slot);

    /**
     * Put the specified item with the specified amount into the specified slot
     *
     * @param itemId
     *         The ID number for this item.
     * @param amount
     *         The amount of this item.
     * @param damage
     *         Damage value for this item.
     * @param slot
     *         The slot for this item.
     */
    void setSlot(int itemId, int amount, int damage, int slot);

    /**
     * Put the specified item with the specified amount into the specified slot
     *
     * @param machineName
     *         The internal name for this item.
     * @param amount
     *         The amount of this item.
     * @param slot
     *         The slot for this item.
     */
    void setSlot(String machineName, int amount, int slot);

    /**
     * Put the specified item with the specified amount into the specified slot
     *
     * @param type
     *         The ItemType of this item.
     * @param amount
     *         The amount of this item.
     * @param slot
     *         The slot for this item.
     */
    void setSlot(ItemType type, int amount, int slot);

    /**
     * Remove an item from this container
     *
     * @param item
     *         the {@link Item} to remove
     *
     * @return the {@link Item} instance removed or {@code null} if no item
     */
    Item removeItem(Item item);

    /**
     * Remove an item by this ID from the container
     *
     * @param id
     *         ID value for this item.
     *
     * @return the {@link Item} instance removed or {@code null} if no item
     */
    Item removeItem(int id);

    /**
     * Remove an item by this ID from the container
     *
     * @param id
     *         ID value for this item.
     * @param damage
     *         Damage value for this item.
     *
     * @return the {@link Item} instance removed or {@code null} if no item
     */
    Item removeItem(int id, int damage);

    /**
     * Remove an item by this ID from the container
     *
     * @param machineName
     *         The internal name for this item.
     *
     * @return the {@link Item} instance removed or {@code null} if no item
     */
    Item removeItem(String machineName);

    /**
     * Remove an item by this ID from the container
     *
     * @param type
     *         The ItemType for this item.
     *
     * @return the {@link Item} instance removed or {@code null} if no item
     */
    Item removeItem(ItemType type);

    /**
     * Set the contents of this container object
     *
     * @param items
     *         the {@link Item} array to set
     */
    void setContents(Item[] items);

    /**
     * Set the name of this container.
     *
     * @param value
     *         the name for the inventory
     */
    void setInventoryName(String value);

    /**
     * Set the slot at the given index with the specified value
     *
     * @param index
     *         the slot id
     * @param value
     *         the {@link Item} to set
     */
    void setSlot(int index, Item value);

    /**
     * Checks if this inventory can be opened remotely
     *
     * @return {@code true} if can be opened remotely; {@code false} if not.
     */
    boolean canOpenRemote();

    void setCanOpenRemote(boolean remote);

    /**
     * Update this container
     */
    void update();

    InventoryType getInventoryType();

    /**
     * Checks if the inventory has enough space to insert
     *
     * @param item
     *         The {@link Item} to insert
     *
     * @return {@code true} if there is room to insert, else {@code false}
     */
    boolean canInsertItems(Item item);
}
