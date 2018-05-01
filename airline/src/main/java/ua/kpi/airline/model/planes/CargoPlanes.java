package ua.kpi.airline.model.planes;

public enum CargoPlanes implements PlaneEnum {
    BOEING_747("Boeing 747", 5, 150000, 110000, 800, 8000),
    DC_8("DC-8", 5, 45000, 50000, 750, 8950);

    private final String name;
    private final int maxSeatCapacity;
    private final int maxFuelCapacity;
    private final int maxCargoCapacity;
    private final int maxSpeed;
    private final int maxRangeFullLoad;

    CargoPlanes(String name, int maxSeatCapacity, int maxFuelCapacity, int maxCargoCapacity,
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
