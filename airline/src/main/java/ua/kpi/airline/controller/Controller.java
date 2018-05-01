package ua.kpi.airline.controller;

import ua.kpi.airline.model.airline.Airline;
import ua.kpi.airline.model.planes.CargoPlaneCreator;
import ua.kpi.airline.model.planes.PassengerPlaneCreator;
import ua.kpi.airline.model.planes.Plane;
import ua.kpi.airline.model.planes.PlaneCreator;
import ua.kpi.airline.view.View;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private View view;
    private Airline airline;

    public Controller(View view, Airline airline){
        this.view = view;
        this.airline = airline;
    }
    public void init(){
        view.printCompanyInfo(airline);
        view.printMenu();
        getAction();
    }

    public void getAction(){
        Scanner sc = new Scanner(System.in);
        int i = getInt();
        switch (i){
            case 0: {
                System.exit(0);
            }
            case 1: {
                showPlanes();
                break;
            }
            case 2: {
                addPlane();
                break;
            }
            case 3: {
                sortPlanes();
                break;
            }
            case 4: {
                findPlanes();
                break;
            }
            case 5: {
                view.printCargoSeatsSum(airline.getFullCargoWeight(), airline.getFullSeatsCount());
                break;
            }
        }
        view.printMenu();
        getAction();
    }

    public void showPlanes(){
        view.printPlanesList(airline);
    }

    public void addPlane(){
        boolean check = false;
        int i;
        do {
            view.choosePlaneType();
            i = getInt();
            if (i == 1){
                check = true;
            } else if (i == 2){
                check = true;
            }
        } while (!check);
        PlaneCreator creator = (i == 1) ? new PassengerPlaneCreator() : new CargoPlaneCreator();
        view.printMessage(view.PLANE_NAME);
        String name = getString();
        view.printMessage(view.MAX_SEATS);
        int seats = getInt();
        view.printMessage(view.MAX_FUEL);
        int fuel = getInt();
        view.printMessage(view.MAX_WEIGHT);
        int cargo = getInt();
        view.printMessage(view.MAX_SPEED);
        int speed = getInt();
        view.printMessage(view.MAX_LENGTH);
        int length = getInt();
        Plane plane = creator.createPlane(name, seats, fuel, cargo, speed, length);
        airline.addPlane(plane);
        view.printMessage("Самолет добавлен");
    }

    private int getInt(){
        Scanner sc = new Scanner(System.in);
        int i;
        try {
            i = sc.nextInt();
        }catch (InputMismatchException e){
            view.printMessage("Введите число!");
            return getInt();
        }
        return i;
    }

    private String getString(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.length() > 100) {
            view.printMessage("Длина превышает 100 символов!");
            return getString();
        }
        return s;
    }

    public void sortPlanes(){
        boolean check = false;
        int i;
        do {
            view.chooseSort();
            i = getInt();
            if (i == 1){
                check = true;
                try {
                    airline.sortPlanesByRangeAsc();
                } catch(NullPointerException e){
                    view.printMessage(e.getMessage());
                }
                showPlanes();
            } else if (i == 2){
                check = true;
                try {
                    airline.sortPlanesByRangeDesc();
                } catch(NullPointerException e){
                    view.printMessage(e.getMessage());
                }
                showPlanes();
            }
        } while (!check);
    }

    public void findPlanes(){
        view.printMessage("Введите минимальное значение расхода топлива (кг/км)");
        int minValue = getInt();
        view.printMessage("Введите максимальное значение расхода топлива (кг/км)");
        int maxValue = getInt();
        List<Plane> planes;
        try {
            planes = airline.findPlanesByFuelConsumption(minValue, maxValue);
        }
        catch (IllegalArgumentException e){
            view.printMessage(e.getMessage());
            return;
        }
        if (planes.size() == 0) {
            view.printMessage("Самолетов не найдено");
        } else {
            planes.forEach(p -> view.printPlane(p));
        }
    }
}
