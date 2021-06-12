package br.com.vitor.zupcarros.controller.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.vitor.zupcarros.entities.Vehicle;
import br.com.vitor.zupcarros.entities.enums.VehicleFuel;
import br.com.vitor.zupcarros.entities.enums.VehicleType;
import br.com.vitor.zupcarros.services.UserService;

public class VehicleForm {
	
	@NotEmpty @NotNull @NotBlank
	private String marcaCod;
	@NotEmpty @NotNull @NotBlank
	private String modeloCod;
	@NotEmpty @NotNull @NotBlank
	private String ano;
	@NotEmpty @NotNull @NotBlank
	private String tipo;
	@NotEmpty @NotNull @NotBlank
	private String combustivel;
	@NotNull
	private Long userId;
	
	
	public Vehicle convertToEntity(UserService userService) {
		Vehicle veiculo = new Vehicle (marcaCod, modeloCod, ano, VehicleType.valueOf(tipo), 
				VehicleFuel.valueOf(combustivel), userService.findUser(userId) );
		return veiculo;
		
	}	
	
	public String getMarcaCod() {
		return marcaCod;
	}
	public void setMarcaCod(String marcaCod) {
		this.marcaCod = marcaCod;
	}
	
	public String getModeloCod() {
		return modeloCod;
	}
	public void setModeloCod(String modeloCod) {
		this.modeloCod = modeloCod;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	


}
