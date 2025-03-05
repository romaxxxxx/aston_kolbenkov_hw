package Lesson_3;

class Bowl {
    private static int foodVolume;

    static int getFoodVolume() {
        return foodVolume;
    }

    static void addFood(int foodVolume) {
        Bowl.foodVolume = foodVolume;
    }

    static void degressFoodVolume(Cat cat) {
        Bowl.foodVolume -= cat.getFoodAmountSatiety();
    }
}