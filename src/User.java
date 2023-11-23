import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private List<Plant> plants;

    public User(String firstname, String lastname, String username, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.plants = new ArrayList<>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public List<Plant> searchPlants(String name) {
        return plants.stream()
                .filter(plant -> plant.getPlantName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Getters
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
