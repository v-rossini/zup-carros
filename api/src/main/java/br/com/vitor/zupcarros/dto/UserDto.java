package br.com.vitor.zupcarros.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.vitor.zupcarros.entities.User;

public class UserDto {
	
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private Date dataNascimento;
	
	private List<VehicleDto> veiculos = new ArrayList<>();
	
	public UserDto() {}
	
	public UserDto(User user) {
		this.id = user.getId();
		this.nome = user.getNome();
		this.cpf = user.getCpf();
		this.email = user.getEmail();
		this.dataNascimento = user.getDataNascimento();
        if(user.getVeiculos () != null)
            this.veiculos = user.getVeiculos().stream()
                    .map(vehicle -> new VehicleDto(vehicle))
                    .collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<VehicleDto> getVeiculos() {
		return veiculos;
	}
	
	

}
