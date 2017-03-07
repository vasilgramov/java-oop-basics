package p03_wildFarm;

public class AnimalFactory {

    public static Animal createAnimal(String[] animalArgs) {
        String animalType = animalArgs[0];
        String animalName = animalArgs[1];
        double animalWeight = Double.parseDouble(animalArgs[2]);
        String animalLivingRegion = animalArgs[3];

        switch (animalType) {
            case "Mouse":
                return new Mouse(animalName, animalType, animalWeight, 0, animalLivingRegion);
            case "Cat":
                String catBreed = animalArgs[4];
                return new Cat(animalName, animalType, animalWeight, 0, animalLivingRegion, catBreed);
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, 0, animalLivingRegion);
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, 0, animalLivingRegion);
            default:
                return null;
        }
    }
}
