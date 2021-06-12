package br.com.vitor.zupcarros.controller;

import java.text.ParseException;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitor.zupcarros.controller.forms.UserForm;
import br.com.vitor.zupcarros.dto.UserDto;
import br.com.vitor.zupcarros.dto.VehicleDto;
import br.com.vitor.zupcarros.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
    @Autowired
    UserService service;
	
    @PostMapping
    public ResponseEntity<UserDto> registerUser(@RequestBody @Valid UserForm form) throws AddressException, 
    ParseException {
        return service.registerUser(form);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return service.getUser(id);
    }
    
    @GetMapping("/{id}/vehicles")
    public ResponseEntity<List<VehicleDto>> getVehicles(@PathVariable Long id) {
        return service.getUserVehicles(id);
    }
    
}
