package com.dheeraj.learning.designpatterns.headfirst.proxy.virtual;

import java.awt.*;

public interface State {
    int getIconWidth();
    int getIconHeight();
    void paintIcon(final Component c, Graphics g, int x, int y);
}
