package Lesson_5.Students;

import java.util.Map;
import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private int course;
    private final Map<String, Integer> gradesBySubjects;

    public Student(String name, String group, int course, Map<String, Integer> gradesBySubjects) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.gradesBySubjects = Objects.requireNonNull(gradesBySubjects, "gradesBySubjects must not be null");
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
        return sum / getGradesBySubjects().size();
    }

    public void upLevelCourse() {
        this.course++;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}