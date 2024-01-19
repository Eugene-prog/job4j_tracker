package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        if (key == null) {
            return new Item[0];
        }
        Item[] result = new Item[items.length];
        int count = 0;
        for (Item item : items) {
            if (item != null && key.equals(item.getName())) {
                result[count++] = item;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

}