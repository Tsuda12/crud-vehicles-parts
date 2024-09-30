package br.com.tsuda.backend.controller;

import br.com.tsuda.backend.controller.dto.request.PartRequestDto;
import br.com.tsuda.backend.controller.dto.response.PartResponseDto;
import br.com.tsuda.backend.service.PartService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parts")
public class PartController {

    private PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    @Operation(summary = "Create part")
    @PostMapping
    public PartResponseDto create(@RequestBody @Valid PartRequestDto request) {
        return partService.create(request);
    }

    @Operation(summary = "Get all parts")
    @GetMapping
    public List<PartResponseDto> getAll() {
        return partService.getAll();
    }
}
