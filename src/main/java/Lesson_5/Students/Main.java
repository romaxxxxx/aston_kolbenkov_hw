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

        printStudents(studentsSet, 5);
        removingStudents(studentsSet);
        printStudents(studentsSet, 5);
        printStudents(studentsSet, 3);
        printStudents(studentsSet, 4);
        studentsUpToLevel(studentsSet);
        printStudents(studentsSet, 4);
        printStudents(studentsSet, 5);

    }

    static void removingStudents(Set<Student> students) {
        Set<Student> studentsForRemove = students.stream()
                .filter(s -> s.avarageGrade() < 3)
                .collect(Collectors.toSet());

        students.removeAll(studentsForRemove);

        if (!studentsForRemove.isEmpty()) {
            System.out.printf("Отчислены студенты: %s\n", studentsForRemove);
        } else {
            System.out.println("Никто из студентов не отчислен");
        }
    }

    static void studentsUpToLevel(Set<Student> students) {
        Set<Student> upLeveledStudents = students.stream()
                .filter(s -> s.avarageGrade() >= 3)
                .collect(Collectors.toSet());

                upLeveledStudents.forEach(Student::upLevelCourse);

                if(!upLeveledStudents.isEmpty()){
                    System.out.printf("Переведены на следующий курс студенты: %s\n", upLeveledStudents);
                } else{
                    System.out.println("Никто из студентов не переведен на следующий курс");
                }
    }

    static void printStudents(Set<Student> students, int course) {
        Set<Student> studentsOnCourse = students.stream()
                .filter(s -> s.getCourse() == course)
                .collect(Collectors.toSet());

        if (!studentsOnCourse.isEmpty()) {
            System.out.printf("Студенты %d курса: %s\n", course, studentsOnCourse);
        } else {
            System.out.printf("На %d курсе нет студентов\n", course);
        }
    }
}