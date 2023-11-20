import java.util.*;

public class SunlightReminder {
    Calendar lastSunlight = Calendar.getInstance();
    Calendar nextSunlight = Calendar.getInstance();
    int sunlightInterval;

    public void setFirstSunlight(Scanner sc){
        System.out.println("How many days ago did your plant last receive sunlight?");
        int lastDay = sc.nextInt();
        sc.nextLine();
        lastSunlight.add(Calendar.DATE, -lastDay);
    }

    public void setInterval(Scanner sc){
        System.out.println("How often would you like your plant to receive sunlight? (in days)");
        sunlightInterval = sc.nextInt();
        sc.nextLine();
    }

    public void setNextSunlight(){
        nextSunlight = (Calendar) lastSunlight.clone(); // Cloning lastSunlight to maintain the original date
        nextSunlight.add(Calendar.DATE, sunlightInterval);
    }

    public void plantSunlighted(){
        lastSunlight = (Calendar) nextSunlight.clone(); // Cloning nextSunlight to maintain the original date
        // could set next sunlight?
    }

    public void displayReminder(){
        Calendar today = Calendar.getInstance();
        if (today.get(Calendar.YEAR) == nextSunlight.get(Calendar.YEAR) &&
            today.get(Calendar.MONTH) == nextSunlight.get(Calendar.MONTH) &&
            today.get(Calendar.DATE) == nextSunlight.get(Calendar.DATE)) {
            System.out.println("It's time to ensure your plant receives sunlight today!");
        } 
        else {
            System.out.println("Your plant needs to receive sunlight on " +
                nextSunlight.get(Calendar.DATE) + "/" +
                (nextSunlight.get(Calendar.MONTH) + 1) + "/" + // Month is 0-based
                nextSunlight.get(Calendar.YEAR));
        }
    }
}
