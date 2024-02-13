package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    private ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
            size = items.size();
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (key.equals(items.get(i).getName())) {
                result.add(items.get(i));
            }
        }
        return result;
    }

    public ArrayList<Item> findAll() {
        return new ArrayList<>(items);
    }
}