package br.edu.ifsp.scl.gps.agendAqui.services.validation;

import br.edu.ifsp.scl.gps.agendAqui.dto.ScheduleUpdateDTO;
import br.edu.ifsp.scl.gps.agendAqui.entities.Schedule;
import br.edu.ifsp.scl.gps.agendAqui.entities.User;
import br.edu.ifsp.scl.gps.agendAqui.repositories.ScheduleRepository;
import br.edu.ifsp.scl.gps.agendAqui.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ScheduleUpdateValidator implements ConstraintValidator<ScheduleUpdateValid, ScheduleUpdateDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ScheduleRepository repository;

    @Override
    public void initialize(ScheduleUpdateValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ScheduleUpdateDTO scheduleUpdateDTO, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        long scheduleId = Long.parseLong(uriVars.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        Optional<Schedule> schedule = repository.findByDate(scheduleUpdateDTO.getDate());

        // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista

        if(schedule.isEmpty()) {
            list.add(new FieldMessage("agendamento", "Sem agendamentos para essa data"));
        }else{
            if( schedule.get().getClient() != null){
                list.add(new FieldMessage("agendamento", "Data e horario ocupado"));
            }
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
