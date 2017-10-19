package com.example.daniyal.govava;

/**
 * Created by Kashif on 10/19/2017.
 */

public class ModelClass {

    String name;
    String email;
    String pass;
    String conpass;
    String adress;
    String phone;
    String id;

    public ModelClass() {
    }

    public ModelClass(String name, String email, String pass, String conpass, String adress, String phone , String id) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.conpass = conpass;
        this.adress = adress;
        this.phone = phone;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getConpass() {
        return conpass;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }
}
