package com.clayerp.dto;

public class CreateRestaurantTableResponse {

    private Long id;
    private Integer number;
    private String qrCode;

    public CreateRestaurantTableResponse() {}

    public CreateRestaurantTableResponse(Long id, Integer number, String qrCode) {
        this.id = id;
        this.number = number;
        this.qrCode = qrCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
