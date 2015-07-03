package net.canarymod.backbone;

import net.canarymod.database.DataAccess;
import net.canarymod.database.Database;
import net.canarymod.database.exceptions.DatabaseReadException;
import net.canarymod.database.exceptions.DatabaseWriteException;
import net.canarymod.kit.Kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static net.canarymod.Canary.log;

/**
 * Backbone to the kits System. This contains NO logic, it is only the data
 * source access!
 *
 * @author Chris (damagefilter)
 */
public class BackboneKits extends Backbone {

    private static KitDataAccess schema = new KitDataAccess();

    public BackboneKits() {
        super(Backbone.System.KITS);
        try {
            Database.get().updateSchema(schema);
        }
        catch (DatabaseWriteException e) {
            log.error("Failed to update database schema", e);
        }
    }

    private boolean kitExists(Kit kit) {
        KitDataAccess data = new KitDataAccess();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("name", kit.getName());
            Database.get().load(data, filter);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        return data.hasData();
    }

    /**
     * Add a new Kit to the list of Kits.
     *
     * @param kit
     *         Adds the kit instance to the list of kits.
     */
    public void addKit(Kit kit) {
        if (kitExists(kit)) {
            updateKit(kit);
            return;
        }
        KitDataAccess data = new KitDataAccess();

        data.groups = kit.getGroups() != null ? new ArrayList<String>(Arrays.asList(kit.getGroups())) : new ArrayList<String>();
        data.items = kit.getItemsAsStringList();
        data.name = kit.getName();
        data.owners = kit.getOwner() != null ? new ArrayList<String>(Arrays.asList(kit.getOwner())) : new ArrayList<String>();
        data.useDelay = kit.getDelay();
        data.id = 0;

        try {
            Database.get().insert(data);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Remove a Kit from the data source
     *
     * @param kit
     *         Removes the kit instance from the list of kits.
     */
    public void removeKit(Kit kit) {
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("name", kit.getName());
            Database.get().remove(schema, filter);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Get a Kit with the given name
     *
     * @param name
     *         Name of the kit to get.
     *
     * @return a Kit object if that Kit was found, null otherwise
     */
    public Kit getKit(String name) {
        KitDataAccess data = new KitDataAccess();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("name", name);
            Database.get().load(data, filter);
            if (!data.hasData()) {
                return null;
            }
            Kit kit = new Kit();

            kit.setContentFromStrings(data.items);
            kit.setDelay(data.useDelay);
            kit.setGroups(data.groups.toArray(new String[data.groups.size()]));
            kit.setName(data.name);
            kit.setOwner(data.owners.toArray(new String[data.owners.size()]));
            kit.setId(data.id);
            return kit;
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Update a Kit
     *
     * @param kit
     *         Update this kit instance to the database.
     */
    public void updateKit(Kit kit) {
        KitDataAccess data = new KitDataAccess();

        data.groups = kit.getGroups() != null ? new ArrayList<String>(Arrays.asList(kit.getGroups())) : new ArrayList<String>();
        data.items = kit.getItemsAsStringList();
        data.name = kit.getName();
        data.owners = kit.getOwner() != null ? new ArrayList<String>(Arrays.asList(kit.getOwner())) : new ArrayList<String>();
        data.useDelay = kit.getDelay();
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("name", kit.getName());
            Database.get().update(data, filter);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Load and return all kits
     *
     * @return An ArrayList of all kits.
     */
    public List<Kit> loadKits() {
        List<DataAccess> dataList = new ArrayList<DataAccess>();
        List<Kit> kits = new ArrayList<Kit>();

        try {
            Database.get().loadAll(schema, dataList, new HashMap<String, Object>());
            for (DataAccess da : dataList) {
                KitDataAccess data = (KitDataAccess)da;
                Kit kit = new Kit();

                kit.setContentFromStrings(data.items);
                kit.setDelay(data.useDelay);
                kit.setGroups(data.groups.toArray(new String[data.groups.size()]));
                kit.setName(data.name);
                kit.setOwner(data.owners.toArray(new String[data.owners.size()]));
                kit.setId(data.id);
                kits.add(kit);
            }
            return kits;
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
