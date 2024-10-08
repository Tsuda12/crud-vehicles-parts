package br.com.tsuda.backend.fixture.vehicle;

import br.com.tsuda.backend.controller.dto.request.VehicleUpdateRequestDto;
import br.com.tsuda.backend.domain.entity.Vehicle;

public class VehicleFixture {

    public static Vehicle vehicleEntity(String brand, String model, String yearOfManufacture) {
        Vehicle vehicle = new Vehicle();

        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setYearOfManufacture(yearOfManufacture);

        return vehicle;
    }

    public static Vehicle vehicleEntityCorsa() {
        Vehicle vehicle = new Vehicle();

        vehicle.setBrand("Chevrolet");
        vehicle.setModel("Corsa");
        vehicle.setYearOfManufacture("2010");

        return vehicle;
    }

    public static Vehicle vehicleEntityVectra() {
        Vehicle vehicle = new Vehicle();

        vehicle.setBrand("Chevrolet");
        vehicle.setModel("Vectra");
        vehicle.setYearOfManufacture("2010");

        return vehicle;
    }

    public static Vehicle vehicleEntityUpdated(VehicleUpdateRequestDto request) {
        Vehicle vehicle = new Vehicle();

        vehicle.setBrand(request.brand());
        vehicle.setModel(request.model());
        vehicle.setYearOfManufacture(request.yearOfManufacture());

        return vehicle;
    }
}
