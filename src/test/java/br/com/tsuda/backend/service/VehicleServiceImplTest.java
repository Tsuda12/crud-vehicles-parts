package br.com.tsuda.backend.service;

import br.com.tsuda.backend.controller.dto.request.VehicleRequestDto;
import br.com.tsuda.backend.controller.dto.request.VehicleUpdateRequestDto;
import br.com.tsuda.backend.controller.dto.response.VehicleResponseDto;
import br.com.tsuda.backend.domain.entity.Vehicle;
import br.com.tsuda.backend.domain.repository.VehicleRepository;
import br.com.tsuda.backend.fixture.vehicle.VehicleFixture;
import br.com.tsuda.backend.fixture.vehicle.VehicleRequestDtoFixture;
import br.com.tsuda.backend.fixture.vehicle.VehicleUpdateRequestDtoFixture;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {

    @InjectMocks
    private VehicleServiceImpl vehicleService;
    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    void create_shouldCreateVehicle() {
        // Arrange
        VehicleRequestDto request = VehicleRequestDtoFixture.vehicleRequest();

        Vehicle vehicle = VehicleFixture.vehicleEntity(request.brand(), request.model(), request.yearOfManufacture());
        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);

        // Act
        VehicleResponseDto result = vehicleService.create(request);

        // Assert
        assertEquals(request.brand(), result.brand());
        assertEquals(request.model(), result.model());
        assertEquals(request.yearOfManufacture(), result.yearOfManufacture());
        verify(vehicleRepository, times(1)).save(any(Vehicle.class));
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    void getAll_shouldGetAllVehicles() {
        // Arrange
        List<Vehicle> vehicles = List.of(VehicleFixture.vehicleEntityCorsa(), VehicleFixture.vehicleEntityVectra());
        when(vehicleRepository.findAll()).thenReturn(vehicles);

        // Act
        List<VehicleResponseDto> result = vehicleService.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(vehicleRepository, times(1)).findAll();
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    void getById_shouldGetVehicleById() {
        // Arrange
        int id = 1;

        Vehicle vehicle = VehicleFixture.vehicleEntityCorsa();
        when(vehicleRepository.findById(id)).thenReturn(Optional.of(vehicle));

        // Act
        VehicleResponseDto result = vehicleService.getById(id);

        // Assert
        assertNotNull(result);
        assertEquals(result.model(), vehicle.getModel());
        verify(vehicleRepository, times(1)).findById(id);
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    void update_shouldUpdateVehicle() {
        // Arrange
        int id = 1;
        VehicleUpdateRequestDto request = VehicleUpdateRequestDtoFixture.vehicleEntityUpdated();

        Vehicle vehicle = VehicleFixture.vehicleEntityCorsa();
        when(vehicleRepository.findById(id)).thenReturn(Optional.of(vehicle));

        Vehicle updatedVehicle = VehicleFixture.vehicleEntityUpdated(request);
        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(updatedVehicle);

        // Act
        VehicleResponseDto result = vehicleService.update(id, request);

        // Assert
        assertEquals(request.brand(), result.brand());
        assertEquals(request.model(), result.model());
        assertEquals(request.yearOfManufacture(), result.yearOfManufacture());
        verify(vehicleRepository, times(1)).findById(id);
        verify(vehicleRepository, times(1)).save(any(Vehicle.class));
        verifyNoMoreInteractions(vehicleRepository);
    }
}
