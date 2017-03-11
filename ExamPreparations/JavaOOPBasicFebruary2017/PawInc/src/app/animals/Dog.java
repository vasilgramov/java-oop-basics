package app.animals;

public class Dog extends Animal {
    private int learnedCommands;

    public Dog(String name, int age, int learnedCommands, String center) {
        super(name, age, center);
        this.setLearnedCommands(learnedCommands);
    }

    public int getLearnedCommands() {
        return this.learnedCommands;
    }

    private void setLearnedCommands(int learnedCommands) {
        this.learnedCommands = learnedCommands;
    }
}
