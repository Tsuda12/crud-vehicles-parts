package br.com.tsuda.backend.domain.converter;

import br.com.tsuda.backend.controller.dto.request.VehicleRequestDto;
import br.com.tsuda.backend.controller.dto.request.VehicleUpdateRequestDto;
import br.com.tsuda.backend.controller.dto.response.VehicleResponseDto;
import br.com.tsuda.backend.domain.entity.Vehicle;

public class VehicleConverter {

    public static Vehicle toVehicleEntity(VehicleRequestDto request) {
        Vehicle vehicle = new Vehicle();

        vehicle.setBrand(request.brand());
        vehicle.setModel(request.model());
        vehicle.setYearOfManufacture(request.yearOfManufacture());

        return vehicle;
    }

    public static VehicleResponseDto toVehicleResponseDto(Vehicle entity) {
        return new VehicleResponseDto(
                entity.getId(),
                entity.getBrand(),
                entity.getModel(),
                entity.getYearOfManufacture()
        );
    }

    public static Vehicle toUpdatedVehicle(Vehicle entity, VehicleUpdateRequestDto request) {
        if(request.brand().isBlank()) {
            entity.setBrand(entity.getBrand());
        } else {
            entity.setBrand(request.brand());
        }

        if(request.model().isBlank()) {
            entity.setModel(entity.getModel());
        } else {
            entity.setModel(request.model());
        }

        if(request.yearOfManufacture().isBlank()) {
            entity.setYearOfManufacture(entity.getYearOfManufacture());
        } else {
            entity.setYearOfManufacture(request.yearOfManufacture());
        }

        return entity;
    }
}
