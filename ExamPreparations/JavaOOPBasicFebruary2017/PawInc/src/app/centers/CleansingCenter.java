package app.centers;

import app.animals.Animal;

import java.util.HashSet;
import java.util.Set;

public class CleansingCenter extends Center {


    public CleansingCenter(String name) {
        super(name);
    }

    public Set<Animal> cleanseAnimals() {
        for (Animal animal : super.getAnimals()) {
            animal.cleanse();
        }

        Set<Animal> toBeReturned = new HashSet<>(super.getAnimals());
        for (Animal animal : toBeReturned) {
            super.removeAnimal(animal);
        }

        return toBeReturned;
    }

    public int countOfNonCleansedAnimals() {
        int count = 0;
        for (Animal animal : super.getAnimals()) {
            if (!animal.isCleansed()) {
                count++;
            }
        }

        return count;
    }
}
