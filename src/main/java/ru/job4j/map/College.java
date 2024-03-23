package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(student -> student.account().equals(account))
                .findFirst();
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> studentOptional = findByAccount(account);
        if (findByAccount(account).isPresent()) {
            Student student = studentOptional.get();
            return students.get(student)
                    .stream()
                    .filter(subject -> subject.name().equals(name))
                    .findFirst();
        }
        return Optional.empty();
    }

}