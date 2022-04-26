package br.edu.ifsp.scl.gps.agendAqui.services.validation;

import br.edu.ifsp.scl.gps.agendAqui.dto.ScheduleUpdateDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScheduleUpdateValidator implements ConstraintValidator<ScheduleUpdateValid, ScheduleUpdateDTO> {
    //TODO: ver como implementa pq eu nao entendi tbm

    @Override
    public void initialize(ScheduleUpdateValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ScheduleUpdateDTO scheduleUpdateDTO, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
