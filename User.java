package com.plantcare;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String username;
    private String email;
    private ArrayList<Plant> plants;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.plants = new ArrayList<>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void deletePlant(String plantName) {
        plants.removeIf(plant -> plant.getName().equals(plantName));
    }

    public List<Reminder> getAllReminders() {
        List<Reminder> reminders = new ArrayList<>();
        for (Plant plant : plants) {
            reminders.addAll(plant.getReminders());
        }
        return reminders;
    }

    public List<Plant> searchPlants(String query) {
        return plants.stream()
                .filter(plant -> plant.getName().contains(query))
                .collect(Collectors.toList());
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Plant> getPlants() {
        return new ArrayList<>(plants); // Return a copy of the list to maintain encapsulation
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}