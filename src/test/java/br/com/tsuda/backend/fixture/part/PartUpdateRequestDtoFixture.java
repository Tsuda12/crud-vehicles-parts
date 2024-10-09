package br.com.tsuda.backend.fixture.part;

import br.com.tsuda.backend.controller.dto.request.PartUpdateRequestDto;

import java.util.List;

public class PartUpdateRequestDtoFixture {

    public static PartUpdateRequestDto updateRequest() {
        PartUpdateRequestDto request = new PartUpdateRequestDto(
                "P1",
                "Bosch",
                "Filtro de ar",
                List.of(1)
        );

        return request;
    }
}
