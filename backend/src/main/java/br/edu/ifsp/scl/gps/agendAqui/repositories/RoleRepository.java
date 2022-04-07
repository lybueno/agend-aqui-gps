package br.edu.ifsp.scl.gps.agendAqui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.scl.gps.agendAqui.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}

