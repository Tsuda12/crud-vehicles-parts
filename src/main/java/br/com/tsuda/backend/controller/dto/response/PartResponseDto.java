package br.com.tsuda.backend.controller.dto.response;

import java.util.List;

public record PartResponseDto(
        int id,
        String partNumber,
        String brand,
        String model,
        List<VehicleResponseDto> vehicles
) {
}
