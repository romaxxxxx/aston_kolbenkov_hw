package Lesson_3.GeometricShapes;

public class Circle extends Shapes implements CalcuatableShapesChar {
    private double r;
    public Circle(String fillColor, String borderColor, double r) {
        super(fillColor, borderColor);
        this.r = r;
    }

    @Override
    public double circlePerimeter(double r) {
        return CalcuatableShapesChar.super.circlePerimeter(r);
    }

    @Override
    public double circleArea(double r) {
        return CalcuatableShapesChar.super.circleArea(r);
    }
    @Override
    public void printInfo(){
        System.out.printf("Площадь круга: %4.3f, Периметр круга: %4.3f, Цвет круга: %s, Цвет границы круга: %s\n",
                circleArea(this.r), circlePerimeter(this.r), super.getFillColor(), super.getBorderColor());
    }
}