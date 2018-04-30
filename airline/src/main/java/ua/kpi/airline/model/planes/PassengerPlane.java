package ua.kpi.airline.model.planes;

public class PassengerPlane extends Plane {
    public PassengerPlane(String name, int maxSeatCapacity, int maxFuelCapacity, int maxCargoCapacity,
                      int maxSpeed, int maxRangeFullLoad){
        super(name, maxSeatCapacity, maxFuelCapacity,maxCargoCapacity, maxSpeed, maxRangeFullLoad);
    }

    @Override
    public void startFlight(String airPortName) {

    }
}
