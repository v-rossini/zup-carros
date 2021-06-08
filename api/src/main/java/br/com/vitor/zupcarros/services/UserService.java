package br.com.vitor.zupcarros.services;

import java.text.ParseException;
import java.util.List;

import javax.mail.internet.AddressException;

import org.springframework.http.ResponseEntity;

import br.com.vitor.zupcarros.controller.forms.UserForm;
import br.com.vitor.zupcarros.dto.UserDto;
import br.com.vitor.zupcarros.dto.VehicleDto;
import br.com.vitor.zupcarros.entities.User;

public interface UserService {

	User findUser(Long userId);
    ResponseEntity<UserDto> registerUser(UserForm form) throws AddressException, ParseException;
    ResponseEntity<UserDto> getUser(Long userId);
    ResponseEntity<List<VehicleDto>> getVehicles(Long userId);

}
