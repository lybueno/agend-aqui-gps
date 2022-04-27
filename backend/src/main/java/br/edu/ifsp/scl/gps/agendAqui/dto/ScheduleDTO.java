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

    private User provider;

    private User client;

    public ScheduleDTO() {
    }

    public ScheduleDTO(Long id, LocalDate date, User provider, User client) {
        this.id = id;
        this.date = date;
        this.provider = provider;
        this.client = client;
    }

    public ScheduleDTO(Schedule schedule) {
        id = schedule.getId();
        date = schedule.getDate();
        provider = schedule.getProvider();
        client = schedule.getClient();
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

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
