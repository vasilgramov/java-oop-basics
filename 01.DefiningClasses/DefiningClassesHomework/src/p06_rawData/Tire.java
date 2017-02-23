package p06_rawData;

public class Tire {
    private double pressure;
    private int age;

    public Tire(double pressure, int age) {
        this.setPressure(pressure);
        this.setAge(age);
    }

    public double getPressure() {
        return this.pressure;
    }

    private void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }
}
