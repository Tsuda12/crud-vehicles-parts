package br.com.tsuda.backend.domain.dto.response;

public record VehicleResponseDto(
        int id,
        String brand,
        String model,
        String yearOfManufacture
) {
}
