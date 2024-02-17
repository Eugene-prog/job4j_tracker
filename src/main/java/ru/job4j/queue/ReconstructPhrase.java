package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        Iterator<Character> iterator = evenElements.iterator();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (iterator.hasNext()) {
            char element = iterator.next();
            if (count % 2 == 0) {
                sb.append(element);
            }
            count++;
        }
        return sb.toString();
    }

    private String getDescendingElements() {
        Iterator<Character> descendingIterator = descendingElements.descendingIterator();
        StringBuilder sb = new StringBuilder();
        while (descendingIterator.hasNext()) {
            sb.append(descendingIterator.next());
        }
        return sb.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}