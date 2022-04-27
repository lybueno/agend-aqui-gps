package br.edu.ifsp.scl.gps.agendAqui.repositories;


import br.edu.ifsp.scl.gps.agendAqui.entities.Schedule;
import br.edu.ifsp.scl.gps.agendAqui.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByProvider(User provider);

    List<Schedule> findByClient(User client);

    Optional<Schedule> findByDate(LocalDate date);
}
