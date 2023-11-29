import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static User user = new User("John", "Smith", "jsmith", "john@example.com");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPlant();
                    break;
                case 2:
                    deletePlant();
                    break;
                case 3:
                    searchPlant();
                    break;
                case 4:
                    viewAllPlants();
                    break;
                case 5:
                    viewUserInformation();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    // Here is a User menu that we can add some more options to like reminders, This could also be called "Users Owned Plants Menu"
    // or something along those lines since this is where they can edit their list of plants and view them.
    private static void printMenu() {
        System.out.println("\n" + user.getFirstname() + " " + user.getLastname() + "'s User Menu");
        System.out.println("1. Add Plant");
        System.out.println("2. Delete Plant");
        System.out.println("3. Search Plant");
        System.out.println("4. View ALL Plants");
        System.out.println("5. View User Information");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addPlant() {
        System.out.print("Enter Plant Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Plant Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Plant Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Plant Soil: ");
        String soil = scanner.nextLine();

        Plant plant = new Plant(name, type, description, soil);
        user.addPlant(plant);
        System.out.println("Plant added successfully.");
    }

    private static void deletePlant() {
        System.out.print("Enter Plant Name to delete: ");
        String name = scanner.nextLine();
        user.getPlants().removeIf(plant -> plant.getPlantName().equalsIgnoreCase(name));
        System.out.println("Plant deleted successfully, if it existed.");
    }

    private static void searchPlant() {
        System.out.print("Enter Plant Name to search: ");
        String name = scanner.nextLine();
        List<Plant> foundPlants = user.searchPlants(name);
        if (foundPlants.isEmpty()) {
            System.out.println("No plants found.");
        } else {
            System.out.println("Found Plants:");
            for (Plant plant : foundPlants) {
                plant.displayPlant();
            }
        }
    }

    private static void viewAllPlants() {
        List<Plant> plants = user.getPlants();
        if (plants.isEmpty()) {
            System.out.println("No plants found.");
        } else {
            System.out.println("All Plants:");
            for (Plant plant : plants) {
                plant.displayPlant();
            }
        }
    }

    //I threw this option in there in case the User wanted to display all information about the user
    private static void viewUserInformation() {
        System.out.println("User Information:");
        System.out.println("First Name: " + user.getFirstname());
        System.out.println("Last Name: " + user.getLastname());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
    }
}
