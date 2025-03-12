package Lesson_5.Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Student> studentsSet = new HashSet<>();
        studentsSet.add(new Student("Вася", "5", 5, Map.of("Химия", 2, "Физика", 3)));
        studentsSet.add(new Student("Петя", "4", 3, Map.of("Химия", 4, "Физика", 4)));
        studentsSet.add(new Student("Коля", "4", 3, Map.of("Химия", 3, "Физика", 4)));
        studentsSet.add(new Student("Слава", "4", 3, Map.of("Химия", 5, "Физика", 5)));

        studentsDelete(studentsSet);
        studentsUpToLevel(studentsSet);
        printStudents(studentsSet, 4);
    }

    static void studentsDelete(Set<Student> students) {
        Set<Student> stForRemove = new HashSet<>();
        for (Student student : students) {
            if (student.avarageGrade() < 3)
                stForRemove.add(student);
        }
        students.removeAll(stForRemove);
    }

    static void studentsUpToLevel(Set<Student> students) {
        for (Student student : students) {
            if (student.avarageGrade() >= 3) {
                student.upLevelCourse();
            }
        }
    }

    static void printStudents(Set<Student> students, int course) {
        Set<String> studentsOnCourse = new HashSet<>();
        for (Student student : students) {
            if (student.getCourse() == course) {
                studentsOnCourse.add(student.getName());
            }
        }
        System.out.printf("Студенты %d курса: %s", course, studentsOnCourse);
    }
}