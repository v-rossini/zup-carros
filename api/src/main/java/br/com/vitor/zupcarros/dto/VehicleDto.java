package br.com.vitor.zupcarros.dto;


import br.com.vitor.zupcarros.entities.Vehicle;
import br.com.vitor.zupcarros.entities.enums.DiaSemana;
import br.com.vitor.zupcarros.entities.enums.VehicleFuel;
import br.com.vitor.zupcarros.entities.enums.VehicleType;

public class VehicleDto {
	
	private Long id;
	private String marca;
	private String modelo;
	private String ano;
	private Float valor;
	private DiaSemana rodizio;
	private boolean rodizioAtivo = false;
	private VehicleType tipo;
	private VehicleFuel combustivel;
	private String placa;
	
	
	public VehicleDto () {}
	
	public VehicleDto(Vehicle veiculo) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.ano = veiculo.getAno();
		this.valor = veiculo.getValor();
		this.rodizio = veiculo.getRodizio();
		this.tipo = veiculo.getTipo();
		this.combustivel = veiculo.getCombustivel();
		this.placa = veiculo.getPlaca();
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public DiaSemana getRodizio() {
		return rodizio;
	}
	public void setRodizio(DiaSemana rodizio) {
		this.rodizio = rodizio;
	}
	public boolean isRodizioAtivo() {
		return rodizioAtivo;
	}
	public void setRodizioAtivo(boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}
	public VehicleType getTipo() {
		return tipo;
	}
	public void setTipo(VehicleType tipo) {
		this.tipo = tipo;
	}
	public VehicleFuel getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(VehicleFuel combustivel) {
		this.combustivel = combustivel;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}		

}
