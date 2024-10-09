package br.com.tsuda.backend.service;

import br.com.tsuda.backend.controller.dto.request.PartRequestDto;
import br.com.tsuda.backend.controller.dto.response.PartResponseDto;
import br.com.tsuda.backend.domain.entity.Part;
import br.com.tsuda.backend.domain.entity.Vehicle;
import br.com.tsuda.backend.domain.repository.PartRepository;
import br.com.tsuda.backend.domain.repository.VehicleRepository;
import br.com.tsuda.backend.fixture.part.PartFixture;
import br.com.tsuda.backend.fixture.part.PartRequestDtoFixture;
import br.com.tsuda.backend.fixture.vehicle.VehicleFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        PartRequestDto request = PartRequestDtoFixture.partRequest();

        Vehicle vehicle1 = VehicleFixture.vehicleEntityCorsa();
        when(vehicleRepository.findById(request.vehiclesIds().get(0))).thenReturn(Optional.of(vehicle1));

        Vehicle vehicle2 = VehicleFixture.vehicleEntityVectra();
        when(vehicleRepository.findById(request.vehiclesIds().get(1))).thenReturn(Optional.of(vehicle2));

        Part part = PartFixture.partEntity(request, vehicle1, vehicle2);
        when(partRepository.save(any(Part.class))).thenReturn(part);

        // Act
        PartResponseDto result = partService.create(request);

        // Assert
        assertEquals(request.partNumber(), result.partNumber());
        assertEquals(request.brand(), result.brand());
        assertEquals(request.model(), result.model());
        assertEquals(vehicle1.getModel(), result.vehicles().get(0).model());
        assertEquals(vehicle2.getModel(), result.vehicles().get(1).model());
        verify(vehicleRepository, times(1)).findById(request.vehiclesIds().get(0));
        verify(vehicleRepository, times(1)).findById(request.vehiclesIds().get(1));
        verify(partRepository, times(1)).save(any(Part.class));
        verifyNoMoreInteractions(vehicleRepository, partRepository);
    }

    @Test
    void getAll_shouldGetAllParts() {
        // Arrange
        List<Part> parts = List.of(PartFixture.partEntityFreio(), PartFixture.partEntityVela());
        when(partRepository.findAll()).thenReturn(parts);

        // Act
        List<PartResponseDto> result = partService.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(partRepository, times(1)).findAll();
        verifyNoMoreInteractions(partRepository);
    }

    @Test
    void getById_shouldGetPartById() {
        // Arrange
        int id = 1;

        Part part = PartFixture.partEntityFreio();
        when(partRepository.findById(id)).thenReturn(Optional.of(part));

        // Act
        PartResponseDto result = partService.getById(id);

        // Assert
        assertNotNull(result);
        assertEquals(part.getPartNumber(), result.partNumber());
        verify(partRepository, times(1)).findById(id);
        verifyNoMoreInteractions(partRepository);
    }
}