package ru.job4j.stream;

import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil
                        .subjects()
                        .stream()
                        .map(Subject::score))
                .mapToInt(Number::intValue)
                .average()
                .orElse(0.00D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(pupil ->
                new Tuple(pupil.name(), pupil.subjects()
                        .stream()
                        .mapToDouble(Subject::score)
                        .average()
                        .orElse(0.0D))
        ).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects()
                        .stream()
                        .collect(Collectors.groupingBy(Subject::name,
                                Collectors.averagingDouble((Subject::score))))
                        .entrySet()
                        .stream()
                        .map(entry -> new Tuple(entry.getKey(), entry.getValue())))
                .collect(Collectors.groupingBy(Tuple::name))
                .entrySet()
                .stream()
                .map(entry ->
                        new Tuple(entry.getKey(),
                                entry.getValue().stream()
                                        .mapToDouble(Tuple::score)
                                        .average().orElse(0.0D))
                )
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil ->
                        new Tuple(pupil.name(),
                                pupil.subjects()
                                        .stream()
                                        .mapToDouble(Subject::score)
                                        .sum())
                )
                .max(Comparator.comparingDouble(Tuple::score)).orElse(new Tuple("", 0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects()
                        .stream()
                        .collect(Collectors.groupingBy(Subject::name,
                                Collectors.summingDouble((Subject::score))))
                        .entrySet()
                        .stream()
                        .map(entry -> new Tuple(entry.getKey(), entry.getValue())))
                .collect(Collectors.groupingBy(Tuple::name))
                .entrySet()
                .stream()
                .map(entry ->
                        new Tuple(entry.getKey(),
                                entry.getValue()
                                        .stream()
                                        .mapToDouble(Tuple::score)
                                        .sum())
                )
                .max(Comparator.comparingDouble(Tuple::score)).orElse(new Tuple("", 0));
    }
}