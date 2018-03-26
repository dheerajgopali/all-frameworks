package com.dheeraj.learning.designpatterns.adapter;

/**
 * PilotPen and Pen classes are no way related/hierarchical
 *
 */
public class PilotPen {
    public void mark(String str) {
        System.out.println(str);
    }
}
