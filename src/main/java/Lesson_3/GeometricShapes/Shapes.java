package Lesson_3.GeometricShapes;

abstract public class  Shapes {
    private String fillColor;
    private String borderColor;

    public Shapes(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
    public abstract void printInfo();
}
