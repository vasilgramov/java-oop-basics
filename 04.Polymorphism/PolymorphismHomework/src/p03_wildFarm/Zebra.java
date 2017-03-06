package p03_wildFarm;

public class Zebra extends Mammal {


    protected Zebra(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Food food) {
        if (!"Vegetable".equals(food.getClass().getSimpleName())) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }

        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }
}
