package p04_mordorsPlan;

public class Gandalf {
    private int happiness;

    public int getHappiness() {
        return this.happiness;
    }

    public void eatFood(String food) {
        switch (food) {
            case "cram":
                this.happiness += 2;
                break;
            case "lembas":
                this.happiness += 3;
                break;
            case "apple":
                this.happiness += 1;
                break;
            case "melon":
                this.happiness += 1;
                break;
            case "honeycake":
                this.happiness += 5;
                break;
            case "mushrooms":
                this.happiness -= 10;
                break;
            default:
                this.happiness -= 1;
                break;
        }
    }

    public void getMood() {
        if (this.happiness < -5) {
            System.out.println("Angry");
        } else if (this.happiness >= -5 && this.happiness < 0) {
            System.out.println("Sad");
        } else if (this.happiness >= 0 && this.happiness <= 15) {
            System.out.println("Happy");
        } else {
            System.out.println("JavaScript");
        }
    }
}
