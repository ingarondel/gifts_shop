package com.example.giftsshop;

public class Sale {
    private int sale_id;
    private int clients_id;
    private int products_id;
    private int staffs_id;
    private String product_count;

    public Sale() {
    }

    public int getSale_id() {
        return sale_id;
    }

    public void setSale_id(int sale_id) {
        this.sale_id = sale_id;
    }

    public int getClients_id() {
        return clients_id;
    }

    public void setClients_id(int clients_id) {
        this.clients_id = clients_id;
    }

    public int getProducts_id() {
        return products_id;
    }

    public void setProducts_id(int products_id) {
        this.products_id = products_id;
    }

    public int getStaffs_id() {
        return staffs_id;
    }

    public void setStaffs_id(int staffs_id) {
        this.staffs_id = staffs_id;
    }

    public String getProduct_count() {
        return product_count;
    }

    public void setProduct_count(String product_count) {
        this.product_count = product_count;
    }
}
