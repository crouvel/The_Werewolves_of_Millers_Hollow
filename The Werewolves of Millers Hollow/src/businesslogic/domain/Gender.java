package businesslogic.domain;

/**
 * @author Tiffany Dumaire
 */
public enum Gender {
	
    FEMALE("Female"),
    MALE("Male");

	private String name;
	
	/**
	 * Constructor
	 * @param string
	 */
	Gender(String string) {
		this.name = string;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return the gender
	 * @param string
	 * @return
	 */
	public static Gender get(String string) {
		if(string.equals(FEMALE.getName())) {
			return FEMALE;
		}else {
			return MALE;
		}
	}
}