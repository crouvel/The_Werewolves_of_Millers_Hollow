package businesslogic.domain;

/**
 * @author Tiffany Dumaire
 */
public enum Phase {
    SET_UP("SET UP"),
    DAY("DAY"),
    NIGHT("NIGHT");
    
	private String name;
	
	/**
	 * Constructor of Phase
	 * @param string
	 */
	Phase(String string) {
		this.name = string;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Phase getter
	 * @param string
	 * @return 
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