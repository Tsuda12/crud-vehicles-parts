package br.com.tsuda.backend.service;

import br.com.tsuda.backend.domain.dto.request.VehicleRequestDto;
import br.com.tsuda.backend.domain.dto.response.VehicleResponseDto;

import java.util.List;

public interface VehicleService {
    VehicleResponseDto create(VehicleRequestDto request);

    List<VehicleResponseDto> getAll();

    VehicleResponseDto getById(int id);

    VehicleResponseDto update(int id, VehicleRequestDto request);

    void delete(int id);
}
