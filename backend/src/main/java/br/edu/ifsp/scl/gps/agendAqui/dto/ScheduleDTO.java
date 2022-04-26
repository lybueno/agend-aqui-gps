package br.edu.ifsp.scl.gps.agendAqui.dto;

import br.edu.ifsp.scl.gps.agendAqui.entities.Schedule;
import br.edu.ifsp.scl.gps.agendAqui.entities.User;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

public class ScheduleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private LocalDate date;

    private User idUserProvider;

    private User idUserClient;

    public ScheduleDTO() {
    }

    public ScheduleDTO(Long id, LocalDate date, User idUserProvider, User idUserClient) {
        this.id = id;
        this.date = date;
        this.idUserProvider = idUserProvider;
        this.idUserClient = idUserClient;
    }

    public ScheduleDTO(Schedule schedule) {
        id = schedule.getId();
        date = schedule.getDate();
        idUserProvider = schedule.getIdUserProvider();
        idUserClient = schedule.getIdUserClient();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getIdUserProvider() {
        return idUserProvider;
    }

    public void setIdUserProvider(User idUserProvider) {
        this.idUserProvider = idUserProvider;
    }

    public User getIdUserClient() {
        return idUserClient;
    }

    public void setIdUserClient(User idUserClient) {
        this.idUserClient = idUserClient;
    }
}
