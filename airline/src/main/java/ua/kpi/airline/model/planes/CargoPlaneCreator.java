package ua.kpi.airline.model.planes;

public class CargoPlaneCreator implements PlaneCreator {
    public Plane createPlane(String name, int maxSeatCapacity, int maxFuelCapacity, int maxCargoCapacity,
                             int maxSpeed, int maxRangeFullLoad) {
        return new CargoPlane(name, maxSeatCapacity, maxFuelCapacity,maxCargoCapacity, maxSpeed, maxRangeFullLoad);
    }
}
