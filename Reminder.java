package com.plantcare;

public class Reminder {
    private String reminderType;
    private String date;
    private String plantName; // Field to keep track of the plant

    public Reminder(String reminderType, String date, String plantName) {
        this.reminderType = reminderType;
        this.date = date;
        this.plantName = plantName;
    }

    // Getters
    public String getReminderType() {
        return reminderType;
    }

    public String getDate() {
        return date;
    }

    public String getPlantName() {
        return plantName;
    }

    // Setters
    public void setReminderType(String reminderType) {
        this.reminderType = reminderType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
}