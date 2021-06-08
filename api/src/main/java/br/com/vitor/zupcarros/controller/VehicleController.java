package br.com.vitor.zupcarros.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitor.zupcarros.controller.forms.VehicleForm;
import br.com.vitor.zupcarros.dto.VehicleDto;
import br.com.vitor.zupcarros.services.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	
    @Autowired
    VehicleService service;
    
    
    @PostMapping
    public ResponseEntity<VehicleDto> registerUser(@RequestBody @Valid VehicleForm form) throws IOException {
        return service.registerVehicle(form);
    }

}
