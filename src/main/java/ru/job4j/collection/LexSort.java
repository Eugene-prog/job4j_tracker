package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftParts = left.split("\\.");
        String[] rightParts = right.split("\\.");
        return Integer.compare(Integer.parseInt(leftParts[0]), Integer.parseInt(rightParts[0]));
    }
}