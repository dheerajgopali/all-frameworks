package com.dheeraj.learning.designpatterns.headfirst.command;

public class SimpleRemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undo;
    public SimpleRemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        for(int i=0;i<7;i++) {
            onCommands[i] = ()->System.out.println("Command Not Registered");
            offCommands[i] = ()->System.out.println("Command Not Registered");
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undo = offCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        undo = onCommands[slot];
    }

    public void undo() {
        undo.execute();
    }
}
