package com.dheeraj.learning.designpatterns.builder;

public class PhoneBuilder {
    int ram;
    String os;
    int screensize;
    int cost;
    int externalMemory;

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setScreensize(int screensize) {
        this.screensize = screensize;
        return this;
    }

    public PhoneBuilder setCost(int cost) {
        this.cost = cost;
        return this;
    }

    public PhoneBuilder setExternalMemory(int externalMemory) {
        this.externalMemory = externalMemory;
        return this;
    }

    public Phone getPhone() {
        return new Phone(ram, os, screensize, cost, externalMemory);
    }
}
