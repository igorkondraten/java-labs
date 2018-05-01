package ua.kpi.airline;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.kpi.airline.model.airline.Airline;
import ua.kpi.airline.model.planes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class AirlineTest {
    private Airline airline;
    private List<Plane> planesList = new ArrayList<>();

    @Before
    public void init() {
        PlaneCreator creator = new PassengerPlaneCreator();
        Plane plane = creator.createPlane("Plane1", 300, 170000, 100, 300, 2000);
        creator = new CargoPlaneCreator();
        Plane plane2 = creator.createPlane("Plane2", 5, 150000, 250, 500, 2200);
        Plane plane3 = creator.createPlane("Plane3", 5, 170000, 500, 400, 2001);
        ArrayList<Plane> planes = new ArrayList<>();
        planes.add(plane);
        planes.add(plane2);
        planes.add(plane3);
        airline = new Airline("a1", planes);
        planesList.add(plane);
        planesList.add(plane2);
        planesList.add(plane3);
    }

    @After
    public void end() {
        airline = null;
        planesList = null;
    }

    @Test
    public void addPlane() {
        PlaneCreator creator = new PassengerPlaneCreator();
        Plane plane = creator.createPlane("plane123", 5, 170000, 200, 300, 2000);
        planesList.add(plane);

        airline.addPlane(plane);

        assertIterableEquals(planesList, airline.getPlanes());
    }

    @Test
    public void deletePlane() {
        Plane plane = airline.getPlanes().get(0);
        planesList.remove(plane);

        airline.deletePlane(plane);

        assertIterableEquals(planesList, airline.getPlanes());
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteWrongPlane() {
        PlaneCreator creator = new PassengerPlaneCreator();
        Plane plane = creator.createPlane("Plane", 100, 100, 100, 100, 100);

        airline.deletePlane(plane);
    }

    @Test
    public void sortPlanesByRangeAsc() {
        Plane p3 = planesList.get(2);
        planesList.set(2, planesList.get(1));
        planesList.set(1, p3);

        airline.sortPlanesByRangeAsc();

        assertIterableEquals(planesList, airline.getPlanes());
    }

    @Test
    public void sortPlanesByRangeDesc() {
        Plane p2 = planesList.get(1);
        Plane p3 = planesList.get(2);
        planesList.set(2, planesList.get(0));
        planesList.set(0, p2);
        planesList.set(1, p3);

        airline.sortPlanesByRangeDesc();

        assertIterableEquals(planesList, airline.getPlanes());
    }

    @Test
    public void findPlaneByFuelConsumption() {
        double fuel = airline.getPlanes().get(0).getFuelConsumption();
        List<Plane> selectedPlanes = new ArrayList<>();
        selectedPlanes.add(airline.getPlanes().get(0));
        selectedPlanes.add(airline.getPlanes().get(2));

        assertIterableEquals(selectedPlanes, airline.findPlanesByFuelConsumption((int)fuel - 1, (int)fuel + 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findPlaneByFuelConsumptionWrongRange() {
        airline.findPlanesByFuelConsumption(10, 5);
    }

    @Test
    public void getFullCargoWeight() {
        assertEquals(850, airline.getFullCargoWeight());
    }

    @Test
    public void getFullSeatsCount() {
        assertEquals(310, airline.getFullSeatsCount());
    }
}