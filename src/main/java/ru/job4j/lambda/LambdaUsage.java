package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a", "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare length - " + left.length() + " " + right.length());
            return Integer.compare(left.length(), right.length());
        };
        strings.sort(comparator);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}