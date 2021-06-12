package br.com.vitor.zupcarros.services;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.vitor.zupcarros.controller.forms.VehicleForm;
import br.com.vitor.zupcarros.dto.VehicleDto;
import br.com.vitor.zupcarros.entities.Vehicle;
import br.com.vitor.zupcarros.repositories.VehicleRepository;
import br.com.vitor.zupcarros.services.util.Json;
import br.com.vitor.zupcarros.services.util.ServicesUtil;

@Service
public class VehicleServiceImp implements VehicleService {
	
	@Autowired
	VehicleRepository repository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ServicesUtil util;
	
    String baseApiUrl = "https://parallelum.com.br/fipe/api/v1/";
	
	
	@Override
	@Transactional
	public ResponseEntity<VehicleDto> registerVehicle (VehicleForm form) throws IOException {
		Vehicle veiculo = form.convertToEntity(userService);
		veiculo = addAtributes(veiculo);
		veiculo = repository.save(veiculo);
		
		VehicleDto veiculoDto = new VehicleDto(veiculo);
		veiculoDto.setRodizioAtivo(util.isToday(veiculoDto.getRodizio()));
		return new ResponseEntity<>(veiculoDto, HttpStatus.CREATED);
	}
	
	@Transactional
	public Vehicle addAtributes(Vehicle veiculo) throws IOException {
		String query = baseApiUrl + veiculo.getTipo().name().toLowerCase() + "/marcas/"
				+ veiculo.getMarcaCod() + "/modelos/" + veiculo.getModeloCod() + "/anos/" + veiculo.getAnoCod();
		URL url = new URL(query);
		JsonNode node = Json.parse(url);
		
		veiculo = addModelo(veiculo, node);
		veiculo = addMarca(veiculo, node);
		veiculo = addValor(veiculo, node);
		veiculo = addRodizio(veiculo);
		return veiculo;
	}
	
	@Transactional
	public Vehicle addModelo(Vehicle veiculo, JsonNode node) throws IOException {

		if (node.get("Modelo") != null) {
			veiculo.setModelo(node.get("Modelo").asText());
		}
		return veiculo;
		
	}
	
	@Transactional
	public Vehicle addMarca(Vehicle veiculo, JsonNode node) throws IOException {

		if (node.get("Marca") != null) {
			veiculo.setMarca(node.get("Marca").asText());
		}
		return veiculo;
	}
	
	@Transactional
	public Vehicle addValor(Vehicle veiculo, JsonNode node) throws IOException {

		if (node.get("Valor") != null) {
			veiculo.setValor(node.get("Valor").asText());		
		}
		return veiculo;
	}
	
	@Transactional
	public Vehicle addRodizio(Vehicle veiculo) {
		if (veiculo.getAno() != null && veiculo.getAno().length() > 0) {
			String lastDigit = String.valueOf( veiculo.getAno().charAt(veiculo.getAno().length() - 1) );
			
			switch (lastDigit.toString()) {
			case "0":
			case "1":
				veiculo.setRodizio(DayOfWeek.valueOf("MONDAY"));
				break;		
			case "2":
			case "3":
				veiculo.setRodizio(DayOfWeek.valueOf("TUESDAY"));
				break;
			case "4":
			case "5":
				veiculo.setRodizio(DayOfWeek.valueOf("WEDNESDAY"));
				break;
			case "6":
			case "7":
				veiculo.setRodizio(DayOfWeek.valueOf("THURSDAY"));
				break;
			case "8":
			case "9":
				veiculo.setRodizio(DayOfWeek.valueOf("FRYDAY"));
				break;			
			}
		}		
		return veiculo;
	}
	
	
	
}
