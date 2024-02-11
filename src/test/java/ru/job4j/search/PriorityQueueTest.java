package ru.job4j.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPrioritySecond() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDescription()).isEqualTo("urgent");
    }

    @Test
    public void whenHigherPriorityEquals() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 5));
        queue.put(new Task("middle", 5));
        Task result = queue.take();
        assertThat(result.getDescription()).isEqualTo("low");
    }

    @Test
    public void whenHigherPriorityThird() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 3));
        queue.put(new Task("middle", 2));
        queue.put(new Task("urgent", 1));
        Task result = queue.take();
        assertThat(result.getDescription()).isEqualTo("urgent");
    }
}