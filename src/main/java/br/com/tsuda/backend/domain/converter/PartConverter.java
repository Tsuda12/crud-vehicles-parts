package br.com.tsuda.backend.domain.converter;

import br.com.tsuda.backend.controller.dto.request.PartRequestDto;
import br.com.tsuda.backend.controller.dto.request.PartUpdateRequestDto;
import br.com.tsuda.backend.controller.dto.response.PartResponseDto;
import br.com.tsuda.backend.domain.entity.Part;
import br.com.tsuda.backend.domain.entity.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public class PartConverter {

    public static Part toPartEntity(PartRequestDto request, List<Vehicle> vehicles) {
        Part part = new Part();

        part.setPartNumber(request.partNumber());
        part.setBrand(request.brand());
        part.setModel(request.model());
        part.setVehicles(vehicles);

        return part;
    }

    public static PartResponseDto toPartResponseDto(Part entity) {
        return new PartResponseDto(
                entity.getId(),
                entity.getPartNumber(),
                entity.getBrand(),
                entity.getModel(),
                entity.getVehicles().stream().map(VehicleConverter::toVehicleResponseDto).toList()
        );
    }

    public static Part toUpdatedPart(Part entity, PartUpdateRequestDto request, List<Vehicle> vehicles) {
        if(request.partNumber().isBlank()) {
            entity.setPartNumber(entity.getPartNumber());
        } else {
            entity.setPartNumber(request.partNumber());
        }

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

        if(request.vehiclesIds().isEmpty()) {
            entity.setVehicles(entity.getVehicles());
        } else {
            entity.setVehicles(vehicles);
        }

         return entity;
    }
}
