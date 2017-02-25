package p06_footballTeamGenerator;

public class Player {
    private String name;
    private double status;

    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;

    public Player(String name, double endurance, double sprint, double dribble, double passing, double shooting) throws Exception {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);

        this.setStatus();
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

    public double getStatus() {
        return status;
    }

    private void setStatus() {
        double total = 0.0;
        total += this.getEndurance();
        total += this.getSprint();
        total += this.getDribble();
        total += this.getPassing();
        total += this.getShooting();

        this.status = total / 5.0;
    }

    private double getEndurance() {
        return endurance;
    }

    private void setEndurance(double endurance) throws Exception {
        if (!isValid(endurance)) {
            throw new Exception("Endurance should be between 0 and 100.");
        }

        this.endurance = endurance;
    }

    private double getSprint() {
        return sprint;
    }

    private void setSprint(double sprint) throws Exception {
        if (!isValid(sprint)) {
            throw new Exception("Sprint should be between 0 and 100.");
        }

        this.sprint = sprint;
    }

    private double getDribble() {
        return dribble;
    }

    private void setDribble(double dribble) throws Exception {
        if (!isValid(dribble)) {
            throw new Exception("Dribble should be between 0 and 100.");
        }

        this.dribble = dribble;
    }

    private double getPassing() {
        return passing;
    }

    private void setPassing(double passing) throws Exception {
        if (!isValid(passing)) {
            throw new Exception("Passing should be between 0 and 100.");
        }

        this.passing = passing;
    }

    private double getShooting() {
        return shooting;
    }

    private void setShooting(double shooting) throws Exception {
        if (!isValid(shooting)) {
            throw new Exception("Shooting should be between 0 and 100.");
        }

        this.shooting = shooting;
    }

    private boolean isValid(double characteristic) {
        if (characteristic < 0 || characteristic > 100) {
            return false;
        }

        return true;
    }
}
