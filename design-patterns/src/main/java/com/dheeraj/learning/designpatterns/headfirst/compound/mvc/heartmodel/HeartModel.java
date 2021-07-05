package com.dheeraj.learning.designpatterns.headfirst.compound.mvc.heartmodel;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HeartModel implements HeartModelInterface, Runnable {
    List<BeatObserver> beatObservers = new ArrayList<>();
    List<BPMObserver> bpmObservers = new ArrayList<>();
    int heartRate = 68;
    Thread thread;
    boolean stop = false;
    Clip clip;

    @Override
    public void initialize() {
        try {
            File resource = new File("design-patterns/src/main/resources/clap.wav");
            clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            clip.open(AudioSystem.getAudioInputStream(resource));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        notifyBPMObservers();
        thread = new Thread(this);
        stop = false;
        thread.start();
    }

    @Override
    public void on() {
    }

    @Override
    public void off() {
    }

    public void run() {
        while (!stop) {
            playBeat();
            notifyBeatObservers();
            try {
                Thread.sleep(60000 / getHeartRate());
            } catch (Exception e) {
            }
        }
    }

    @Override
    public int getHeartRate() {
        return heartRate;
    }

    @Override
    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
        notifyBPMObservers();
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        int i = beatObservers.indexOf(o);
        if (i >= 0) {
            beatObservers.remove(i);
        }
    }

    @Override
    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }

    public void notifyBPMObservers() {
        for (int i = 0; i < bpmObservers.size(); i++) {
            BPMObserver observer = bpmObservers.get(i);
            observer.updateBPM();
        }
    }

    public void notifyBeatObservers() {
        for (int i = 0; i < beatObservers.size(); i++) {
            BeatObserver observer = beatObservers.get(i);
            observer.updateBeat();
        }
    }

    public void playBeat() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void stopBeat() {
        clip.setFramePosition(0);
        clip.stop();
    }
}