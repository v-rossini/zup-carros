package br.com.vitor.zupcarros.entities;

import java.io.Serializable;
import java.time.DayOfWeek;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.vitor.zupcarros.entities.enums.VehicleFuel;
import br.com.vitor.zupcarros.entities.enums.VehicleType;


@Entity
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String marcaCod;
	private String modelo;
	private String modeloCod;
	private String ano;
	private String anoCod;
	private String valor;
	private DayOfWeek rodizio;
	private VehicleType tipo;
	private VehicleFuel combustivel;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User owner;

	public Vehicle () {}

	public Vehicle(String marcaCod, String modeloCod, String ano,
			VehicleType tipo, VehicleFuel combustivel, User owner) {
		this.marcaCod = marcaCod;
		this.modeloCod = modeloCod;
		this.ano = ano;
		this.anoCod = ano + "-" + String.valueOf(combustivel.ordinal()+1);
		this.tipo = tipo;
		this.combustivel = combustivel;
		this.owner = owner;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMarcaCod() {
		return marcaCod;
	}

	public void setMarcaCod(String marcaCod) {
		this.marcaCod = marcaCod;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
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

	public String getAnoCod() {
		return anoCod;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public DayOfWeek getRodizio() {
		return rodizio;
	}

	public void setRodizio(DayOfWeek rodizio) {
		this.rodizio = rodizio;
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

	public Long getId() {
		return id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
