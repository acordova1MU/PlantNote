import java.util.*;
import java.util.Scanner;

public class WaterReminderBeta{

    public Date lastWater = new Date();
    public int waterInterval;
    public Date nextWater = new Date();
    // Plant plant (or plantID)

    // Set the last date watered
    public void setLastWater(Scanner sc){
        System.out.println("When was the last time you watered your (plant)?");
        this.lastWater = lastWater.setDate(sc);
    }

    // Set water interval
    public void setInterval(Scanner sc){
        System.out.println("How often do you want to water your (plant) in days?");
        this.waterInterval = sc.nextInt();
    }

    // Sets next water date
    public void nextWater(Date lastWater, int waterInterval){
        int newDay;
        Date newDate = new Date().setDate(lastWater);
        newDay = waterInterval + lastWater.getDay();

        //Checks to see if new day is in current month
        if (newDay > lastWater.getDaysInMonth(lastWater.getMonth(), lastWater.getYear())){
            newDay = newDay - lastWater.getDaysInMonth(lastWater.getMonth(), lastWater.getYear());
            newDate.setDay(newDay);
            newDate.setMonth(newDate.getMonth() + 1);
            //Checks to see if new day is within current year
            if (newDate.getMonth() > 12){
                newDate.setMonth(1);
                newDate.setYear(newDate.getYear() + 1);
            }
        }
        //If new day is in current month set the new date to that day
        else{
            newDate.setDay(newDay);
        }
        // set next water to the date we got
        this.nextWater.setDate(newDate);
    }

    //displays next water date
    //I think we could potentially implement check to see if date matches todays date and then display a reminder if they are equal.
    public void displayReminder(Date nextWater){
        System.out.println("Your (plant) needs water on " + nextWater.printDate())
    }
}

