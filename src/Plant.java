import java.util.ArrayList;

public class Plant {
	private String plantName;
	private String plantType;
	private String plantDescription;
	private String plantSoil;
	private LightExposure plantLight;
	private Location plantLocation;
	private ArrayList<Object> plantReminders = new ArrayList();
	
	
	public Plant (String name, String type, String description, String soil, LightExposure light, Location location, ArrayList<Object> reminders) {
		this.plantName = name;
		this.plantType = type;
		this.plantDescription = description;
		this.plantSoil = soil;
		this.plantLight = light;
		this.plantLocation = location;
		this.plantReminders = reminders;
	}

	public ArrayList<Object> getPlantReminders() {
		return plantReminders;
	}

	public void setPlantReminders(ArrayList<Object> plantReminders) {
		this.plantReminders = plantReminders;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getPlantType() {
		return plantType;
	}

	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}

	public String getPlantDescription() {
		return plantDescription;
	}

	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	public String getPlantSoil() {
		return plantSoil;
	}

	public void setPlantSoil(String plantSoil) {
		this.plantSoil = plantSoil;
	}

	public LightExposure getPlantLight() {
		return plantLight;
	}

	public void setPlantLight(LightExposure plantLight) {
		this.plantLight = plantLight;
	}

	public Location getPlantLocation() {
		return plantLocation;
	}

	public void setPlantLocation(Location plantLocation) {
		this.plantLocation = plantLocation;
	}
	
	public void displayPlant() {
		System.out.println("Plant Name: " + plantName);
		System.out.println("Plant Type: " + plantType);
		System.out.println("Plant Description: " + plantDescription);
		System.out.println("Plant Soil: " + plantSoil);
		System.out.println("Plant Lighting: " + plantLight);
		System.out.println("Plant Location: " + plantLocation);
	}
	
	public void addReminder(Object reminder) {
		plantReminders.add(reminder);
	}
	
	public void removeReminder(Object reminder) {
		plantReminders.remove(reminder);
	}
}
