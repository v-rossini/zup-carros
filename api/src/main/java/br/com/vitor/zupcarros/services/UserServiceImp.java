package br.com.vitor.zupcarros.services;


import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.mail.internet.AddressException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.vitor.zupcarros.controller.forms.UserForm;
import br.com.vitor.zupcarros.dto.UserDto;
import br.com.vitor.zupcarros.dto.VehicleDto;
import br.com.vitor.zupcarros.entities.User;
import br.com.vitor.zupcarros.repositories.UserRepository;
import br.com.vitor.zupcarros.services.util.ServicesUtil;

public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepository repository;
	@Autowired
	ServicesUtil util;
	

	public User findUser(@NotNull @NotEmpty @NotBlank Long userId) {
		Optional<User> user = repository.findById(userId);

		if (!user.isPresent()) 
			throw new NoSuchElementException("Não foi encontrado um usuário com id #" + userId.toString());
		
		return user.get();
		
	}

	public ResponseEntity<UserDto> registerUser(UserForm form) throws AddressException, ParseException {
		User user = repository.save(form.convertToEntity(util));
		return new ResponseEntity<>(new UserDto(user), HttpStatus.CREATED);
		

	}

	public ResponseEntity<UserDto> getUser(Long userId) {
		return ResponseEntity.ok(new UserDto(findUser(userId)));
	}


	@Override
	public ResponseEntity<List<VehicleDto>> getVehicles(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
