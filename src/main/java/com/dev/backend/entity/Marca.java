package com.dev.backend.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "marca")
@lombok.Data
public class Marca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data_criacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data_update;

}
