import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
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
            System.out.println();
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
    
    //This method adds some plants to user without me having to go through user interface every time, just makes it easier to test functionality
    private static void randomPlants() {
    	Plant plant1 = new Plant("Alex", "Cactus", "Spikey cactus plant", "Potting soil and pea gravel", "Full-Sun", "Indoor");
    	Plant plant2 = new Plant("Gaby", "Rose", "Pretty", "Potting soil", "Half-Sun", "Outdoor");
    	user.addPlant(plant1);
    	user.addPlant(plant2);
    }
    
    private static void printMenu() {
        System.out.println("\n" + user.getFirstname() + " " + user.getLastname() + "'s User Menu");
        System.out.println();
        System.out.println("1. Add Plant");
        System.out.println("2. Delete Plant");
        System.out.println("3. Search Plant");
        System.out.println("4. View ALL Plants");
        System.out.println("5. View User Information");
        System.out.println("0. Exit");
        System.out.println();
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
            System.out.println("Enter 'Y' if you would like to select a plant");
            char selectPlant = scanner.next().charAt(0);
            if (selectPlant == 'y' || selectPlant == 'Y') {
                System.out.print("Select Plant (Enter Plant Number): ");
                int plantSelection = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
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
            System.out.println();
            for (Plant plant : plants) {
            	System.out.println("Plant Number: " + plants.indexOf(plant)); //Prints the index of current plant
                plant.displayPlant();
                System.out.println();
            }
            
            //Asks user if they'd like to select a plant
            System.out.print("Enter 'Y' if you would like to select a plant: ");
            char selectPlant = scanner.next().charAt(0);
            System.out.println();
            if (selectPlant == 'y' || selectPlant == 'Y') {
                System.out.print("Select Plant (Enter Plant Number): ");
                int plantSelection = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
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
        int choice;
        while (runningPlantMenu) {
            printPlantMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (choice) {
                case 1:
                    addPlantReminder();
                    break;
                case 2:
                    deletePlantReminder(); 
                    break;
                case 3:
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
        String uType; 
        LocalDate uDueDate; 
        int uInterval; 
        String uMessage;

        int userIn = 0;
        while (userIn < 1 || userIn > 3) {
            System.out.print("What type of reminder would you like to create?\n1. Water\n2. Sunlight\n3. Soil Change\nPlease enter 1, 2, or 3:");
            try {
                userIn = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                scanner.nextLine(); // Clear the buffer
            }
        }
        System.out.println();
        // Map user input to reminder type
        switch (userIn) {
            case 1:
                uType = "Water";
                break;
            case 2:
                uType = "Sunlight";
                break;
            case 3:
                uType = "Soil Change";
                break;
            default:
                uType = "N/A";
                break;
        }
        
        
        //Assign due date for reminder
        System.out.println("When would you like to recieve this reminder?");
        
        
        LocalDate newDate = null;
        while (newDate == null) {
            System.out.print("Enter new date (YYYY-MM-DD): ");
            String dateInput = scanner.nextLine();
            System.out.println();
            try {
            	newDate = LocalDate.parse(dateInput);
            	 } catch (DateTimeParseException e) {
            		  System.out.println("Invalid date format. Please try again.");
                      System.out.println();
            	  }
        }
        
        uDueDate = newDate;

        //Assign interval for reminder
        System.out.print("How often would you like to recieve these reminders? (in days): ");
        try {
                userIn = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the buffer
                System.out.println();
            }
        uInterval = userIn;
        
        // Ask user if they want to create a custom message for reminder.
        String userResponse = "";
        while (!userResponse.equals("y") && !userResponse.equals("n")) {
            System.out.print("Would you like to create a custom message for your reminder? (y/n): ");
            userResponse = scanner.next().toLowerCase(); // Read the response and convert to lower case
            scanner.nextLine();
            System.out.println();
            if (!userResponse.equals("y") && !userResponse.equals("n")) {
                System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
                System.out.println();
            }
        }

        // Prompt for custom message if user entered 'y'
        if (userResponse.equals("y")) {
            System.out.print("Enter your custom message:");
            uMessage = scanner.nextLine();
        } else {
            uMessage = "";
        }
        System.out.println();
        
        Reminder userReminder = new Reminder(uType, uDueDate, uInterval, uMessage);
        userReminder.setMessage(userReminder.getMessage());

        System.out.println("Reminder Created! :)");
        System.out.println();
        currentPlant.addReminder(userReminder);
    }
    
    private static void deletePlantReminder() {
    	currentPlant.displayReminders();
    	System.out.print("Enter the reminder number for the reminder you'd like to delete: ");
    	int reminderSelection = scanner.nextInt();
    	scanner.nextLine();
        System.out.println();
        if (reminderSelection >= 0 || reminderSelection <= currentPlant.getPlantReminders().size()) {
        	currentPlant.removeReminder(reminderSelection);
            System.out.println("Reminder Deleted!");
        } else {
        	System.out.println("Invalid Selection");
        }
        System.out.println();
    }
    
    private static void viewAllPlantReminders() {
        List<Reminder> sortedReminders = currentPlant.getSortedReminders();
        if (sortedReminders.isEmpty()) {
            System.out.println("No reminders found.");
        } else {
            System.out.println("Plant Reminders:");
            System.out.println();
            for (Reminder reminder : sortedReminders) {
                reminder.checkReminder();;
                System.out.println();
            }
        }
    }
    
    //Prints Plant Menu
    private static void printPlantMenu() {
        System.out.println("Plant Menu:");
        System.out.println("1. Add Reminder");
        System.out.println("2. Delete Reminder");
        System.out.println("3. View all Reminders");
        System.out.println("0. Exit");
        System.out.println();
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
