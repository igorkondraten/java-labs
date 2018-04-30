package ua.kpi.airline.model.airline;

import ua.kpi.airline.model.planes.Plane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AirLine {
    private String companyName;
    private List<Plane> planes = new ArrayList<>();

    public AirLine(String companyName){
        this.companyName = companyName;
    }

    public AirLine(String companyName, List<Plane> planes){
        this.companyName = companyName;
        this.planes = planes;
    }

    public void addPlane(Plane plane){
        this.planes.add(plane);
    }

    public void deletePlane(Plane plane){
        if (this.planes != null && this.planes.indexOf(plane) != -1) this.planes.remove(plane);
        else throw new RuntimeException("Plane not found");
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Plane> getPlanes() {
        return planes;
    }
}
