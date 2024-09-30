package br.com.tsuda.backend.service;

import br.com.tsuda.backend.controller.dto.request.PartRequestDto;
import br.com.tsuda.backend.controller.dto.response.PartResponseDto;

import java.util.List;

public interface PartService {
    PartResponseDto create(PartRequestDto request);

    List<PartResponseDto> getAll();
}
