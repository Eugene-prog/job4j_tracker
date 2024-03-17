package ru.job4j.stream;

import java.time.LocalDate;

public class Car {
    private String brand;

    private String model;

    private LocalDate created;

    private double volume;

    private String color;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car{Brand: ").append(brand)
                .append(", Model: ").append(model)
                .append(", Created: ").append(created)
                .append(", Volume: ").append(volume)
                .append(", Color: ").append(color)
                .append("}");
        return sb.toString();
    }

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.created = created;
            car.volume = volume;
            car.color = color;
            return car;
        }
    }

    public static void main(String[] args) {
        Car carRed = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildCreated(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(carRed.toString());
        Car carBlue = new Builder()
                .buildBrand("Toyota")
                .buildModel("Prius")
                .buildCreated(LocalDate.of(2017, 8, 1))
                .buildVolume(1.4)
                .buildColor("Blue")
                .build();
        System.out.println(carBlue.toString());
    }
}