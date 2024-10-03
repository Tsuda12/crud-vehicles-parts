package br.com.tsuda.backend.service;

import br.com.tsuda.backend.controller.dto.request.PartRequestDto;
import br.com.tsuda.backend.domain.repository.PartRepository;
import br.com.tsuda.backend.domain.repository.VehicleRepository;
import br.com.tsuda.backend.fixture.part.PartRequestDtoFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PartServiceImplTest {

    @InjectMocks
    private PartServiceImpl partService;
    @Mock
    private PartRepository partRepository;
    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    void create_shouldCreatePart() {
        // Arrange

        // Act

        // Assert
    }
}