package com.dheeraj.learning.designpatterns.headfirst.proxy.virtual;

import java.awt.*;

public class LoadedState implements State {
    ImageProxy imageProxy;

    public LoadedState(ImageProxy imageProxy) {
        this.imageProxy = imageProxy;
    }

    @Override
    public int getIconWidth() {
        return imageProxy.imageIcon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return imageProxy.imageIcon.getIconHeight();
    }

    @Override
    public void paintIcon(final Component c, Graphics g, int x, int y) {
        imageProxy.imageIcon.paintIcon(c,g,x,y);
    }
}
