package com.dheeraj.learning.designpatterns.headfirst.command;

public class LastOperation {
    private int slot;
    private boolean on;

    public LastOperation(int slot, boolean on) {
        this.slot = slot;
        this.on = on;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
