package br.edu.ifsp.scl.gps.agendAqui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifsp.scl.gps.agendAqui.entities.User;
import br.edu.ifsp.scl.gps.agendAqui.repositories.UserRepository;
import br.edu.ifsp.scl.gps.agendAqui.services.exceptions.ForbiddenException;
import br.edu.ifsp.scl.gps.agendAqui.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(username);
		} catch(Exception e) {
			throw new UnauthorizedException("Invalid user");
		}
	}
	
	public void validateSelfOrAdmin(Long userId) {
		User user = authenticated();
		if(!user.getId().equals(userId)) {
			throw new ForbiddenException("Access denied");
		}
	}
}
