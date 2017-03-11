package app.centers;

import app.animals.Animal;

import java.util.HashSet;
import java.util.Set;

public abstract class Center {
    private String name;
    private Set<Animal> animals;

    protected Center(String name) {
        this.animals = new HashSet<>();

        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    protected Set<Animal> getAnimals() {
        return this.animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    protected void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    private void setName(String name) {
        this.name = name;
    }

    protected void addAnimal(Animal animal) {
        this.animals.add(animal);
    }
}
