
public class TestingDemo {

	public static void main(String[] args) {
		Plant myPlant = new Plant("Alex", "Cactus", "Spikey cactus plant", "Potting soil and pea gravel", LightExposure.FULLSUN, Location.INDOOR);
		myPlant.displayPlant();
		WaterReminder water = new WaterReminder();
		myPlant.addReminder(water);
		//setFirstWater and SetInterval ???
		myPlant.displayReminders();
		myPlant.removeReminder(water);
		myPlant.displayReminders();
	}

}
