import java.util.*;

public class SoilReminder {

    Calendar lastSoil = Calendar.getInstance();
    Calendar nextSoil = Calendar.getInstance();
    int soilInterval;

    public void setFirstSoil(Scanner sc){
        System.out.println("How many days ago did you change the soil of your plant?");
        int lastDay = sc.nextInt();
        sc.nextLine();
        lastSoil.add(Calendar.DATE, -lastDay);
    }

    public void setInterval(Scanner sc){
        System.out.println("How often would you like to change the soil of your plant?");
        soilInterval = sc.nextInt();
        sc.nextLine();
    }

    public void setNextSoil(){
        nextSoil = (Calendar) lastSoil.clone(); // Cloning lastSoil to maintain the original date
        nextSoil.add(Calendar.DATE, soilInterval);
    }

    public void plantSoiled(){
        lastSoil = (Calendar) nextSoil.clone(); // Cloning nextSoil to maintain the original date
        // could set next soil?
    }

    public void displayReminder(){
        Calendar today = Calendar.getInstance();
        if (today.get(Calendar.YEAR) == nextSoil.get(Calendar.YEAR) &&
            today.get(Calendar.MONTH) == nextSoil.get(Calendar.MONTH) &&
            today.get(Calendar.DATE) == nextSoil.get(Calendar.DATE)) {
            System.out.println("Time to change the soil of your plant!");
        } 
        else {
            System.out.println("Your plant needs its soil changed on " +
                nextSoil.get(Calendar.DATE) + "/" +
                (nextSoil.get(Calendar.MONTH) + 1) + "/" + // Month is 0-based
                nextSoil.get(Calendar.YEAR));
        }
    }
}
