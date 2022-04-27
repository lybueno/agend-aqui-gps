package br.edu.ifsp.scl.gps.agendAqui.services;

import br.edu.ifsp.scl.gps.agendAqui.dto.ScheduleDTO;
import br.edu.ifsp.scl.gps.agendAqui.dto.ScheduleInsertDTO;
import br.edu.ifsp.scl.gps.agendAqui.dto.ScheduleUpdateDTO;
import br.edu.ifsp.scl.gps.agendAqui.dto.UserDTO;
import br.edu.ifsp.scl.gps.agendAqui.entities.Schedule;
import br.edu.ifsp.scl.gps.agendAqui.entities.User;
import br.edu.ifsp.scl.gps.agendAqui.repositories.ScheduleRepository;
import br.edu.ifsp.scl.gps.agendAqui.repositories.UserRepository;
import br.edu.ifsp.scl.gps.agendAqui.services.exceptions.DatabaseException;
import br.edu.ifsp.scl.gps.agendAqui.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public ScheduleDTO findById(Long id){
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        Schedule entity = schedule.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ScheduleDTO(entity);
    }

    @Transactional
    public List<ScheduleDTO> findByProviderId(Long id){
        Optional<User> user = userRepository.findById(id);
        User userEntity = user.orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<Schedule> listEntities = scheduleRepository.findByProvider(userEntity);

        List<ScheduleDTO> listEntitiesDTO = new ArrayList<>();
        listEntities.forEach((element) -> listEntitiesDTO.add(new ScheduleDTO(element)));

        return listEntitiesDTO;
    }

    @Transactional
    public ScheduleDTO insert(ScheduleInsertDTO dto){
        Schedule entity = new Schedule();
        copyDtoToEntity(dto, entity);
        entity = scheduleRepository.save(entity);
        return new ScheduleDTO(entity);
    }

    @Transactional
    public List<ScheduleDTO> findByClientId(Long id){
        Optional<User> user = userRepository.findById(id);
        User userEntity = user.orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<Schedule> listEntities = scheduleRepository.findByClient(userEntity);

        List<ScheduleDTO> listEntitiesDTO = new ArrayList<>();
        listEntities.forEach((element) -> listEntitiesDTO.add(new ScheduleDTO(element)));

        return listEntitiesDTO;
    }

    @Transactional
    public ScheduleDTO findByDate(LocalDate date){
        Optional<Schedule> schedule = scheduleRepository.findByDate(date);
        Schedule entity = schedule.orElseThrow(() -> new ResourceNotFoundException("Entity by date not found"));

        return new ScheduleDTO(entity);
    }

    @Transactional
    public ScheduleDTO update(Long id, ScheduleUpdateDTO dto){
        try {
            Schedule entity = scheduleRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = scheduleRepository.save(entity);
            return new ScheduleDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id " + id + " not found");
        }

    }

    public void delete(Long id){
        try {
            scheduleRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id " + id + " not found ");
        }
        catch(DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }

    }

    private void copyDtoToEntity(ScheduleDTO dto, Schedule entity){
        entity.setDate(dto.getDate());
        entity.setIdUserProvider(dto.getProvider());
        entity.setIdUserClient(dto.getClient());
    }
}
