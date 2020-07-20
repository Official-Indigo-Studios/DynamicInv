package me.thebirmanator.dynamicinv.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileManager {

    private static Map<UUID, InventoryProfile> profiles;

    public static final String DEFAULT_PROFILE = "default";

    public static InventoryProfile getProfile(UUID uuid) {
        return profiles.get(uuid);
    }

    public static void cacheProfile(InventoryProfile profile) {
        profiles.put(profile.getUUID(), profile);
    }

    public static void uncacheProfile(InventoryProfile profile) {
        profiles.remove(profile.getUUID());
    }

    public static void saveProfile(InventoryProfile profile) {
        //TODO: database save
    }

    public static void deleteProfile(InventoryProfile profile) {
        //TODO: database delete
    }

    public static void load() {
        profiles = new HashMap<>();
    }
}
