package Lesson_3;

import static Lesson_3.Satiety.голодный;
import static Lesson_3.Satiety.сытый;

public class CatFeeding {
    static int foodVolume = 61;
    public static void main(String[] args) {
        Bowl.addFood(foodVolume);
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Васька", 20);
        cats[1] = new Cat("Матроскин", 40);
        cats[2] = new Cat("Тотошка", 1);
        for (Cat cat : cats) {
            cat.eatFromBowl();
            Satiety catSatiety = !cat.isSatiety() ? голодный : сытый;
            System.out.printf("Кот %s сегодня %s\n", cat.name, catSatiety);
        }
    }
}