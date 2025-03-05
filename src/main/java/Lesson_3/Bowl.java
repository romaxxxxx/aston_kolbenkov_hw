package Lesson_3;

class Bowl {
    public int foodVolume;

    public int getFoodVolume() {
        return foodVolume;
    }

    void addFood(int foodVolume) {
        this.foodVolume = foodVolume;
    }
    public int degressFoodVolume(Cat cat) {
        return this.foodVolume -= cat.getFoodAmountSatiety();
    }

}