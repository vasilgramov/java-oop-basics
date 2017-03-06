package p03_wildFarm;

public class Mouse extends Mammal {


    protected Mouse(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    protected void eat(Food food) {
        if (!"Vegetable".equals(food.getClass().getSimpleName())) {
            throw new IllegalArgumentException("Mouses are not eating that type of food!");
        }

        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }
}
