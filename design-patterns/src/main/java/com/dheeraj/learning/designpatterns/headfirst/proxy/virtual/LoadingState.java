package com.dheeraj.learning.designpatterns.headfirst.proxy.virtual;

import javax.swing.*;
import java.awt.*;

public class LoadingState implements State {
    ImageProxy imageProxy;

    public LoadingState(ImageProxy imageProxy) {
        this.imageProxy = imageProxy;
    }

    @Override
    public int getIconWidth() {
        return 800;
    }

    @Override
    public int getIconHeight() {
        return 600;
    }

    @Override
    public void paintIcon(final Component c, Graphics g, int x, int y) {
        g.drawString("Loading album cover, please wait...", x+300, y+190);
        if (!imageProxy.retrieving) {
            imageProxy.retrieving = true;
            imageProxy.retrievalThread = new Thread(new Runnable() {
                public void run() {
                    try {
                        imageProxy.imageIcon = new ImageIcon(imageProxy.imageURL, "Album Cover");
                        c.repaint();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            imageProxy.retrievalThread.start();
        }
        imageProxy.setCurrentState(imageProxy.loadedState);
    }
}
