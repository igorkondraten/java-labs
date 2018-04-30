package ua.kpi.airline;

import ua.kpi.airline.model.airline.AirLine;
import ua.kpi.airline.model.planes.PassengerPlaneCreator;
import ua.kpi.airline.model.planes.Plane;
import ua.kpi.airline.model.planes.PlaneCreator;

public class App 
{
    public static void main( String[] args )
    {
        PlaneCreator creator = new PassengerPlaneCreator();
        Plane plane = creator.createPlane("Plane1", 5, 100, 200, 300, 400);
        AirLine airline = new AirLine("Ukraine Airlines");
        airline.addPlane(plane);
        System.out.println(airline.getPlanes().size());
    }
}
