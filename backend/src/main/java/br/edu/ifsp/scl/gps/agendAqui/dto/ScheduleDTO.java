package br.edu.ifsp.scl.gps.agendAqui.dto;

import br.edu.ifsp.scl.gps.agendAqui.entities.Schedule;
import br.edu.ifsp.scl.gps.agendAqui.entities.User;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ScheduleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDateTime date;

    private User provider;

    private User client;

    public ScheduleDTO() {
    }

    public ScheduleDTO(Long id, LocalDateTime date, User provider, User client) {
        this.id = id;
        this.date = date;
        this.provider = provider;
        this.client = client;
    }

    public ScheduleDTO(Long id, String date, User provider) {
        this.id = id;
        this.date = LocalDateTime.parse(date);
        this.provider = provider;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
