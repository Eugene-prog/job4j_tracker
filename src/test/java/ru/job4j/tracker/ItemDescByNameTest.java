package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemDescByNameTest {
    @Test
    void testAscendingSort() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(8, "Task8"));
        items.add(new Item(5, "Task5"));
        items.add(new Item(2, "Task2"));
        List<Item> expected = new ArrayList<>(items);
        System.out.println(expected);
        Collections.sort(expected, new ItemDescByName());
        assertEquals(expected, items);
    }
}