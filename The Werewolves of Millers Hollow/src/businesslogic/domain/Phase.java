package businesslogic.domain;

/**
 * 
 */
public enum Phase {
    SET_UP("SET UP"),
    DAY("DAY"),
    NIGHT("NIGHT");
    
	private String name;
	
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
	 * 
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