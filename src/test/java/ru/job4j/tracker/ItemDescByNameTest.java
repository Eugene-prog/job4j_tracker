package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemDescByNameTest {
    @Test
    void testAscendingSort() {
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(8, "Task8"));
        expected.add(new Item(5, "Task5"));
        expected.add(new Item(2, "Task2"));
        List<Item> items = new ArrayList<>(expected);
        Collections.sort(items, new ItemDescByName());
        assertEquals(expected, items);
    }
}