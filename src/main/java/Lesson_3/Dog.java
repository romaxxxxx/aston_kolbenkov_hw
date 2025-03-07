package Lesson_3;

class Dog extends Animal {

    private final static int SWIMMING_DISTANCE_CAPACITY = 10;
    private final static int RUNNING_DISTANCE_CAPACITY = 500;
    private static int dogCount = 0;
    public Dog(String dogName) {
        super(dogName);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}