package app.centers;

import app.animals.Animal;

import java.util.HashSet;
import java.util.Set;

public class CastrationCenter extends Center {

    public CastrationCenter(String name) {
        super(name);
    }

    public Set<Animal> castrateAnimals() {
        for (Animal animal : super.getAnimals()) {
            animal.castrate();
        }

        Set<Animal> toBeReturned = new HashSet<>(super.getAnimals());
        for (Animal animal : toBeReturned) {
            super.removeAnimal(animal);
        }

        return toBeReturned;
    }
}
