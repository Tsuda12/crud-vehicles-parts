package br.com.tsuda.backend.controller.dto.response;

public record VehicleResponseDto(
        int id,
        String brand,
        String model,
        String yearOfManufacture
) {
}
