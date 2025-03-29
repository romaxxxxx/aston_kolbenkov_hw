package Lesson_8.Data;

public class PayFieldsInfo {
    public String fieldName;
    public String webElementPlaceholderValue;
    public String actualPlaceholderValue;

    public PayFieldsInfo(String fieldName, String actualPlaceholderValue, String webElementPlaceholderValue) {
        this.fieldName = fieldName;
        this.webElementPlaceholderValue = webElementPlaceholderValue;
        this.actualPlaceholderValue = actualPlaceholderValue;
    }
}
