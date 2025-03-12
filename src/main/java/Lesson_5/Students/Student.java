package Lesson_5.Students;

import java.util.Map;
import java.util.Objects;

public class Student {
    String name;
    String group;
    int course;
    Map<String, Integer> gradesBySubjects;

    public Student(String name, String group, int course, Map<String, Integer> gradesBySubjects) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.gradesBySubjects = gradesBySubjects;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public Map<String, Integer> getGradesBySubjects() {
        return gradesBySubjects;
    }

    public double avarageGrade() {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : this.getGradesBySubjects().entrySet()) {
            sum += entry.getValue();
        }
        return sum / 2;
    }

    public void upLevelCourse() {
        this.course++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

