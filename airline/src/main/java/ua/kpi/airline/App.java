package ua.kpi.airline;

import ua.kpi.airline.controller.Controller;
import ua.kpi.airline.model.airline.Airline;
import ua.kpi.airline.model.planes.PassengerPlaneCreator;
import ua.kpi.airline.model.planes.Plane;
import ua.kpi.airline.model.planes.PlaneCreator;
import ua.kpi.airline.view.View;

public class App 
{
    public static void main( String[] args )
    {
        /*

        airline.sortPlanesByRangeDesc();
        System.out.println(airline.getCompanyName());


        view.printMessage(Integer.toString(airline.getFullCargoWeight()));
        */
        Airline airline = new Airline("American Airlines", null);
        View view = new View();

        PlaneCreator creator = new PassengerPlaneCreator();
        Plane plane = creator.createPlane("Plane1", 5, 170000, 200, 300, 2000);
        Plane plane1 = creator.createPlane("Plane2", 5, 150000, 200, 300, 2300);
        Plane plane2 = creator.createPlane("Plane3", 5, 100000, 200, 300, 1500);

        //airline.addPlane(plane);
        //airline.addPlane(plane1);
        //airline.addPlane(plane2);

        Controller controller = new Controller(view, airline);
        controller.init();
    }
}
