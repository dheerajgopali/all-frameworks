package com.dheeraj.learning.designpatterns.factory;

public class OSFactory {
    public OS getInstance(String osName) {
        if("WINDOWS".equalsIgnoreCase(osName)){
            return new Windows();
        } else if("ANDROID".equalsIgnoreCase(osName)) {
            return new Android();
        } else {
            return new Mac();
        }
    }
}
