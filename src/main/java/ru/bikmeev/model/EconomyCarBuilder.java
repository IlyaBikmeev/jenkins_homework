package ru.bikmeev.model;

import java.util.List;
import java.util.Random;

public class EconomyCarBuilder implements CarBuilder {
    private final static List<String> models = List.of(
            "Renault Logan", "Hyundai Solaris", "Lada Granta"
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
        this.year = random.nextInt(2021 - 2011) + 2011;
        return this;
    }

    @Override
    public CarBuilder color() {
        this.color = "Yellow";
        return this;
    }

    @Override
    public Car build() {
        return new Car(model, year, color);
    }
}
