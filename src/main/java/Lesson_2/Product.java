package Lesson_2;

import java.util.Arrays;

import static java.lang.String.format;

public class Product {
    String name;
    String productionDate;
    String manufacturer;
    String countryOfOrigin;
    long price;
    boolean statusOfTheBookingByTheBuyer;

    Product(String name, String productionDate, String manufacturer, String countryOfOrigin, long price,
            Boolean statusOfTheBookingByTheBuyer) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.statusOfTheBookingByTheBuyer = statusOfTheBookingByTheBuyer;
    }

    public void printToConsoleProductInfo() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Ваз 2103", "01.01.0001", "Автоваз",
                "РФ", 32434, true);
        productsArray[1] = new Product("Зеленый чай", "01.01.0002", "Ahmed",
                "Англия", 34, false);
        productsArray[2] = new Product("Творог", "01.01.0003", "Брест Литовск",
                "РБ", 155, true);
        productsArray[3] = new Product("Optix MAG241CP", "01.01.0004", "MSI",
                "Тайвань", 30000, false);
        productsArray[4] = new Product("Starship ", "01.01.0005", "SpaceX",
                "СШП", 999999999999999999L, true);

        for (Product product : productsArray) {
            product.printToConsoleProductInfo();
        }
    }

    @Override
    public String toString() {
        return format("Название: %s, Дата производства: %S, Производитель: %s, Страна происхождения: %s, Цена: %s," +
                        "Состояние бронирования покупателем: %S",
                this.name, this.productionDate, this.manufacturer, this.countryOfOrigin, this.price,
                this.statusOfTheBookingByTheBuyer);
    }
}