package ru.bikmeev.model;

public interface CarBuilder {
    CarBuilder model();
    CarBuilder year();
    CarBuilder color();
    Car build();
}
