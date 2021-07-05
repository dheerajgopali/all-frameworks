package com.dheeraj.learning.designpatterns.headfirst.proxy.virtual;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

class ImageProxy implements Icon {
    volatile ImageIcon imageIcon;
    final URL imageURL;
    Thread retrievalThread;
    boolean retrieving = false;
    State loadingState;
    State loadedState;
    State currentSate;

    public ImageProxy(URL url) {
        imageURL = url;
        currentSate = new LoadingState(this);
        loadingState = new LoadingState(this);
        loadedState = new LoadedState(this);
    }

    public int getIconWidth() {
        return currentSate.getIconWidth();
    }

    public int getIconHeight() {
        return currentSate.getIconHeight();
    }

    synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public void paintIcon(final Component c, Graphics g, int x, int y) {
        currentSate.paintIcon(c,g,x,y);
    }

    public void setCurrentState(State state) {
        currentSate = state;
    }
}
