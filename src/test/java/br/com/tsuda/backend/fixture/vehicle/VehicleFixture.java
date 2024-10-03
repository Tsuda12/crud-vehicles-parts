package br.com.tsuda.backend.fixture.vehicle;

import br.com.tsuda.backend.domain.entity.Vehicle;

public class VehicleFixture {

    public static Vehicle vehicleEntity(String brand, String model, String yearOfManufacture) {
        Vehicle vehicle = new Vehicle();

        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setYearOfManufacture(yearOfManufacture);

        return vehicle;
    }
}
