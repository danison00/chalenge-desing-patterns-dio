package com.dan.model.entities;

public class User extends AbstractIdentifier {

    private String name;
    private String phone;
    private String email;
    private NotificationPreferences notificationPreferences;

    public User(String name, String phone, String email,  NotificationPreferences notificationPreferences) {

        this.name = name;
        this.phone= phone;
        this.email = email;
        this.notificationPreferences = notificationPreferences;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NotificationPreferences getNotificationPreferences() {
        return notificationPreferences;
    }

    public void setNotificationPreferences(NotificationPreferences notificationPreferences) {
        this.notificationPreferences = notificationPreferences;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", telefone='" + phone + '\'' +
                ", email=" + email +
                ", notificationPreferences=" + notificationPreferences +
                '}';
    }
}
