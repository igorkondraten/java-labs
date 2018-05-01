package ua.kpi.airline;

import ua.kpi.airline.model.airline.Airline;
import ua.kpi.airline.model.planes.PassengerPlaneCreator;
import ua.kpi.airline.model.planes.Plane;
import ua.kpi.airline.model.planes.PlaneCreator;
import ua.kpi.airline.view.View;

public class App 
{
    public static void main( String[] args )
    {
        PlaneCreator creator = new PassengerPlaneCreator();
        Plane plane = creator.createPlane("Plane1", 5, 170000, 200, 300, 2000);
        Plane plane1 = creator.createPlane("Plane2", 5, 150000, 200, 300, 2300);
        Plane plane2 = creator.createPlane("Plane3", 5, 100000, 200, 300, 1500);
        Airline airline = new Airline("Українська авіакомпанія");
        airline.addPlane(plane);
        airline.addPlane(plane1);
        airline.addPlane(plane2);
        airline.sortPlanesByRangeDesc();
        System.out.println(airline.getCompanyName());
        View view = new View();
        airline.getPlanes().forEach(p -> view.printPlane(p));
        view.printMessage(Integer.toString(airline.getFullCargoWeight()));
    }
}
