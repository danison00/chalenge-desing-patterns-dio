package com.dan.model.entities;

import java.util.ArrayList;
import java.util.List;

public class NotificationPreferences {

    private boolean enable;
    private boolean smsEnable;
    private boolean emailEnable;

    public NotificationPreferences(boolean enable, boolean smsEnable, boolean emailEnable) {
        this.enable = enable;
        this.smsEnable = smsEnable;
        this.emailEnable = emailEnable;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isSmsEnable() {
        return smsEnable;
    }

    public void setSmsEnable(boolean smsEnable) {
        this.smsEnable = smsEnable;
    }

    public boolean isEmailEnable() {
        return emailEnable;
    }

    public void setEmailEnable(boolean emailEnable) {
        this.emailEnable = emailEnable;
    }

    @Override
    public String toString() {
        return "NotificationPreferences{" +
                "enable=" + enable +
                ", smsEnable=" + smsEnable +
                ", emailEnable=" + emailEnable +
                '}';
    }
}
