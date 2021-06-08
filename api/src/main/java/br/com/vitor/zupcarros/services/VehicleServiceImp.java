package br.com.vitor.zupcarros.services;

import java.io.IOException;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.vitor.zupcarros.controller.forms.VehicleForm;
import br.com.vitor.zupcarros.dto.VehicleDto;
import br.com.vitor.zupcarros.entities.Vehicle;
import br.com.vitor.zupcarros.entities.enums.DiaSemana;
import br.com.vitor.zupcarros.repositories.VehicleRepository;
import br.com.vitor.zupcarros.services.util.Json;
import br.com.vitor.zupcarros.services.util.ServicesUtil;

public class VehicleServiceImp implements VehicleService {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ServicesUtil util;
	
    String baseApiUrl = "https://parallelum.com.br/fipe/api/v1/";
	
	
	@Override
	public ResponseEntity<VehicleDto> registerVehicle (VehicleForm form) {
		Vehicle veiculo = form.convertToEntity(userService);
		return new ResponseEntity<>(new VehicleDto(veiculo), HttpStatus.CREATED);
	}
	
	public Vehicle addAtributes(Vehicle veiculo) throws IOException {
		veiculo = addModelo(veiculo);
		veiculo = addMarca(veiculo);
		veiculo = addValor(veiculo);
		veiculo = addRodizio(veiculo);
		return veiculo;
	}
	
	public Vehicle addModelo(Vehicle veiculo) throws IOException {
		String url = baseApiUrl + veiculo.getTipo().name().toLowerCase() + "/marcas/"
				+ veiculo.getMarcaCod() + "/modelos/" + veiculo.getModeloCod() + "/anos" + veiculo.getAnoCod();
		JsonNode veiculos = Json.parse(url);
		veiculo.setModelo(veiculos.get("modelo").asText());
		return veiculo;
		
	}
	
	public Vehicle addMarca(Vehicle veiculo) throws IOException {
		String url = baseApiUrl + veiculo.getTipo().name().toLowerCase() + "/marcas/"
				+ veiculo.getMarcaCod() + "/modelos/" + veiculo.getModeloCod() + "/anos" + veiculo.getAnoCod();
		JsonNode veiculos = Json.parse(url);
		veiculo.setMarca(veiculos.get("marca").asText());

		return veiculo;
	}
	
	public Vehicle addValor(Vehicle veiculo) throws IOException {
		String url = baseApiUrl + veiculo.getTipo().name().toLowerCase() + "/marcas/"
				+ veiculo.getMarcaCod() + "/modelos/" + veiculo.getModeloCod() + "/anos" + veiculo.getAnoCod();
		JsonNode veiculos = Json.parse(url);
		veiculo.setValor(veiculos.get("valor").asText());		
		return veiculo;
	}
	
	public Vehicle addRodizio(Vehicle veiculo) {
		if (veiculo.getAno() != null && veiculo.getAno().length() > 0) {
			char lastDigit = veiculo.getAno().charAt(veiculo.getAno().length() - 1);
			
			switch (lastDigit) {
			case 0:
				veiculo.setRodizio(DayOfWeek.valueOf("MONDAY"));
				break;
			case 1:
				veiculo.setRodizio(DayOfWeek.valueOf("MONDAY"));
				break;		
			case 2:
				veiculo.setRodizio(DayOfWeek.valueOf("TUESDAY"));
				break;
			case 3:
				veiculo.setRodizio(DayOfWeek.valueOf("TUESDAY"));
				break;
			case 4:
				veiculo.setRodizio(DayOfWeek.valueOf("WEDNESDAY"));
				break;
			case 5:
				veiculo.setRodizio(DayOfWeek.valueOf("WEDNESDAY"));
				break;
			case 6:
				veiculo.setRodizio(DayOfWeek.valueOf("THURSDAY"));
				break;
			case 7:
				veiculo.setRodizio(DayOfWeek.valueOf("THURSDAY"));
				break;
			case 8:
				veiculo.setRodizio(DayOfWeek.valueOf("FRYDAY"));
				break;
			case 9:
				veiculo.setRodizio(DayOfWeek.valueOf("FRYDAY"));
				break;			
			}
		}		
		return veiculo;
	}
	
	public boolean rodizioAtivo(Vehicle veiculo) {
		LocalDate today = LocalDate.now();
		return veiculo.getRodizio() == today.getDayOfWeek() ;
	}
	
	
}
