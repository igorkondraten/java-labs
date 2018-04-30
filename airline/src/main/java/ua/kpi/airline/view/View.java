package ua.kpi.airline.view;

import ua.kpi.airline.model.planes.Plane;

public class View {
    public void printMessage(String s){
        System.out.println(s);
    }
    public void printPlane(Plane p){
        String s = p.getClass().getSimpleName() + " [" + p.getName() +
                ", Грузоподьемность=" + p.getMaxCargoCapacity() +
                ", Топливный бак=" + p.getMaxFuelCapacity() +
                ", Дальность полета=" + p.getMaxRangeFullLoad() +
                ", Посадочных мест=" + p.getMaxSeatCapacity() +
                ", Максимальная скорость=" + p.getMaxSpeed() +
                ", Потребление топлива=" + p.getFuelConsumption() + "]";
        System.out.println(s);
    }
}
