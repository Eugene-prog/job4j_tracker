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

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1 || item == null) {
            return false;
        }
        int prevId = items[index].getId();
        items[index] = item;
        item.setId(prevId);
        return true;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return;
        }
        System.arraycopy(items, index, items, index + 1, size - index - 1);
        items[size - 1] = null;
        size--;
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