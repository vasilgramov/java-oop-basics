package p08_pokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.setName(name);
        this.setElement(element);
        this.setHealth(health);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return this.element;
    }

    private void setElement(String element) {
        this.element = element;
    }

    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    public void attackPokemon() {
        this.setHealth(this.getHealth() - 10);
    }
}
