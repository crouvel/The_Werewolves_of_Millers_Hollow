package businesslogic.domain;

/**
 * Phase enumeration.
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public enum Phase {
    SET_UP("SET UP"),
    DAY("DAY"),
    NIGHT("NIGHT");
    
	/**
	 * Attribute that defines the name of the Phase
	 */
	private String name;
	
	Phase(String string) {
		this.name = string;
	}

	/**
	 * @return the name of the Phase.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param string
	 * @return the Phase 
	 */
	public static Phase get(String string) {
		if(string.equals(SET_UP.getName())) {
			return SET_UP;
		}else {
			if(string.equals(DAY.getName())) {
				return DAY;
			}else {
				return NIGHT;
			}
		}
	}
}