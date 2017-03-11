package app;

import app.animals.Animal;
import app.animals.Cat;
import app.animals.Dog;
import app.centers.AdoptionCenter;
import app.centers.CastrationCenter;
import app.centers.CleansingCenter;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager {
    private Map<String, AdoptionCenter> adoptionCenters;
    private Map<String, CleansingCenter> cleansingCenters;
    private Map<String, CastrationCenter> castrationCenters;

    private Set<Animal> adoptedAnimals;
    private Set<Animal> cleanedAnimals;

    private List<Animal> castratedAnimals;

    public AnimalCenterManager() {
        this.adoptionCenters = new HashMap<>();
        this.cleansingCenters = new HashMap<>();
        this.castrationCenters = new HashMap<>();

        this.adoptedAnimals = new TreeSet<>();
        this.cleanedAnimals = new TreeSet<>();

        this.castratedAnimals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        this.cleansingCenters.put(name, new CleansingCenter(name));
    }

    public void registerAdoptionCenter(String name) {
        this.adoptionCenters.put(name, new AdoptionCenter(name));
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        if (this.adoptionCenters.containsKey(adoptionCenterName)) {
            AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);

            Animal dog = new Dog(name, age, learnedCommands, adoptionCenterName);
            adoptionCenter.accept(dog);
        }
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        if (this.adoptionCenters.containsKey(adoptionCenterName)) {
            AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);

            Animal cat = new Cat(name, age, intelligenceCoefficient, adoptionCenterName);
            adoptionCenter.accept(cat);
        }
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        if (this.adoptionCenters.containsKey(adoptionCenterName) && this.cleansingCenters.containsKey(cleansingCenterName)) {
            AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
            CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);

            adoptionCenter.sendForCleanse(cleansingCenter);
        }
    }

    public void cleanse(String cleansingCenterName) {
        if (this.cleansingCenters.containsKey(cleansingCenterName)) {
            CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);

            Set<Animal> currentCleansedAnimals = cleansingCenter.cleanseAnimals();
            for (Animal cleansedAnimal : currentCleansedAnimals) {
                String cleansedAnimalAdoptionCenter = cleansedAnimal.getAdoptionCenter();
                if (this.adoptionCenters.containsKey(cleansedAnimalAdoptionCenter)) {
                    AdoptionCenter adoptionCenter = this.adoptionCenters.get(cleansedAnimalAdoptionCenter);
                    adoptionCenter.returnAnimal(cleansedAnimal);
                }
            }

            this.cleanedAnimals.addAll(currentCleansedAnimals);
        }
    }

    public void adopt(String adoptionCenterName) {
        if (this.adoptionCenters.containsKey(adoptionCenterName)) {
            AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
            this.adoptedAnimals.addAll(adoptionCenter.adoptAnimals());
        }
    }

    public void registerCastrationCenter(String castrationCenterName) {
        this.castrationCenters.put(castrationCenterName, new CastrationCenter(castrationCenterName));
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        if (this.castrationCenters.containsKey(castrationCenterName) && this.adoptionCenters.containsKey(adoptionCenterName)) {
            AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
            CastrationCenter castrationCenter = this.castrationCenters.get(castrationCenterName);

            adoptionCenter.sendForCastration(castrationCenter);
        }
    }

    public void castrate(String castrationCenterName) {
        if (this.castrationCenters.containsKey(castrationCenterName)) {
            CastrationCenter castrationCenter = this.castrationCenters.get(castrationCenterName);

            Set<Animal> currentCastratedAnimals = castrationCenter.castrateAnimals();
            for (Animal castratedAnimal : currentCastratedAnimals) {
                String castratedAnimalAdoptionCenter = castratedAnimal.getAdoptionCenter();
                if (this.adoptionCenters.containsKey(castratedAnimalAdoptionCenter)) {
                    AdoptionCenter adoptionCenter = this.adoptionCenters.get(castratedAnimalAdoptionCenter);
                    adoptionCenter.returnAnimal(castratedAnimal);
                }
            }

            this.castratedAnimals.addAll(currentCastratedAnimals);
        }
    }

    public void castrationStatistics() {
        StringBuilder builder = new StringBuilder();

        List<String> sortedAnimals = this.castratedAnimals.stream()
                .map(Animal::getName)
                .sorted(Collator.getInstance())
                .collect(Collectors.toList());

        builder.append("Paw Inc. Regular Castration Statistics\n")
                .append(String.format("Castration Centers: %d\n", this.castrationCenters.size()))
                .append("Castrated Animals: " + (sortedAnimals.size() > 0 ? sortedAnimals.toString().replace("[", "").replace("]", "") : "None"));

        System.out.println(builder.toString());
    }

    public void printStatistics() {
        StringBuilder builder = new StringBuilder();

        builder.append("Paw Incorporative Regular Statistics\n")
                .append(String.format("Adoption Centers: %d\n", this.adoptionCenters.size()))
                .append(String.format("Cleansing Centers: %d\n", this.cleansingCenters.size()))
                .append("Adopted Animals: " + (this.adoptedAnimals.size() > 0 ? this.adoptedAnimals.toString().replace("[", "").replace("]", "") : "None") + "\n")
                .append("Cleansed Animals: " + (this.cleanedAnimals.size() > 0 ? this.cleanedAnimals.toString().replace("[", "").replace("]", "") : "None") + "\n")
                .append(String.format("Animals Awaiting Adoption: %d\n", this.getAnimalsAwaitingAdoption()))
                .append(String.format("Animals Awaiting Cleansing: %d", this.getAnimalsAwaitingCleansing()));

        System.out.println(builder.toString());
    }

    private int getAnimalsAwaitingAdoption() {
        int count = 0;
        for (AdoptionCenter adoptionCenter : this.adoptionCenters.values()) {
            count += adoptionCenter.countOfNonAdoptedAnimals();
        }

        return count;
    }

    private int getAnimalsAwaitingCleansing() {
        int count = 0;
        for (CleansingCenter cleansingCenter : this.cleansingCenters.values()) {
            count += cleansingCenter.countOfNonCleansedAnimals();
        }

        return count;
    }


}
