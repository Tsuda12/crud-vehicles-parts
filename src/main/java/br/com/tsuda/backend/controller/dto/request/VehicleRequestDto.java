package br.com.tsuda.backend.controller.dto.request;

import jakarta.validation.constraints.NotBlank;

public record VehicleRequestDto(
        @NotBlank(message = "Brand is required")
        String brand,
        @NotBlank(message = "Model is required")
        String model,
        @NotBlank(message = "Year of manufacture is required")
        String yearOfManufacture
) {
}
