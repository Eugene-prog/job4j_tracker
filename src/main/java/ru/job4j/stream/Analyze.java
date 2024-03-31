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
        return stream.map(pupil -> {
            double averageScore = pupil.subjects()
                    .stream()
                    .mapToDouble(Subject::score)
                    .average()
                    .orElse(0.0D);
            return new Tuple(pupil.name(), averageScore);
        }).collect(Collectors.toList());
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
                .map(entry -> {
                    double averageScore = entry.getValue().stream()
                            .mapToDouble(Tuple::score)
                            .average().orElse(0.0);
                    return new Tuple(entry.getKey(), averageScore);
                })
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> {
            double averageScore = pupil.subjects()
                    .stream()
                    .mapToDouble(Subject::score)
                    .sum();
            return new Tuple(pupil.name(), averageScore);
        }).max(Comparator.comparingDouble(Tuple::score)).get();
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
                .map(entry -> {
                    double sumScore = entry.getValue().stream()
                            .mapToDouble(Tuple::score)
                            .sum();
                    return new Tuple(entry.getKey(), sumScore);
                })
                .max(Comparator.comparingDouble(Tuple::score)).get();
    }
}