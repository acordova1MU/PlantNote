import java.util.Scanner;

public class DateExperiment {

    public class Date{
        private int day, month, year;

        // day setter function
        public void setDay(int inDay){
            this.day = inDay;
        }

        //day getter function
        public int getDay(){
            return day;
        }

        // month setter function
        public void setMonth(int inMonth){
            this.month = inMonth;
        }

        // month getter funciton
        public int getMonth(){
            return month;
        }

        // year setter function
        public void setYear(int inYear){
            this.year = inYear;
        }

        // year getter function
        public int getYear(){
            return year;
        }

        // set date from user input
        public void setDate(Scanner sc){
            System.out.println("mm/dd/yyyy");

            try{
                String date = sc.nextLine();
                String[] parts = date.split("/");

            // Check if the date format is correct
            if (parts.length != 3) {
                System.out.println("Invalid date format. Please use mm/dd/yyyy.");
                return;
            }

            int inMonth = Integer.parseInt(parts[0]);
            int inDay = Integer.parseInt(parts[1]);
            int inYear = Integer.parseInt(parts[2]);

            // Validate the year
            if (inYear < 1900 || inYear > 2100) {
                System.out.println("Invalid year. Please enter a year between 1900 and 2100.");
                return;
            }

            // Validate the month
            if (inMonth < 1 || inMonth > 12) {
                System.out.println("Invalid month. Please enter a month between 1 and 12.");
                return;
            }

            // Validate the day
            if (inDay < 1 || inDay > getDaysInMonth(inMonth, inYear)) {
                System.out.println("Invalid day. Please enter a valid day for the given month and year.");
                return;
            }

            // Setting the date
            setMonth(inMonth);
            setDay(inDay);
            setYear(inYear);

            } catch (NumberFormatException e) {
                System.out.println("Invalid date. Please ensure you are entering numbers.");
            }
        }

        //Can set dates not from input.
        public void setDate(int inMonth, int inDay, int inYear){
            setMonth(inMonth);
            setDay(inDay);
            setYear(inYear);
        }

        // Set dates equal to each other
        public void setDate(Date newDate){
            setMonth(newDate.getMonth());
            setDay(newDate.getDay());
            setYear(newDate.getYear());
        }

        public void printDate(){
            System.out.print(Integer.toString(this.getMonth()) + "/" + Integer.toString(this.getDay()) + "/" + Integer.toString(this.getYear()));
        }
        
        // used to validate day from user input
        public static int getDaysInMonth(int month, int year) {
            switch (month) {
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                case 2:
                    return (isLeapYear(year) ? 29 : 28);
                default:
                    return 31;
            }
        }

        // used to identify leap year to validate days from user input.
        public static boolean isLeapYear(int year) {
            return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
        }
    }
}