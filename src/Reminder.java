import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reminder {
    private String type; // e.g., "Water", "Sun", "Soil"
    private LocalDate dueDate; // due date for the reminder
    private int intervalDays; // Interval in days for the reminder
    private String message = ""; //message to be sent with reminder

    //Default constructor for creating new reminders
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
    
    public void printReminder() {
    	System.out.println("Reminder Type: " + this.getType());
    	System.out.println("Due Date: " + this.getDueDate());
    	System.out.println("Intervals : " + this.getIntervalDays());
    	System.out.println("Message: " + this.getMessage());
    }

    //function to check to see if a reminder is due.
    public void checkReminder(Reminder reminder){

    }

}