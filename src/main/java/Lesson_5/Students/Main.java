package Lesson_5.Students;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Student> studentsSet = new HashSet<>();
        studentsSet.add(new Student("Вася", "5", 5, Map.of("Химия", 2, "Физика", 3)));
        studentsSet.add(new Student("Петя", "4", 3, Map.of("Химия", 4, "Физика", 4)));
        studentsSet.add(new Student("Коля", "4", 3, Map.of("Химия", 3, "Физика", 4)));
        studentsSet.add(new Student("Слава", "4", 4, Map.of("Химия", 5, "Физика", 5)));

        removingStudents(studentsSet);
        studentsUpToLevel(studentsSet);
        printStudents(studentsSet, 4);
    }

    static void removingStudents(Set<Student> students) {
        Set<Student> studentsForRemove =  students.stream()
                .filter(s -> s.avarageGrade() < 3)
                .collect(Collectors.toSet());
        students.removeAll(studentsForRemove);
    }

    static void studentsUpToLevel(Set<Student> students) {
        students.stream()
                .filter(s -> s.avarageGrade() >= 3)
                .forEach(Student::upLevelCourse);
    }

    static void printStudents(Set<Student> students, int course) {
        Set<Student> studentsOnCourse = students.stream()
                .filter(s->s.getCourse()==course)
                .collect(Collectors.toSet());
        System.out.printf("Студенты %d курса: %s", course, studentsOnCourse);
    }
}