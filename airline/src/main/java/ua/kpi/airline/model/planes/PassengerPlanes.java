package ua.kpi.airline.model.planes;

public enum PassengerPlanes implements PlaneEnum {
    AIRBUS_320("Airbus 320neo", 180, 23760, 16600, 890, 6850),
    BOEING_777_9("Boeing 777-9", 414, 198000, 30000, 950, 14000);

    private final String name;
    private final int maxSeatCapacity;
    private final int maxFuelCapacity;
    private final int maxCargoCapacity;
    private final int maxSpeed;
    private final int maxRangeFullLoad;

    PassengerPlanes(String name, int maxSeatCapacity, int maxFuelCapacity, int maxCargoCapacity,
                  int maxSpeed, int maxRangeFullLoad){
        this.name = name;
        this.maxSeatCapacity = maxSeatCapacity;
        this.maxFuelCapacity = maxFuelCapacity;
        this.maxCargoCapacity = maxCargoCapacity;
        this.maxSpeed = maxSpeed;
        this.maxRangeFullLoad = maxRangeFullLoad;
    }

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
}
