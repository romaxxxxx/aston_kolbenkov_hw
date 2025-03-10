package Lesson_3.CatFeeding;

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String dogName) {
        super(dogName, 10, 500);
        dogCount++;
    }

    public static void DogCountInfo() {
        System.out.printf("Всего создано собак: %d\n", dogCount);
    }
}