package br.com.tsuda.backend.fixture.part;

import br.com.tsuda.backend.controller.dto.request.PartRequestDto;

import java.util.List;

public class PartRequestDtoFixture {

    public static PartRequestDto partRequest() {
        PartRequestDto partRequestDto = new PartRequestDto(
                "P1",
                "Bosch",
                "Freio ABS",
                List.of(1, 2)
        );

        return partRequestDto;
    }
}
