package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(student -> student != null)
                .sorted((left, right) -> (right.getScore() - left.getScore()))
                .takeWhile(student -> student.getScore() >= bound)
                .collect(Collectors.toList());
    }
}