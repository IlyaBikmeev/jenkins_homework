package ru.bikmeev.dao;

import ru.bikmeev.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> allCars();
    void addCar(Car car);
}
