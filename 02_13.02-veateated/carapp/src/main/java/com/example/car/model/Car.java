package com.example.car.mudel;

import jakarta.validation.constraints.*;

public class Car {

    @NotBlank(message = "Mark ei tohi olla tühi")
    private String brand;

    @NotBlank(message = "Mudel ei tohi olla tühi")
    private String mudel;

    @Min(value = 1886, message = "Aasta liiga väike")
    private int aasta;

    @Positive(message = "Hind peab olema positiivne")
    private double hind;

    @Pattern(regexp = "^[A-Z0-9-]{6,10}$", message = "Reg number vale")
    private String numbrimark;

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getmudel() { return mudel; }
    public void setmudel(String mudel) { this.mudel = mudel; }

    public int getaasta() { return aasta; }
    public void setaasta(int aasta) { this.aasta = aasta; }

    public double gethind() { return hind; }
    public void sethind(double hind) { this.hind = hind; }

    public String getnumbrimark() { return numbrimark; }
    public void setnumbrimark(String numbrimark) {
        this.numbrimark = numbrimark;
    }
}
