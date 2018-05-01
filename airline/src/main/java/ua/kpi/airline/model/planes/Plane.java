package ua.kpi.airline.model.planes;

public abstract class Plane {
    private String name;
    private final int maxSeatCapacity;
    private final int maxFuelCapacity; // Max. fuel capacity in kg
    private final int maxCargoCapacity; // Max. cargo capacity in kg
    private final int maxSpeed;  // Max. speed in km per hour
    private final int maxRangeFullLoad; // Max. range in km

    protected Plane(String name, int maxSeatCapacity, int maxFuelCapacity, int maxCargoCapacity,
                    int maxSpeed, int maxRangeFullLoad){
        this.name = name;
        this.maxSeatCapacity = maxSeatCapacity;
        this.maxFuelCapacity = maxFuelCapacity;
        this.maxCargoCapacity = maxCargoCapacity;
        this.maxSpeed = maxSpeed;
        this.maxRangeFullLoad = maxRangeFullLoad;
    }

    public abstract void startFlight(String airPortName);

    public String getName() {
        return name;
    }

    public int getMaxSeatCapacity() {
        return maxSeatCapacity;
    }

    public int getMaxFuelCapacity() {
        return maxFuelCapacity;
    }

    public int getMaxCargoCapacity() {
        return maxCargoCapacity;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxRangeFullLoad() {
        return maxRangeFullLoad;
    }

    public double getFuelConsumption(){
        return (double)maxFuelCapacity / (double)maxRangeFullLoad;
    }
}
