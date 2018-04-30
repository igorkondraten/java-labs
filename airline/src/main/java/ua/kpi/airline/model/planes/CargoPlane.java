package ua.kpi.airline.model.planes;

public class CargoPlane extends Plane {
    public CargoPlane(String name, int maxSeatCapacity, int maxFuelCapacity, int maxCargoCapacity,
                      int maxSpeed, int maxRangeFullLoad){
        super(name, maxSeatCapacity, maxFuelCapacity,maxCargoCapacity, maxSpeed, maxRangeFullLoad);
    }

    @Override
    public void startFlight(String airPortName) {

    }
}
