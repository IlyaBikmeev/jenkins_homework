package ru.bikmeev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bikmeev.dao.CarDao;
import ru.bikmeev.model.BusinessCarBuilder;
import ru.bikmeev.model.Car;
import ru.bikmeev.model.CarType;
import ru.bikmeev.model.EconomyCarBuilder;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarDao carDao;

    @GetMapping("/new")
    public String newCarForm() {
        return "car/new";
    }

    @GetMapping("/all")
    public String allCars(Model model) {
        model.addAttribute("cars", carDao.allCars());
        return "car/all_cars";
    }

    @PostMapping
    public String newCar(@RequestParam String carType) {
        CarType type = CarType.valueOf(carType);
        if(type.equals(CarType.ECONOMY)) {
            carDao.addCar(
                    new EconomyCarBuilder()
                            .model()
                            .year()
                            .color()
                            .build()
            );
        }
        else if(type.equals(CarType.BUSINESS)) {
            carDao.addCar(
                    new BusinessCarBuilder()
                            .model()
                            .year()
                            .color()
                            .build()
            );
        }
        else {
            throw new IllegalArgumentException("No such type of car");
        }

        return "redirect:/car/all";
    }
}
