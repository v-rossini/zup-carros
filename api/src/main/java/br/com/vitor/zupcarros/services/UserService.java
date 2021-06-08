package br.com.vitor.zupcarros.services;

import java.text.ParseException;

import javax.mail.internet.AddressException;

import org.springframework.http.ResponseEntity;

import br.com.vitor.zupcarros.controller.forms.UserForm;
import br.com.vitor.zupcarros.dto.UserDto;
import br.com.vitor.zupcarros.entities.User;

public interface UserService {

	User findUser(Long userId);
    ResponseEntity<UserDto> registerUser(UserForm form) throws AddressException, ParseException;
    ResponseEntity<UserDto> getUser(Long id);

}
