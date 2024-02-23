package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            char charLeft = left.charAt(i);
            char charRight = right.charAt(i);
            if (Character.compare(charLeft, charRight) != 0) {
                return charLeft - charRight;
            }
        }
        return left.length() - right.length();
    }
}