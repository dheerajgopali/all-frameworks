package com.dheeraj.learning.emailservice;

/**
 * Created by gopad on 28-09-2017.
 */
public class EmailServerData {
    private String smtpHostKey;
    private String smtpHostValue;

    public EmailServerData() {
        this.smtpHostKey = "mail.smtp.host";
        this.smtpHostValue = "EXINTOPEN.rpega.com";
    }

    public String getSmtpHostKey() {
        return smtpHostKey;
    }

    public void setSmtpHostKey(String smtpHostKey) {
        this.smtpHostKey = smtpHostKey;
    }

    public String getSmtpHostValue() {
        return smtpHostValue;
    }

    public void setSmtpHostValue(String smtpHostValue) {
        this.smtpHostValue = smtpHostValue;
    }
}
