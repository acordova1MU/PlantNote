import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static User user = new User("John", "Smith", "jsmith", "john@example.com");
    private static Scanner scanner = new Scanner(System.in);
    static Plant currentPlant = null;
    public static void main(String[] args) {
    	randomPlants();
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
    private static void randomPlants() {
    	Plant plant1 = new Plant("Alex", "Cactus", "Spikey cactus plant", "Potting soil and pea gravel", "Fullsun", "Indoor");
    	Plant plant2 = new Plant("Gaby", "Rose", "Pretty", "Potting soil", "Half-Sun", "Outdoor");
    	user.addPlant(plant1);
    	user.addPlant(plant2);
    }
    
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
        System.out.print("Enter Plant Location: ");
        String location = scanner.nextLine();
        System.out.print("Enter Plant Light Exposure: ");
        String light = scanner.nextLine();

        Plant plant = new Plant(name, type, description, soil, location, light);
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
            	System.out.println("Plant Number: " + foundPlants.indexOf(plant)); //Prints the index of current plant
                plant.displayPlant();
            }
            
            //Asks user if they'd like to select a plant
            System.out.print("Enter 'Y' if you would like to select a plant");
            char selectPlant = scanner.next().charAt(1);
            if (selectPlant == 'y' || selectPlant == 'Y') {
                System.out.print("Select Plant (Enter Plant Number): ");
                int plantSelection = scanner.nextInt();
                if (plantSelection >= 0 || plantSelection <= foundPlants.size()) {
                	currentPlant = foundPlants.get(plantSelection);
                	plantMenu();
                } else {
                	System.out.println("Invalid Selection");
                }
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
            	System.out.println("Plant Number: " + plants.indexOf(plant)); //Prints the index of current plant
                plant.displayPlant();
            }
            
            //Asks user if they'd like to select a plant
            System.out.print("Enter 'Y' if you would like to select a plant");
            char selectPlant = scanner.next().charAt(0);
            if (selectPlant == 'y' || selectPlant == 'Y') {
                System.out.print("Select Plant (Enter Plant Number): ");
                int plantSelection = scanner.nextInt();
                if (plantSelection >= 0 || plantSelection <= plants.size()) {
                	currentPlant = plants.get(plantSelection);
                	plantMenu();
                } else {
                	System.out.println("Invalid Selection");
                }
            }
        }
    }
    
    //Plant Menu
    private static void plantMenu() {
        boolean runningPlantMenu = true;
        while (runningPlantMenu) {
            printPlantMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addPlantReminder();
                    break;
                case 2:
                    deletePlantReminder(); 
                    break;
                case 3:
                    searchPlantReminders(); 
                    break;
                case 4:
                    viewAllPlantReminders(); 
                    break;
                case 0:
                    runningPlantMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void addPlantReminder() {
    	currentPlant.addReminder();
    }
    
    private static void deletePlantReminder() {
    	currentPlant.removeReminder(null);
    }
    
    private static void searchPlantReminders() {
    }
    
    private static void viewAllPlantReminders() {
    	currentPlant.displayReminders();
    }
    
    //Prints Plant Menu
    private static void printPlantMenu() {
        System.out.println("1. Add Reminder");
        System.out.println("2. Delete Reminder");
        System.out.println("3. Search Reminder");
        System.out.println("4. View all Reminders");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
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
