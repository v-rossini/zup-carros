package br.com.vitor.zupcarros.controller.forms;

import java.text.ParseException;

import javax.mail.internet.AddressException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.vitor.zupcarros.entities.User;
import br.com.vitor.zupcarros.services.util.ServicesUtil;



public class UserForm {
	
	@NotEmpty @NotNull @NotBlank
	private String nome;
	@NotEmpty @NotNull @NotBlank
	private String cpf;
	@NotEmpty @NotNull @NotBlank
	private String email;
	@NotEmpty @NotNull @NotBlank
	private String dataNascimento;
	
	
	public UserForm() {}
	
	public UserForm(String nome, String cpf, String email, String dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
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
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
    
    public User convertToEntity(ServicesUtil util) throws AddressException, ParseException {
    	return new User(nome, cpf, util.emailValidator(email), util.converterData(dataNascimento));        
    }
    
	
}
