package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : departments) {
            String[] parts = value.split("/");
            String start = parts[0];
            temp.add(start);
            for (int i = 1; i < parts.length; i++) {
                start += "/" + parts[i];
                temp.add(start);
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        Collections.sort(departments);
    }

    public static void sortDesc(List<String> departments) {
        Collections.sort(departments, new DepartmentsDescComparator());
    }
}