package ru.bikmeev.model;

import java.util.List;
import java.util.Random;

public class BusinessCarBuilder implements CarBuilder {

    private final static List<String> models = List.of(
            "Kia K5", "Mercedes-Benz E", "BMW", "Toyota Camry"
    );
    private final static Random random = new Random();

    private String model;
    private int year;
    private String color;


    @Override
    public CarBuilder model() {
        this.model = models.get(random.nextInt(models.size()));
        return this;
    }

    @Override
    public CarBuilder year() {
        this.year = random.nextInt(2023 - 2019) + 2019;
        return this;
    }

    @Override
    public CarBuilder color() {
        this.color = "Black";
        return this;
    }

    @Override
    public Car build() {
        return new Car(model, year, color);
    }
}
