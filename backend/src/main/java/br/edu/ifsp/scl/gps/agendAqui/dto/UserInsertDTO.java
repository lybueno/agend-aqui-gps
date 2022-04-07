package br.edu.ifsp.scl.gps.agendAqui.dto;

import br.edu.ifsp.scl.gps.agendAqui.services.validation.UserInsertValid;

@UserInsertValid
public class UserInsertDTO extends UserDTO {

	private static final long serialVersionUID = 1L;
	
	private String senha;
	
	public UserInsertDTO() {
		super();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
