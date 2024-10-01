package br.com.tsuda.backend.service;

import br.com.tsuda.backend.controller.dto.request.PartRequestDto;
import br.com.tsuda.backend.controller.dto.request.PartUpdateRequestDto;
import br.com.tsuda.backend.controller.dto.response.PartResponseDto;
import br.com.tsuda.backend.domain.converter.PartConverter;
import br.com.tsuda.backend.domain.entity.Part;
import br.com.tsuda.backend.domain.entity.Vehicle;
import br.com.tsuda.backend.domain.repository.PartRepository;
import br.com.tsuda.backend.domain.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartServiceImpl implements PartService{

    private PartRepository partRepository;
    private VehicleRepository vehicleRepository;

    public PartServiceImpl(PartRepository partRepository, VehicleRepository vehicleRepository) {
        this.partRepository = partRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public PartResponseDto create(PartRequestDto request) {
        List<Vehicle> vehicles = request.vehiclesIds().stream()
                .map(vid -> vehicleRepository.findById(vid)
                        .orElseThrow(() -> new NotFoundException("Vehicle with id %d not found".formatted(vid))))
                .toList();

        Part part = PartConverter.toPartEntity(request, vehicles);

        return PartConverter.toPartResponseDto(partRepository.save(part));
    }

    @Override
    public List<PartResponseDto> getAll() {
        List<Part> parts = partRepository.findAll();

        if(parts.isEmpty()) {
            throw new NotFoundException("No parts found!");
        }

        return parts.stream()
                .map(PartConverter::toPartResponseDto)
                .toList();
    }

    @Override
    public PartResponseDto getById(int id) {
        Part part = partRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Part with id %d not found!".formatted(id)));

        return PartConverter.toPartResponseDto(part);
    }

    @Override
    public PartResponseDto update(int id, PartUpdateRequestDto request) {
        Part part = partRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Part with id %d not found!".formatted(id)));

        List<Vehicle> vehicles = request.vehiclesIds().stream()
                .map(v -> vehicleRepository.findById(v)
                        .orElseThrow(() -> new NotFoundException("Vehicle with id %d not found!".formatted(v))))
                .collect(Collectors.toList());

        Part updatedPart = partRepository.save(PartConverter.toUpdatedPart(part, request, vehicles));

        return PartConverter.toPartResponseDto(updatedPart);
    }

    @Override
    public void delete(int id) {
        Part part = partRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Part with id %d not found!".formatted(id)));

        partRepository.delete(part);
    }
}
