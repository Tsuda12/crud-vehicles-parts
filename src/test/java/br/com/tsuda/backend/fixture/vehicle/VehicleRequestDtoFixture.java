package br.com.tsuda.backend.fixture.vehicle;

import br.com.tsuda.backend.controller.dto.request.VehicleRequestDto;

public class VehicleRequestDtoFixture {

    public static VehicleRequestDto vehicleRequest() {
        VehicleRequestDto request = new VehicleRequestDto(
                "Chevrolet",
                "Corsa",
                "2010"
        );

        return request;
    }
}
