package ua.kpi.airline.model.planes;

public interface PlaneCreator {
    Plane createPlane(String name, int maxSeatCapacity, int maxFuelCapacity, int maxCargoCapacity,
                      int maxSpeed, int maxRangeFullLoad);
    Plane createPlane(PlaneEnum plane);
}
