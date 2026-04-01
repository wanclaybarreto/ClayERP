package com.clayerp.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "restaurant_table")
public class RestaurantTable extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;

    private Integer number;

    private String qrCode;

    private Boolean active;


    public RestaurantTable() {}


    @PrePersist //Assinatura que gera evento JPA que roda antes do objeto ser salvo no banco.
    protected void generateQrCode() {
        if (qrCode == null) {
            qrCode = UUID.randomUUID().toString(); //Gera e seta identificadores únicos e seguros.
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
