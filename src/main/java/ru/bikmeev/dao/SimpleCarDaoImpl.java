package ru.bikmeev.dao;

import org.springframework.stereotype.Component;
import ru.bikmeev.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleCarDaoImpl implements CarDao {

    private final List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> allCars() {
        return this.cars;
    }

    @Override
    public void addCar(Car car) {
        this.cars.add(car);
    }
}
