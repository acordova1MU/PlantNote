import java.util.*;

public class WaterReminder {
    Calendar lastWater = Calendar.getInstance();
    Calendar nextWater = Calendar.getInstance();
    int waterInterval;

    public void setFirstWater(Scanner sc){
        System.out.println("How many days ago did you water your plant?");
        int lastDay = sc.nextInt();
        sc.nextLine();
        lastWater.add(Calendar.DATE, lastDay * -1);
    }

    public void setInterval(Scanner sc){
        System.out.println("How often would you like to water your plant?");
        waterInterval = sc.nextInt();
        sc.nextLine();
    }

    public void setNextWater(){
        nextWater = (Calendar) lastWater.clone();
        nextWater.add(Calendar.DATE, waterInterval);
    }

    public void plantWatered(){
        lastWater = (Calendar) nextWater.clone();
        // could set next water?
    }

    public void displayReminder(){
        Calendar today = Calendar.getInstance();
        if (today.get(Calendar.YEAR) == nextWater.get(Calendar.YEAR) &&
            today.get(Calendar.MONTH) == nextWater.get(Calendar.MONTH) &&
            today.get(Calendar.DATE) == nextWater.get(Calendar.DATE)) {
            System.out.println("Time to water your plant!");
        } 
        else {
            System.out.println("Your plant needs to be watered on " +
                nextWater.get(Calendar.DATE) + "/" +
                (nextWater.get(Calendar.MONTH) + 1) + "/" + // Month is 0-based
                nextWater.get(Calendar.YEAR));
        }
    }
}