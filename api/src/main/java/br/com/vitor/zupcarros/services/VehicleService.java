package br.com.vitor.zupcarros.services;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import br.com.vitor.zupcarros.controller.forms.VehicleForm;
import br.com.vitor.zupcarros.dto.VehicleDto;

public interface VehicleService {
    ResponseEntity<VehicleDto> registerVehicle (VehicleForm form) throws IOException;
}
