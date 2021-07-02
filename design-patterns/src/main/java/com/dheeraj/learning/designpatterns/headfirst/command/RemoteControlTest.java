package com.dheeraj.learning.designpatterns.headfirst.command;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor("Garage");
        Stereo stereo = new Stereo("Living Room");

        remote.setCommand(0, livingRoomLight::on, livingRoomLight::off);
        remote.setCommand(1, kitchenLight::on, kitchenLight::off);
        remote.setCommand(2, ceilingFan::on, ceilingFan::off);
        remote.setCommand(3, garageDoor::open, garageDoor::close);
        remote.setCommand(4, stereo::on, stereo::off);


        remote.onButtonWasPressed(0);
        remote.onButtonWasPressed(1);
        remote.onButtonWasPressed(2);
        remote.onButtonWasPressed(3);
        remote.onButtonWasPressed(4);
        remote.undo();

        remote.offButtonWasPressed(0);
        remote.offButtonWasPressed(1);
        remote.offButtonWasPressed(2);
        remote.offButtonWasPressed(3);
        remote.offButtonWasPressed(4);

    }
}

