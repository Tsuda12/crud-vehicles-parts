package br.com.tsuda.backend.controller.dto.request;

public record VehicleUpdateRequestDto(
        String brand,
        String model,
        String yearOfManufacture
) {
}
