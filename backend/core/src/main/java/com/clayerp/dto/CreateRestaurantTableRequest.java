package com.clayerp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateRestaurantTableRequest {

    @NotNull(message = "{validation.required}")
    @Positive(message = "{validation.positive}")
    private Long establishmentId;

    @NotNull(message = "{validation.required}")
    @Positive(message = "{validation.positive}")
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
