package Lesson_3.GeometricShapes;

public interface CalcPerimeter {
    default double circlePerimeter(double r) {
        return 2 * Math.PI * r;
    }

    default double circleArea(double r) {
        return Math.PI * r * r;
    }

    default double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    default double triangleArea(double a, double h) {
        return 0.5 * a * h;
    }


    default double rectanglePerimeter(double a, double b) {
        return (a + b) * 2;
    }

    default double rectangleArea(double a, double b) {
        return (a + b) * 2;
    }

}
