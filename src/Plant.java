import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Plant {
	private String plantName;
	private String plantType;
	private String plantDescription;
	private String plantSoil;
	private String plantLight;
	private String plantLocation;
	private ArrayList<Reminder> plantReminders = new ArrayList<Reminder>();
	
	
	public Plant (String name, String type, String description, String soil, String light, String location) {
		this.plantName = name;
		this.plantType = type;
		this.plantDescription = description;
		this.plantSoil = soil;
		this.plantLight = light;
		this.plantLocation = location;
	}

	public ArrayList<Reminder> getPlantReminders() {
		return plantReminders;
	}

	public void setPlantReminders(ArrayList<Reminder> plantReminders) {
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

	public String getPlantLight() {
		return plantLight;
	}

	public void setPlantLight(String plantLight) {
		this.plantLight = plantLight;
	}

	public String getPlantLocation() {
		return plantLocation;
	}

	public void setPlantLocation(String plantLocation) {
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
    
	public void addReminder(Reminder reminder) {
	        plantReminders.add(reminder);
	}
	
	public void removeReminder(int i) {
		plantReminders.remove(plantReminders.get(i));
	}
	
	public void displayReminders() {
		if(plantReminders.size() == 0){  
			System.out.println("No reminders!!");
		} else {
	    for(int i = 0; i < plantReminders.size(); i++) {
	    	System.out.println("Reminder: " + i);
	        plantReminders.get(i).printReminder();
	      }
		}
	}
}
