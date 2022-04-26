package br.edu.ifsp.scl.gps.agendAqui.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.edu.ifsp.scl.gps.agendAqui.entities.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String nomeCompleto;
	
	@Email(message = "Favor entrar um email válido")
	private String email;
	
	@NotBlank(message = "Campo obrigatório")
	private String cpf;
	
	private String telefone;

	Set<RoleDTO> roles = new HashSet<>();

	List<ScheduleDTO> schedules = new ArrayList<>();
	
	public UserDTO() {}

	public UserDTO(Long id, String nomeCompleto, String email, String cpf, String telefone) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		nomeCompleto = entity.getNomeCompleto();
		email = entity.getEmail();
		cpf = entity.getCpf();
		telefone = entity.getTelefone();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
		entity.getSchedules().forEach(schedule -> this.schedules.add(new ScheduleDTO(schedule)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	public List<ScheduleDTO> getSchedules() {
		return schedules;
	}
}
