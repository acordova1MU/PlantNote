import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Plant {
	private String plantName;
	private String plantType;
	private String plantDescription;
	private String plantSoil;
	private String plantLight;
	private String plantLocation;
	private ArrayList<Reminder> plantReminders = new ArrayList<Reminder>();
	
	
	public Plant (String name, String type, String description, String soil, String light, String location) {
		this.plantName = name;
		this.plantType = type;
		this.plantDescription = description;
		this.plantSoil = soil;
		this.plantLight = light;
		this.plantLocation = location;
	}

	public ArrayList<Reminder> getPlantReminders() {
		return plantReminders;
	}

	public void setPlantReminders(ArrayList<Reminder> plantReminders) {
		this.plantReminders = plantReminders;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getPlantType() {
		return plantType;
	}

	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}

	public String getPlantDescription() {
		return plantDescription;
	}

	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	public String getPlantSoil() {
		return plantSoil;
	}

	public void setPlantSoil(String plantSoil) {
		this.plantSoil = plantSoil;
	}

	public String getPlantLight() {
		return plantLight;
	}

	public void setPlantLight(String plantLight) {
		this.plantLight = plantLight;
	}

	public String getPlantLocation() {
		return plantLocation;
	}

	public void setPlantLocation(String plantLocation) {
		this.plantLocation = plantLocation;
	}
	
	public void displayPlant() {
		System.out.println("Plant Name: " + plantName);
		System.out.println("Plant Type: " + plantType);
		System.out.println("Plant Description: " + plantDescription);
		System.out.println("Plant Soil: " + plantSoil);
		System.out.println("Plant Lighting: " + plantLight);
		System.out.println("Plant Location: " + plantLocation);
	}
    
	public void addReminder() {
	        Scanner scanner = new Scanner(System.in);
	        Reminder userReminder = new Reminder();

	        int userIn = 0;
	        while (userIn < 1 || userIn > 3) {
	            System.out.println("What type of reminder would you like to create?\n1. Water\n2. Sunlight\n3. Soil Change\nPlease enter 1, 2, or 3:");
	            try {
	                userIn = scanner.nextInt();
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
	                scanner.next(); // Clear the buffer
	            }
	        }
	        
	        scanner.nextLine();
	        // Map user input to reminder type
	        switch (userIn) {
	            case 1:
	                userReminder.setType("Water");
	                break;
	            case 2:
	                userReminder.setType("Sunlight");
	                break;
	            case 3:
	                userReminder.setType("Soil Change");
	                break;
	        }
	        
	        
	        //Assign due date for reminder
	        System.out.println("When would you like to recieve this reminder?");
	        
	        
	        LocalDate newDate = null;
	        while (newDate == null) {
	            System.out.print("Enter new date (YYYY-MM-DD): ");
	            String dateInput = scanner.nextLine();
	            try {
	            	newDate = LocalDate.parse(dateInput);
	            	 } catch (DateTimeParseException e) {
	            		  System.out.println("Invalid date format. Please try again.");
	            	  }
	        }
	        
	        
	        userReminder.setDueDate(newDate);
	        //Assign interval for reminder
	        System.out.println("How often would you like to recieve these reminders? (in days?)");
	        try {
	                userIn = scanner.nextInt();
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter a number.");
	                scanner.next(); // Clear the buffer
	            }
	        userReminder.setIntervalDays(userIn);
	        
	        
	        // Ask user if they want to create a custom message for reminder.
	        String userResponse = "";
	        while (!userResponse.equals("y") && !userResponse.equals("n")) {
	            System.out.println("Would you like to create a custom message for your reminder? (y/n)");
	            userResponse = scanner.next().toLowerCase(); // Read the response and convert to lower case

	            if (!userResponse.equals("y") && !userResponse.equals("n")) {
	                System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
	            }
	        }

	        // Prompt for custom message if user entered 'y'
	        if (userResponse.equals("y")) {
	            System.out.println("Enter your custom message:");
	            String message = scanner.next();
	            userReminder.setMessage(message); // Read the custom message
	        }
	        
	        System.out.println("Reminder Created! :)");
	        scanner.close();
	        plantReminders.add(userReminder);
	}
	
	public void removeReminder(int i) {
		plantReminders.remove(plantReminders.get(i));
	}
	
	public void displayReminders() {
		if(plantReminders.size() == 0){  
			System.out.println("No reminders!!");
		} else {
	    for(int i = 0; i < plantReminders.size(); i++) {
	    	System.out.println("Reminder: " + i);
	        plantReminders.get(i).printReminder();
	      }
		}
	}
}
