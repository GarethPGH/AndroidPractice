package com.example.fitnessapp.placeholder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

    static {
        // Add some sample items.
            addItem(new PlaceholderItem("1", "Website", "https://www.snapfitness.com/us/gyms/etna-pa/"));
            addItem(new PlaceholderItem("2", "Information"));
            addItem(new PlaceholderItem("3", "Photo Gallery"));
    }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public String id;
        public String content;
        public String name;
        public String item_url = "";

        public PlaceholderItem(String id, String content){
            this.id = id;
            this.content = content;
        }

        public PlaceholderItem(String id, String name, String site) {
            this.id = id;
            content = name;
            this.name = name;
            this.item_url = site;
        }
        @Override
        public String toString() {
            return content;
        }
    }
}