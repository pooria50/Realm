package com.example.pooria.myapplication;

import io.realm.RealmObject;

public class model extends RealmObject {

    String name,family,email, address,username, userpass;
    Long phone,codemelli, codeposty;

    public String getEmail() {
        return email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCodemelli() {
        return codemelli;
    }

    public void setCodemelli(Long codemelli) {
        this.codemelli = codemelli;
    }

    public Long getCodeposty() {
        return codeposty;
    }

    public void setCodeposty(Long codeposty) {
        this.codeposty = codeposty;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
