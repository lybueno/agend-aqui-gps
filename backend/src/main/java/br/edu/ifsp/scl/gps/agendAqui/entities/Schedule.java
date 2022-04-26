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

    @OneToOne
    private User idUserProvider;

    @OneToOne
    private User idUserClient;


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
