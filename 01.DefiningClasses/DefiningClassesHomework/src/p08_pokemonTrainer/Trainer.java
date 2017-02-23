package p08_pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.setNumberOfBadges(0);
        this.setPokemons(new ArrayList<>());

        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.getPokemons().add(pokemon);
    }

    public void increaseBadges() {
        this.setNumberOfBadges(this.getNumberOfBadges() + 1);
    }

    public void attackPokemons() {
        List<Pokemon> attackedPokemons = new ArrayList<>();
        for (Pokemon pokemon : this.getPokemons()) {
            pokemon.attackPokemon();

            if (pokemon.getHealth() > 0) {
                attackedPokemons.add(pokemon);
            }
        }

        this.setPokemons(attackedPokemons);
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getNumberOfBadges() + " " + this.getPokemons().size();
    }
}
