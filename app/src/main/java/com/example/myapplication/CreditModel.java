package com.example.myapplication ;


public class CreditModel {
    String p_id ;
    String u_id ;
    String nbtranche  ;
    String restepayer ;

    public CreditModel(String p_id, String u_id, String nbtranche, String restepayer) {
        this.p_id = p_id;
        this.u_id = u_id;
        this.nbtranche = nbtranche;
        this.restepayer = restepayer;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getNbtranche() {
        return nbtranche;
    }

    public void setNbtranche(String nbtranche) {
        this.nbtranche = nbtranche;
    }

    public String getRestepayer() {
        return restepayer;
    }

    public void setRestepayer(String restepayer) {
        this.restepayer = restepayer;
    }
}