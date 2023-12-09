import java.time.LocalDate;

public class TestingDemo {

	public static void main(String[] args) {
		Plant myPlant = new Plant("Alex", "Cactus", "Spikey cactus plant", "Potting soil and pea gravel", "Fullsun", "Indoor");
		myPlant.displayPlant();
		Reminder water = new Reminder("Water", LocalDate.now(), 5);
		myPlant.addReminder();
		//setFirstWater and SetInterval ???
		myPlant.displayReminders();
		myPlant.removeReminder(0);
		myPlant.displayReminders();
	}

}
