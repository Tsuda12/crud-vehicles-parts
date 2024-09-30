package br.com.tsuda.backend.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record PartRequestDto(
        @NotBlank(message = "Part number is required!")
        String partNumber,
        @NotBlank(message = "Brand is required!")
        String brand,
        @NotBlank(message = "Model is required!")
        String model,
        @NotEmpty(message = "At least one vehicle id is required!")
        List<Integer> vehiclesIds
) {
}
