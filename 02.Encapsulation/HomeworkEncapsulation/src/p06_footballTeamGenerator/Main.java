package p06_footballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Team> teamsByName = new HashMap<>();

        String command = in.nextLine();
        while (!"END".equals(command)) {
            String[] commandArgs = command.split(";");
            String commandType = commandArgs[0];

            try {
                switch (commandType) {
                    case "Team": {
                        String teamName = commandArgs[1];
                        Team team = new Team(teamName);

                        teamsByName.put(teamName, team);
                        break;
                    }
                    case "Add": {
                        String teamName = commandArgs[1];
                        String playerName = commandArgs[2];

                        if (!teamsByName.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            int endurance = Integer.parseInt(commandArgs[3]);
                            int sprint = Integer.parseInt(commandArgs[4]);
                            int dribble = Integer.parseInt(commandArgs[5]);
                            int passing = Integer.parseInt(commandArgs[6]);
                            int shooting = Integer.parseInt(commandArgs[7]);

                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);

                            Team team = teamsByName.get(teamName);
                            team.addPlayer(player);
                        }
                        break;
                    }
                    case "Remove": {
                        String teamName = commandArgs[1];
                        String playerName = commandArgs[2];

                        if (!teamsByName.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            Team team = teamsByName.get(teamName);

                            team.removePlayer(playerName);
                        }
                        break;
                    }
                    case "Rating": {
                        String teamName = commandArgs[1];

                        if (!teamsByName.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            Team team = teamsByName.get(teamName);

                            System.out.printf("%s - %d%n", team.getName(), team.getRating());
                        }
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            command = in.nextLine();
        }
    }
}
