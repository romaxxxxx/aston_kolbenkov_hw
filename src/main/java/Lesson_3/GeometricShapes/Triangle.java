package Lesson_3.GeometricShapes;

public class Triangle extends Shapes implements CalcPerimeter {
    double a,b,c;
    double h;
    public Triangle(String fillColor, String borderColor, double a, double b, double c, double h) {
        super(fillColor, borderColor);
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    public double triangleArea(double a, double h) {
        return CalcPerimeter.super.triangleArea(a, h);
    }

    @Override
    public double trianglePerimeter(double a, double b, double c) {
        return CalcPerimeter.super.trianglePerimeter(a, b, c);
    }


    @Override
    public void printInfo() {
        System.out.printf("Площадь треугольника: %4.3f, Периметр треугольника: %4.3f, Цвет треугольника: %s, Цвет треугольника: %s\n",
                triangleArea(this.a, this.h), trianglePerimeter(this.a, this.b, this.c), super.getFillColor(),
                super.getBorderColor());
    }
}