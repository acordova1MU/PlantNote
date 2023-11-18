public enum LightExposure {
	FULLSUN, PARTSUN, PARTSHADE, FULLSHADE;
	
	public String toString() {
		switch(this) {
			case FULLSUN:
				return "Full Sun";
			case PARTSUN:
				return "Part Sun";
			case PARTSHADE:
				return "Part Shade";
			case FULLSHADE:
				return "Full Sahde";
			default:
				return "";
		}
	}
}
