package ua.kpi.airline.view;

import ua.kpi.airline.model.airline.Airline;
import ua.kpi.airline.model.planes.Plane;

public class View {
    public final String PLANE_NAME = "Название самолета:";
    public final String MAX_WEIGHT = "Грузоподьемность (кг):";
    public final String MAX_FUEL = "Топливный бак (кг):";
    public final String MAX_LENGTH = "Дальность полета (км):";
    public final String MAX_SEATS = "Посадочных мест:";
    public final String MAX_SPEED = "Максимальная скорость (км/ч):";
    public final String FUEL_CONSUMPTION = "Потребление топлива (кг/км):";

    public void printMessage(String s){
        System.out.println(s);
    }
    public void printPlane(Plane p){
        String s = p.getClass().getSimpleName() + " [" + p.getName() +
                ", " + MAX_WEIGHT + p.getMaxCargoCapacity()+
                ", " + MAX_FUEL + p.getMaxFuelCapacity()+
                ", " + MAX_LENGTH + p.getMaxRangeFullLoad() +
                ", " + MAX_SEATS + p.getMaxSeatCapacity() +
                ", " + MAX_SPEED + p.getMaxSpeed() +
                ", " + FUEL_CONSUMPTION + String.format("%(.2f", p.getFuelConsumption()) + "]";
        System.out.println(s);
    }

    public void printCompanyInfo(Airline company){
        System.out.println("Авиакомпания: " + company.getCompanyName() + ", самолетов: " + company.getPlanes().size());
    }

    public void printMenu(){
        System.out.println("\nСписок самолетов - 1");
        System.out.println("Добавить самолет - 2");
        System.out.println("Сортировать самолеты по дальности полета - 3");
        System.out.println("Найти самолеты по потреблению горючего - 4");
        System.out.println("Посчитать общую вместимость и грузоподьемность - 5");
        System.out.println("Выход - 0");
    }

    public void printPlanesList(Airline company){
        System.out.println("Список самолетов компании " + company.getCompanyName() + ":");
        company.getPlanes().forEach(p -> printPlane(p));
    }

    public void printCargoSeatsSum(int cargoSum, int seatsSum){
        System.out.println("Общая грузоподьемность: " + cargoSum + " кг");
        System.out.println("Общее количество мест: " + seatsSum);
    }

    public void chooseSort(){
        System.out.println("Тип сортировки: 1 - По возрастанию, 2 - По убыванию");
    }

    public void choosePlaneType(){
        System.out.println("Выберите тип самолета: 1 - Пассажирский, 2 - Грузовой");
    }
}
