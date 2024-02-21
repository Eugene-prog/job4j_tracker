package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double score = 0;
        for (Pupil pupil : pupils) {
            count += pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
        }
        return count != 0 ? score / count : 0;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averageScorePupils = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int count = 0;
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                count++;
                score += subject.score();
            }
            double averageScore = count != 0 ? score / count : 0;
            averageScorePupils.add(new Label(pupil.name(), averageScore));
        }
        return averageScorePupils;
    }

    public static Map<String, Integer> averageScoreMapCalculate(List<Pupil> pupils) {
        Map<String, Integer> averageScoreMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                averageScoreMap.put(subject.name(),
                        averageScoreMap.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        return averageScoreMap;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> averageScoreMap = averageScoreMapCalculate(pupils);
        List<Label> result = new ArrayList<>();
        int studentsCount = pupils.size();
        for (String key : averageScoreMap.keySet()) {
            Integer value = averageScoreMap.get(key);
            double averageScore = studentsCount != 0 ? value / studentsCount : 0;
            result.add(new Label(key, averageScore));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        if (pupils.isEmpty()) {
            return null;
        }
        List<Label> bestStudents = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            bestStudents.add(new Label(pupil.name(), score));
        }
        Comparator<Label> comparator = Comparator.comparing(Label::score);
        bestStudents.sort(comparator);
        return bestStudents.get(bestStudents.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> averageScoreMap = averageScoreMapCalculate(pupils);
        List<Label> result = new ArrayList<>();
        for (String key : averageScoreMap.keySet()) {
            Integer value = averageScoreMap.get(key);
            result.add(new Label(key, value));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}