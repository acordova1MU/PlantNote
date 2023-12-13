import java.time.LocalDate;

public class Reminder {
    private String type; // e.g., "Water", "Sun", "Soil"
    private LocalDate dueDate; // due date for the reminder
    private int intervalDays; // Interval in days for the reminder
    private String message = ""; //message to be sent with reminder

    //constructor
    public Reminder(String type, LocalDate initialDueDate, int intervalDays, String message) {
        this.type = type;
        this.dueDate = initialDueDate;
        this.intervalDays = intervalDays;
        this.message = message;
    }

    // Automatically calculate and update the due date based on the interval
    public void setNextDueDate() {
        this.dueDate = this.dueDate.plusDays(this.intervalDays);
    }

    // Method to update the interval
    public void updateInterval(int newIntervalDays) {
        this.intervalDays = newIntervalDays;
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
        if (message.isEmpty()) {
            // These will be the default messages if the user opts out of creating a custom message
            switch (this.type) {
                case "Water":
                    this.message = "It's time to water your plant!";
                    break;
                case "Soil":
                    this.message = "It's time to change your plant's soil";
                    break;
                case "Sun":
                    this.message = "It's time to put your plant in the sun!";
                    break;
                default:
                    this.message = "Reminder set.";
            }
        } else {
            // Set custom message
            this.message = message;
        }
    }
    
    public void printReminderDue() {
        System.out.println("Reminder Type: " + this.type);
        System.out.println(this.message); // Print the message (default or custom)
    }
    
    public void printReminder() {
    	System.out.println("Reminder Type: " + this.getType());
    	System.out.println("Due Date (YYYY-MM-DD): " + this.getDueDate());
    	System.out.println("Reminder Frequency: " + this.getIntervalDays() + " Days");
    	System.out.println("Message: " + this.getMessage());
    }

    //function to check to see if a reminder is due.
    public void checkReminder(){
        LocalDate today = LocalDate.now();
        boolean remDue = false;

        // Check if the reminder's due date is today or in the past
        if (!getDueDate().isAfter(today) || getDueDate().equals(today)){
            remDue = true;
        }

        if (remDue == true) {
            System.out.println("REMINDER DUE!");
            printReminderDue();
            System.out.println("Old reminder due date (YYYY-MM-DD): " + getDueDate());
            setNextDueDate();
            System.out.println("New reminder due date (YYYY-MM-DD): " + getDueDate());
        }
        else{
            printReminder();
        }
        
        return;
    }
}