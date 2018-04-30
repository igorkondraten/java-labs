package ua.kpi.airline.model.airline;

import ua.kpi.airline.model.planes.Plane;

import java.util.*;
import java.util.stream.Collectors;

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

    public void sortPlanesByRangeAsc(){
        if (planes != null){
            planes.sort(Comparator.comparing(Plane::getMaxRangeFullLoad));
        } else throw new NullPointerException("Planes is null");
    }

    public void sortPlanesByRangeDesc(){
        if (planes != null){
            planes.sort(Comparator.comparing(Plane::getMaxRangeFullLoad).reversed());
        } else throw new NullPointerException("Planes is null");
    }

    public List<Plane> findPlaneByFuelConsumption(int minValue, int maxValue){
        if (minValue <= maxValue){
            return planes.stream().filter(p -> p.getFuelConsumption() >= minValue && (p.getFuelConsumption()) <= maxValue).collect(Collectors.toList());
        }
        else throw new RuntimeException("Неверный диапазон значений");
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Plane> getPlanes() {
        return planes;
    }
}
