package p06_rawData;

public class Engine {
    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed, int enginePower) {
        this.setEngineSpeed(engineSpeed);
        this.setEnginePower(enginePower);
    }

    public int getEngineSpeed() {
        return this.engineSpeed;
    }

    private void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return this.enginePower;
    }

    private void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }
}
