package app.animals;

public abstract class Animal implements Comparable<Animal> {
    private String name;
    private int age;
    private boolean isCleansed;
    private boolean isCastrated;
    private String adoptionCenter;

    protected Animal(String name, int age) {
        this(name, age, null);
    }

    protected Animal(String name, int age, String center) {
        this.setName(name);
        this.setAge(age);
        this.setAdoptionCenter(center);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public boolean isCleansed() {
        return this.isCleansed;
    }

    public boolean isCastrated() {
        return this.isCastrated;
    }

    public String getAdoptionCenter() {
        return this.adoptionCenter;
    }

    private void setAdoptionCenter(String adoptionCenter) {
        this.adoptionCenter = adoptionCenter;
    }

    public void setCleansed(boolean cleansed) {
        isCleansed = cleansed;
    }

    public void setCastrated(boolean castrated) {
        isCastrated = castrated;
    }

    public void cleanse() {
        this.isCleansed = true;
    }

    public void castrate() {
        this.isCastrated = true;
    }

    @Override
    public int compareTo(Animal other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
