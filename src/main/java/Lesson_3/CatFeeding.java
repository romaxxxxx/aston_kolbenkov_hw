package Lesson_3;

import java.util.ArrayList;
import java.util.List;

import static Lesson_3.Satiety.голодный;
import static Lesson_3.Satiety.сытый;

public class CatFeeding {
    static int foodVolume = 71;

    public static void main(String[] args) {
        Bowl.addFood(foodVolume);
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Васька", 20);
        cats[1] = new Cat("Матроскин", 80);
        cats[2] = new Cat("Тотошка", 1);
        cats[3] = new Cat("Платошка", 80);

        for (Cat cat : cats) {
            cat.eatFromBowl();
            Satiety catSatiety = !cat.isSatiety() ? голодный : сытый;
            System.out.printf("Кот %s сегодня %s\n", cat.getName(), catSatiety);
        }
    }
}