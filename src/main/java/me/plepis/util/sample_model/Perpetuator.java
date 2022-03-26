package me.plepis.util.sample_model;

import java.io.Serializable;

public class Perpetuator implements Serializable {

    private String domain;
    private String name;
    private int luckyNumber;

    public Perpetuator(String name, String domain, int luckyNumber) {
        this.name = name;
        this.domain = domain;
        this.luckyNumber = luckyNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getDomain() {
        return this.domain;
    }

    public int getLuckyNumber() {
        return this.luckyNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setLuckyNumber(int luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    @Override
    public String toString() {
        return this.name + " has a domain " + this.domain + " and lucky number " + this.luckyNumber;
    }

}