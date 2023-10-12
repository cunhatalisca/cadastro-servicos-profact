package com.example.Profact.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Servico")
@Data
public class Services {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameClient;

    @Temporal(TemporalType.DATE)
    private Date dateInicial = new Date();

    @Temporal(TemporalType.DATE)
    private Date dateFinal;

    private String description;
    private Double priceService;
    private Double pricePaidOut;

    @Temporal(TemporalType.DATE)
    private Date datePayDay;

    private String status;

}
