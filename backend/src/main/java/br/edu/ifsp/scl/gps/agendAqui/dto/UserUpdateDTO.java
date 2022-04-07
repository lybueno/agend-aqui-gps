package br.edu.ifsp.scl.gps.agendAqui.dto;

import br.edu.ifsp.scl.gps.agendAqui.services.validation.UserUpdateValid;

@UserUpdateValid()
public class UserUpdateDTO extends UserDTO {

	private static final long serialVersionUID = 1L;
	
	public UserUpdateDTO() {
		super();
	}
}
