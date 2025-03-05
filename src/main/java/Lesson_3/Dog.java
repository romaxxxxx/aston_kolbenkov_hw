package Lesson_3;
class Dog extends Animal {
    int dogCount;

    public Dog(String dogName, int foodAmountSatiety) {
        super(dogName, 500, 10);
        this.dogCount++;
    }
}