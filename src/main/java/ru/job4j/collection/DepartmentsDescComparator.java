package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrLeft = left.split("/");
        String[] arrRight = right.split("/");
        int res = arrRight[0].compareTo(arrLeft[0]);
        return res != 0 ? res : left.compareTo(right);
    }
}