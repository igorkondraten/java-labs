package ua.kpi.airline;

import ua.kpi.airline.controller.Controller;
import ua.kpi.airline.model.airline.Airline;
import ua.kpi.airline.model.planes.*;
import ua.kpi.airline.view.View;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        PlaneCreator creator = new PassengerPlaneCreator();
        List<Plane> planes = new ArrayList<>();
        planes.add(creator.createPlane(PassengerPlanes.BOEING_777_9));
        planes.add(creator.createPlane(PassengerPlanes.AIRBUS_320));
        creator = new CargoPlaneCreator();
        planes.add(creator.createPlane(CargoPlanes.DC_8));
        planes.add(creator.createPlane(CargoPlanes.BOEING_747));

        Airline airline = new Airline("American Airlines", planes);
        View view = new View();

        Controller controller = new Controller(view, airline);
        controller.init();
    }
}
