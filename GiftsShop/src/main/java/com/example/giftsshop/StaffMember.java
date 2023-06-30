package com.example.giftsshop;

public class StaffMember {
    private int staff_id;
    private String SNP;
    private int positions_id;
    private String ID;
    private String paymentID;
    private String home_address;
    private String telephone;
    private String birth_date;

    public StaffMember() {
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getSNP() {
        return SNP;
    }

    public void setSNP(String SNP) {
        this.SNP = SNP;
    }

    public int getPositions_id() {
        return positions_id;
    }

    public void setPositions_id(int positions_id) {
        this.positions_id = positions_id;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }
}
