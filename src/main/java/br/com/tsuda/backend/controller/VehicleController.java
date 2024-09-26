package br.com.tsuda.backend.controller;

import br.com.tsuda.backend.domain.dto.request.VehicleRequestDto;
import br.com.tsuda.backend.domain.dto.response.VehicleResponseDto;
import br.com.tsuda.backend.service.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public VehicleResponseDto create(@RequestBody VehicleRequestDto request) {
        return vehicleService.create(request);
    }

    @GetMapping
    public List<VehicleResponseDto> getAll() {
        return vehicleService.getAll();
    }

    @GetMapping("/{id}")
    public VehicleResponseDto getById(@PathVariable int id) {
        return vehicleService.getById(id);
    }

    @PutMapping("/{id}")
    public VehicleResponseDto update(@PathVariable int id, @RequestBody VehicleRequestDto request) {
        return vehicleService.update(id, request);
    }
}
