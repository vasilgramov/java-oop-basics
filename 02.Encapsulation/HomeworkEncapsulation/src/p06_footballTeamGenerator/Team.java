package p06_footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) throws Exception {
        this.setName(name);
        this.setPlayers(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    private void setName(String name) throws Exception {
        if (name == null || name.trim().length() == 0) {
            throw new Exception("A name should not be empty.");
        }

        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    private void setPlayers(List<Player> players) {
        this.players = players;
    }

    public long getRating() {
        double total = 0.0;
        for (Player player : players) {
            total += Math.round(player.getStatus());
        }

        if (total == 0) {
            return 0L;
        } else {
            return Math.round(total / players.size());
        }
    }

    public void addPlayer(Player player) {
        this.getPlayers().add(player);
    }

    public void removePlayer(String playerName) throws Exception {
        Player playerToBeRemoved = null;
        for (Player player : this.getPlayers()) {
            if (player.getName().equals(playerName)) {
                playerToBeRemoved = player;
                break;
            }
        }

        if (playerToBeRemoved == null) {
            throw new Exception(String.format("Player %s is not in %s team.", playerName, this.getName()));
        }

        this.getPlayers().remove(playerToBeRemoved);
    }
}
