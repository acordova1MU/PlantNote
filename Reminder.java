import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reminder {
    private String type; // e.g., "Water", "Sun", "Soil"
    private LocalDate dueDate; // due date for the reminder
    private int intervalDays; // Interval in days for the reminder
    private String message = "default"; //message to be sent with reminder

    //Defauly constructor for creating new reminders
    public Reminder(){}

    // Constructor w/o message
    public Reminder(String type, LocalDate initialDueDate, int intervalDays) {
        this.type = type;
        this.dueDate = initialDueDate;
        this.intervalDays = intervalDays;
        setNextDueDate(); // Set the first due date based on the interval
    }

    //constructor w/ message
    public Reminder(String type, LocalDate initialDueDate, int intervalDays, String message) {
        this.type = type;
        this.dueDate = initialDueDate;
        this.intervalDays = intervalDays;
        this.message = message;
        setNextDueDate(); // Set the first due date based on the interval
    }

    // Automatically calculate and update the due date based on the interval
    public void setNextDueDate() {
        this.dueDate = LocalDate.now().plusDays(this.intervalDays);
    }

    // Method to update the interval
    public void updateInterval(int newIntervalDays) {
        this.intervalDays = newIntervalDays;
        setNextDueDate(); // Update the due date based on the new interval
    }

    // Getter and setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and setter for dueDate
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Getter and setter for intervalDays
    public int getIntervalDays() {
        return intervalDays;
    }

    public void setIntervalDays(int intervalDays) {
        this.intervalDays = intervalDays;
        setNextDueDate(); // Recalculate the next due date when interval is changed
    }

    // Getter and setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void printReminderDue(){
        System.out.println("Reminder Type: " + this.type);

        if (this.message == "default"){
            switch (this.type){
                case "Water":
                    System.out.println("It's time to water your plant!");
                    break;
                case "Soil":
                    System.out.println("It's time to change your plants soil");
                    break;
                case "Sun":
                    System.out.println("It's time to put your plant in the sun!");
                    break;
                default:
                    System.out.println("I was supposed to remind you of something...");
            }
        }
        else{
            System.out.println(message);
        }
    }

    public static LocalDate getNewDate() {
        Scanner scanner = new Scanner(System.in);
        LocalDate newDate = null;
        while (newDate == null) {
            System.out.print("Enter new date (YYYY-MM-DD): ");
            String dateInput = scanner.next();
            try {
                newDate = LocalDate.parse(dateInput);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
        scanner.close();
        return newDate;
    }

    public static Reminder createReminder(){
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
        userReminder.setDueDate(getNewDate());

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
            userReminder.setMessage(scanner.nextLine()); // Read the custom message
        }


        System.out.println("Reminder Created! :)");
        scanner.close();
        return userReminder;
    }

    //function to check to see if a reminder is due.
    public void checkReminder(Reminder reminder){

    }

}