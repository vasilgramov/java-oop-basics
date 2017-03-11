package app.centers;

import app.animals.Animal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdoptionCenter extends Center {


    public AdoptionCenter(String name) {
        super(name);
    }

    public void sendForCleanse(CleansingCenter cleansingCenter) {
        List<Animal> animalsToBeCleansed = new ArrayList<>();

        for (Animal animal : super.getAnimals()) {
            if (!animal.isCleansed()) {
                animalsToBeCleansed.add(animal);
            }
        }

        for (Animal animal : animalsToBeCleansed) {
            super.removeAnimal(animal);
            cleansingCenter.addAnimal(animal);
        }
    }

    public void sendForCastration(CastrationCenter castrationCenter) {
        List<Animal> animalsToBeCastrated = new ArrayList<>();

        for (Animal animal : super.getAnimals()) {
            if (!animal.isCleansed()) {
                animalsToBeCastrated.add(animal);
            }
        }

        for (Animal animal : animalsToBeCastrated) {
            super.removeAnimal(animal);
            castrationCenter.addAnimal(animal);
        }
    }

    public void accept(Animal animal) {
        this.addAnimal(animal);
    }

    public void returnAnimal(Animal animal) {
        this.addAnimal(animal);
    }

    public Set<Animal> adoptAnimals() {
        Set<Animal> animalsToBeAdopted = new HashSet<>();

        for (Animal animal : super.getAnimals()) {
            if (animal.isCleansed()) {
                animalsToBeAdopted.add(animal);
            }
        }


        for (Animal animal : animalsToBeAdopted) {
            super.removeAnimal(animal);
        }

        return animalsToBeAdopted;
    }

    public int countOfNonAdoptedAnimals() {
        int count = 0;
        for (Animal animal : super.getAnimals()) {
            if (animal.isCleansed()) {
                count++;
            }
        }

        return count;
    }
}
