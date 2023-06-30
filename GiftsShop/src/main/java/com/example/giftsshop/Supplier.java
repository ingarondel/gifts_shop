package com.example.giftsshop;

import java.sql.Date;

public class Supplier {
    private int supplier_id;
    private String firm_name;
    private String country;
    private String firm_address;
    private Date registration_date;

    public Supplier() {
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getFirm_name() {
        return firm_name;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirm_address() {
        return firm_address;
    }

    public void setFirm_address(String firm_address) {
        this.firm_address = firm_address;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
}
