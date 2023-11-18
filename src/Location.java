public enum Location {
	INDOOR, OUTDOOR;
	
	public String toString() {
		switch(this) {
			case INDOOR:
				return "Indoor";
			case OUTDOOR:
				return "Outdoor";
			default:
				return "";
		}
	}
}
