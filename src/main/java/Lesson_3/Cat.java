package Lesson_3;

class Cat extends Animal implements eatableFromBowl {
    static int catCount;
    int foodAmountSatiety;
    boolean satiety = false;

    public Cat(String catName, int foodAmountSatiety) {
        super(catName, 200, 0);
        this.foodAmountSatiety = foodAmountSatiety;
        catCount++;
    }

    @Override
    void swim(int obstacleLength) {
        System.out.println("Кот не умеет плавать");
    }

    @Override
    public void eatFromBowl(Bowl bowl) {
        if (bowl.foodVolume > this.foodAmountSatiety) {
            bowl.foodVolume -= this.foodAmountSatiety;
            this.satiety = true;
        }
    }
}