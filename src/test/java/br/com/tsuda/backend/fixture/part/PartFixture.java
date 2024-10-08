package br.com.tsuda.backend.fixture.part;

import br.com.tsuda.backend.controller.dto.request.PartRequestDto;
import br.com.tsuda.backend.domain.entity.Part;
import br.com.tsuda.backend.domain.entity.Vehicle;

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
}
