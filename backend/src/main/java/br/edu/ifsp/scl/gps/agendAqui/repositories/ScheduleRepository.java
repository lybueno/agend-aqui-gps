package br.edu.ifsp.scl.gps.agendAqui.repositories;


import br.edu.ifsp.scl.gps.agendAqui.entities.Schedule;
import br.edu.ifsp.scl.gps.agendAqui.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Schedule findByUserProvider(Long idUserProvider);

    Schedule findByUserClient(Long idUserClient);

    Schedule findByDate(LocalDate date);
}
