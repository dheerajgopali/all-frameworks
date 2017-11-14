package com.dheeraj.learning.emailservice;

/**
 * Created by gopad on 28-09-2017.
 */
public class EmailData {
    private String to;
    private String from;
    private String subject;
    private String text;

    public EmailData() {
        this.to = "DheerajKumar.Gopali@in.pega.com";
        this.from = "DheerajKumar.Gopali@in.pega.com";
        this.subject = "Test sub";
        this.text = "Test content";
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
