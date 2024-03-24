package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrLeft = left.split("/");
        String[] arrRight = right.split("/");
        int len = Math.min(arrLeft.length, arrRight.length);

        int res = arrRight[0].compareTo(arrLeft[0]);
        if (res != 0) {
            return res;
        }

        for (int i = 1; i < len; i++) {
            res = arrLeft[i].compareTo(arrRight[i]);
            if (res != 0) {
                return res;
            }
        }
        return Integer.compare(arrLeft.length, arrRight.length);
    }
}