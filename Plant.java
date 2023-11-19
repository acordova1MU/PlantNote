package com.plantcare;

import java.util.ArrayList;
import java.util.List;

public class Plant {
    private String name;
    private String species;
    private List<Reminder> reminders;

    public Plant(String name, String species) {
        this.name = name;
        this.species = species;
        this.reminders = new ArrayList<>();
    }

    public void addReminder(Reminder reminder) {
        reminders.add(reminder);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public List<Reminder> getReminders() {
        return new ArrayList<>(reminders); // Return a copy of the list to maintain encapsulation
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}