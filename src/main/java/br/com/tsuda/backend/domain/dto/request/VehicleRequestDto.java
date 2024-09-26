package br.com.tsuda.backend.domain.dto.request;

public record VehicleRequestDto(
        String brand,
        String model,
        String yearOfManufacture
) {
}
