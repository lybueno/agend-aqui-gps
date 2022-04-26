package br.edu.ifsp.scl.gps.agendAqui.services.validation;

import br.edu.ifsp.scl.gps.agendAqui.dto.ScheduleInsertDTO;
import br.edu.ifsp.scl.gps.agendAqui.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScheduleInsertValidator implements ConstraintValidator<ScheduleInsertValid, ScheduleInsertDTO> {
    //TODO: Implementar classe que eu não entendi nadaaaa

    @Autowired
    private ScheduleRepository repository;

    @Override
    public void initialize(ScheduleInsertValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ScheduleInsertDTO scheduleInsertDTO, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
