package br.com.tsuda.backend.domain.converter;

import br.com.tsuda.backend.domain.dto.request.VehicleRequestDto;
import br.com.tsuda.backend.domain.dto.response.VehicleResponseDto;
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

    public static Vehicle toUpdatedVehicle(Vehicle entity, VehicleRequestDto request) {
        entity.setBrand(request.brand());
        entity.setModel(request.model());
        entity.setYearOfManufacture(request.yearOfManufacture());

        return entity;
    }
}
