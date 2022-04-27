package br.edu.ifsp.scl.gps.agendAqui.services.validation;

import br.edu.ifsp.scl.gps.agendAqui.dto.ScheduleInsertDTO;
import br.edu.ifsp.scl.gps.agendAqui.entities.Schedule;
import br.edu.ifsp.scl.gps.agendAqui.entities.User;
import br.edu.ifsp.scl.gps.agendAqui.repositories.ScheduleRepository;
import br.edu.ifsp.scl.gps.agendAqui.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ScheduleInsertValidator implements ConstraintValidator<ScheduleInsertValid, ScheduleInsertDTO> {

    @Autowired
    private ScheduleRepository repository;

    @Override
    public void initialize(ScheduleInsertValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ScheduleInsertDTO scheduleInsertDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        List<Schedule> schedules = repository.findByProvider(scheduleInsertDTO.getProvider());


        // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista

        if(schedules.isEmpty()) {
            list.add(new FieldMessage("agenda", "Nenhum horário disponível"));
        }

        schedules.forEach(
                schedule -> {
                    if(schedule.getDate().equals(scheduleInsertDTO.getDate())){
                        list.add(new FieldMessage("agenda", "Horário não disponível"));
                    }
                });

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
