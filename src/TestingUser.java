import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestingUser {

    public static void main(String[] args) {
        // Create a new User
        User user = new User("John", "Smith", "jsmith", "john@example.com");

        // Display user information
        System.out.println("User Information:");
        System.out.println("First Name: " + user.getFirstname());
        System.out.println("Last Name: " + user.getLastname());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());

        // Add plants to the user
        Plant plant1 = new Plant("Rose", "Flowering Plant", "Description of Rose", "Loamy Soil", LightExposure.FULLSUN, Location.INDOOR);
        Plant plant2 = new Plant("Cactus", "Desert Plant", "Description of Cactus", "Sandy Soil", LightExposure.FULLSUN, Location.OUTDOOR);
        user.addPlant(plant1);
        user.addPlant(plant2);

        // Display the list of plants
        System.out.println("\nPlants owned by the user:");
        user.getPlants().forEach(plant -> System.out.println(plant.getPlantName()));

        // Search for a plant
        System.out.println("\nSearching for 'Rose':");
        List<Plant> searchResults = user.searchPlants("Rose");
        searchResults.forEach(plant -> System.out.println(plant.getPlantName()));

        // Remove a plant
        System.out.println("\nRemoving 'Cactus' from the user's plants.");
        user.removePlant(plant2);

        // Display the updated list of plants
        System.out.println("Updated list of plants:");
        user.getPlants().forEach(plant -> System.out.println(plant.getPlantName()));
    }
}
