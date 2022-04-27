package br.edu.ifsp.scl.gps.agendAqui.entities;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private User provider;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;


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

    public void setIdUserProvider(User provider) {
        this.provider = provider;
    }

    public User getClient() {
        return client;
    }

    public void setIdUserClient(User client) {
        this.client = client;
    }
}
