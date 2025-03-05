package Lesson_3;

import static Lesson_3.Satiety.голодный;
import static Lesson_3.Satiety.сытый;

public class CatFeeding {
    public static void main(String[] args) {
        Bowl bowl = new Bowl();
        bowl.addFood(61);
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Васька", 20);
        cats[1] = new Cat("Матроскин", 40);
        cats[2] = new Cat("Тотошка", 1);
        for (Cat cat : cats) {
            cat.eatFromBowl(bowl);
            Satiety catSatiety = !cat.satiety ? голодный : сытый;
            System.out.printf("Кот %s сегодня %s\n", cat.name, catSatiety);
        }
    }
}