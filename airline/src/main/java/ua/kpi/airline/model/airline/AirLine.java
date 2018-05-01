package ua.kpi.airline.model.airline;

import ua.kpi.airline.model.planes.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airline {
    private String companyName;
    private List<Plane> planes = new ArrayList<>();

    public Airline(String companyName){
        this.companyName = companyName;
    }

    public Airline(String companyName, List<Plane> planes){
        this.companyName = companyName;
        if (planes != null){
            this.planes = planes;
        } else {
            planes = new ArrayList<>();
        }
    }
    /*
        Добавить самолет в авиакомпанию
     */
    public void addPlane(Plane plane){
        this.planes.add(plane);
    }

    /*
        Удалить самолет из авиакомпании
     */
    public void deletePlane(Plane plane){
        if (this.planes != null){
            if (this.planes.indexOf(plane) != -1) this.planes.remove(plane);
            else throw new NoSuchElementException("Plane not found");
        } else throw new NullPointerException("Planes is null");
    }

    /*
        Отсортировать самолеты по возрастанию дальности полета
     */
    public void sortPlanesByRangeAsc(){
        if (planes != null){
            planes.sort(Comparator.comparing(Plane::getMaxRangeFullLoad));
        } else throw new NullPointerException("Planes is null");
    }
    /*
        Отсортировать самолеты по убыванию дальности полета
     */
    public void sortPlanesByRangeDesc(){
        if (planes != null){
            planes.sort(Comparator.comparing(Plane::getMaxRangeFullLoad).reversed());
        } else throw new NullPointerException("Planes is null");
    }
    /*
        Найти самолеты в заданом диапазоне потребления топлива
     */
    public List<Plane> findPlanesByFuelConsumption(int minValue, int maxValue){
        if (minValue <= maxValue){
            return planes.stream().filter(p -> p.getFuelConsumption() >= minValue && (p.getFuelConsumption()) <= maxValue).collect(Collectors.toList());
        }
        else throw new IllegalArgumentException("Неверный диапазон значений");
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    /*
        Получить общую грузоподьемность самолетов
     */
    public int getFullCargoWeight(){
        int count = 0;
        for(Plane p:planes){
            count += p.getMaxCargoCapacity();
        }
        return count;
    }

    /*
        Получить общее количество мест
     */
    public int getFullSeatsCount(){
        int count = 0;
        for(Plane p:planes){
            count += p.getMaxSeatCapacity();
        }
        return count;
    }
}
