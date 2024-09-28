package br.com.tsuda.backend.domain.dto.request;

public record VehicleUpdateRequestDto(
        String brand,
        String model,
        String yearOfManufacture
) {
}
