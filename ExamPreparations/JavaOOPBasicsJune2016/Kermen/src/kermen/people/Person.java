package kermen.people;

public abstract class Person {
    private double income;

    public Person(double income) {
        this.setIncome(income);
    }

    private void setIncome(double income) {
        this.income = income;
    }

    public double getIncome() {
        return this.income;
    }
}
