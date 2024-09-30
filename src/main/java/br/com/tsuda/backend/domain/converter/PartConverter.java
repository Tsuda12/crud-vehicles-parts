package br.com.tsuda.backend.domain.converter;

import br.com.tsuda.backend.controller.dto.request.PartRequestDto;
import br.com.tsuda.backend.controller.dto.response.PartResponseDto;
import br.com.tsuda.backend.domain.entity.Part;
import br.com.tsuda.backend.domain.entity.Vehicle;

import java.util.List;

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
}
