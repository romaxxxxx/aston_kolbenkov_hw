package Lesson_3.GeometricShapes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Синий", "Красный", 5);
        Triangle triangle = new Triangle("Черный", "Белый", 4, 3, 4, 5);
        Rectangle rectangle = new Rectangle("Желтый", "Бурый", 4,5);

        List<Shapes> shapes = new ArrayList<>();
        shapes.add(triangle);
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.stream().forEach(Shapes::printInfo);
    }
}