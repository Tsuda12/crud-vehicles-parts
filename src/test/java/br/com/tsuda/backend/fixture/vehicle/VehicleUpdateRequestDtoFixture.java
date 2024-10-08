package br.com.tsuda.backend.fixture.vehicle;

import br.com.tsuda.backend.controller.dto.request.VehicleUpdateRequestDto;

public class VehicleUpdateRequestDtoFixture {

    public static VehicleUpdateRequestDto vehicleEntityUpdated() {
        VehicleUpdateRequestDto request = new VehicleUpdateRequestDto(
                "Chevrolet",
                "Meriva",
                "2007"
        );

        return request;
    }
}
