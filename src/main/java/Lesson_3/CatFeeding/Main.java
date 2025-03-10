package Lesson_3.CatFeeding;

public class Main {
    static int foodVolume = 61;

    public static void main(String[] args) {
        Bowl.addFood(foodVolume);
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Васька", 20);
        cats[1] = new Cat("Матроскин", 40);
        cats[2] = new Cat("Тотошка", 1);
        cats[3] = new Cat("Платошка", 10);

        for (Cat cat : cats) {
            cat.eatFromBowl();
            cat.catSatietyInfo();
        }

        new Dog("Шарик")
                .run(499);
        new Dog("Тузик")
                .swim(9);
        new Cat("Сима", 5)
                .swim(5);
        new Cat("Матроскин", 3)
                .run(201);

        Animal.AnimalCountInfo();
        Cat.catCountInfo();
        Dog.DogCountInfo();
    }
}