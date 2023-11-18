public class Plant {
	private String plantName;
	private String plantType;
	private String plantDescription;
	private String plantSoil;
	private LightExposure plantLight;
	private Location plantLocation;
	
	public Plant (String name, String type, String description, String soil, LightExposure light, Location location) {
		this.plantName = name;
		this.plantType = type;
		this.plantDescription = description;
		this.plantSoil = soil;
		this.plantLight = light;
		this.plantLocation = location;
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
	
	
}
