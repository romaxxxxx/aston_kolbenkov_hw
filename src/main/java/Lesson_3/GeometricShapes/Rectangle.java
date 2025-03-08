package Lesson_3.GeometricShapes;

public class Rectangle extends Shapes implements CalcPerimeter {
    public Rectangle(String fillColor, String borderColor) {
        super(fillColor, borderColor);
    }

    @Override
    public void printInfo() {

    }

    @Override
    public double rectangleArea(double a, double b) {
        return CalcPerimeter.super.rectangleArea(a, b);
    }

    @Override
    public double rectanglePerimeter(double a, double b) {
        return CalcPerimeter.super.rectanglePerimeter(a, b);
    }
}