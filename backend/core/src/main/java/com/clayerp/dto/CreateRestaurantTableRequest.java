package com.clayerp.dto;

public class CreateRestaurantTableRequest {

    private Long establishmentId;
    private Integer number;

    public CreateRestaurantTableRequest() {}

    public Long getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(Long establishmentId) {
        this.establishmentId = establishmentId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
