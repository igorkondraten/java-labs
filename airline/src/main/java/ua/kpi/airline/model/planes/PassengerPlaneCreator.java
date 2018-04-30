package ua.kpi.airline.model.planes;

public class PassengerPlaneCreator implements PlaneCreator {
    public Plane createPlane(String name, int maxSeatCapacity, int maxFuelCapacity, int maxCargoCapacity,
                             int maxSpeed, int maxRangeFullLoad) {
        return new PassengerPlane(name, maxSeatCapacity, maxFuelCapacity,maxCargoCapacity, maxSpeed, maxRangeFullLoad);
    }
}
