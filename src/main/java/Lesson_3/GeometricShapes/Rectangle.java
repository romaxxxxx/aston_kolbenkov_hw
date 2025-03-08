package Lesson_3.GeometricShapes;

public class Rectangle extends Shapes implements CalcPerimeter {
    private double a, b;

    public Rectangle(String fillColor, String borderColor, double a, double b) {
        super(fillColor, borderColor);
        this.a = a;
        this.b = b;
    }

    @Override
    public double rectangleArea(double a, double b) {
        return CalcPerimeter.super.rectangleArea(a, b);
    }

    @Override
    public double rectanglePerimeter(double a, double b) {
        return CalcPerimeter.super.rectanglePerimeter(a, b);
    }
    @Override
    public void printInfo() {
        System.out.printf("Площадь прямоугольника: %4.3f, Периметр прямоугольника: %4.3f, Цвет прямоугольника: %s, Цвет границы прямоугольника: %s\n",
                rectangleArea(this.a, this.b), rectanglePerimeter(this.a, this.b), super.getFillColor(),
                super.getBorderColor());
    }
}