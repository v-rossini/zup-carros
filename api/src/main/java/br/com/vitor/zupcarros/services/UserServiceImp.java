package br.com.vitor.zupcarros.services;


import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.mail.internet.AddressException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vitor.zupcarros.controller.forms.UserForm;
import br.com.vitor.zupcarros.dto.UserDto;
import br.com.vitor.zupcarros.dto.VehicleDto;
import br.com.vitor.zupcarros.entities.User;
import br.com.vitor.zupcarros.entities.Vehicle;
import br.com.vitor.zupcarros.repositories.UserRepository;
import br.com.vitor.zupcarros.repositories.VehicleRepository;
import br.com.vitor.zupcarros.services.util.ServicesUtil;


@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	ServicesUtil util;
	
	
	@Transactional
	public User findUser(@NotNull @NotEmpty @NotBlank Long userId) {
		Optional<User> user = repository.findById(userId);

		if (!user.isPresent()) 
			throw new NoSuchElementException("Não foi encontrado um usuário com id #" + userId.toString());
		
		return user.get();
		
	}
	
	@Transactional
	public ResponseEntity<UserDto> registerUser(UserForm form) throws AddressException, ParseException {
		try {
		User user = repository.save(form.convertToEntity(util));
			return new ResponseEntity<>(new UserDto(user), HttpStatus.CREATED);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possível cadastrar usuário. Email ou CPF já registrados");
		}
	}
		

	public ResponseEntity<UserDto> getUser(Long userId) {
		return ResponseEntity.ok(new UserDto(findUser(userId)));
	}


	@Override
	@Transactional
	public ResponseEntity<List<VehicleDto>> getUserVehicles(Long userId) {

		List<Vehicle> list = findUser(userId).getVeiculos();
		List<VehicleDto> listDto = list.stream().map(vehicle -> new VehicleDto(vehicle)).collect(Collectors.toList());
		for(VehicleDto dto : listDto) 
			dto.setRodizioAtivo(util.isToday(dto.getRodizio()));
		
		return new ResponseEntity<>(listDto, HttpStatus.OK);
	}
}
