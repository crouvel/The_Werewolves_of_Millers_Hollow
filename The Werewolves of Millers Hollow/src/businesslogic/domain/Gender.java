package businesslogic.domain;

/**
 * 
 */
public enum Gender {
    FEMALE("Female"),
    MALE("Male");

	private String name;
	
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
	 * 
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