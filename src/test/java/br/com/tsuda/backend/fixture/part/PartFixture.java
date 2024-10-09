package br.com.tsuda.backend.fixture.part;

import br.com.tsuda.backend.controller.dto.request.PartRequestDto;
import br.com.tsuda.backend.controller.dto.request.PartUpdateRequestDto;
import br.com.tsuda.backend.domain.entity.Part;
import br.com.tsuda.backend.domain.entity.Vehicle;
import br.com.tsuda.backend.fixture.vehicle.VehicleFixture;

import java.util.List;

public class PartFixture {

    public static Part partEntity(PartRequestDto request, Vehicle vehicle1, Vehicle vehicle2) {
        Part part = new Part();

        part.setPartNumber(request.partNumber());
        part.setBrand(request.brand());
        part.setModel(request.model());
        part.setVehicles(List.of(vehicle1, vehicle2));

        return part;
    }

    public static Part partEntityFreio() {
        Part part = new Part();

        part.setPartNumber("P1");
        part.setBrand("Bosch");
        part.setModel("Freio ABS");
        part.setVehicles(List.of(VehicleFixture.vehicleEntityCorsa()));

        return part;
    }

    public static Part partEntityVela() {
        Part part = new Part();

        part.setPartNumber("P2");
        part.setBrand("Bosch");
        part.setModel("Vela");
        part.setVehicles(List.of(VehicleFixture.vehicleEntityVectra()));

        return part;
    }

    public static Part partEntityUpdated(PartUpdateRequestDto request, Vehicle vehicle) {
        Part part = new Part();

        part.setPartNumber(request.partNumber());
        part.setBrand(request.brand());
        part.setModel(request.model());
        part.setVehicles(List.of(vehicle));

        return part;
    }
}
