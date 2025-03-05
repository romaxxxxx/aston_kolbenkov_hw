package Lesson_3;

class Cat extends Animal implements eatableFromBowl{
    static int catCount;
    private final int foodAmountSatiety;
    private boolean satiety = false;

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
    public void eatFromBowl() {
        if (Bowl.getFoodVolume() > this.foodAmountSatiety) {
            Bowl.degressFoodVolume(this);
            this.satiety = true;
        }
    }

    public int getFoodAmountSatiety() {
        return foodAmountSatiety;
    }

    public boolean isSatiety() {
        return satiety;
    }
}