package com.dheeraj.learning.designpatterns.builder;

public class Phone {
    int ram;
    String os;
    int screensize;
    int cost;
    int externalMemory;

    public Phone(int ram, String os, int screensize, int cost, int externalMemory) {
        this.ram = ram;
        this.os = os;
        this.screensize = screensize;
        this.cost = cost;
        this.externalMemory = externalMemory;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getScreensize() {
        return screensize;
    }

    public void setScreensize(int screensize) {
        this.screensize = screensize;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getExternalMemory() {
        return externalMemory;
    }

    public void setExternalMemory(int externalMemory) {
        this.externalMemory = externalMemory;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "ram=" + ram +
                ", os='" + os + '\'' +
                ", screensize=" + screensize +
                ", cost=" + cost +
                ", externalMemory=" + externalMemory +
                '}';
    }
}
