package br.com.tsuda.backend.controller.dto.request;

import java.util.List;

public record PartUpdateRequestDto (
        String partNumber,
        String brand,
        String model,
        List<Integer> vehiclesIds
) {}
