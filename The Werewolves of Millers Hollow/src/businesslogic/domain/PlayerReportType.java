/**
 * package businesslogic.domain
 */
package businesslogic.domain;

/**
 * 
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 *
 */
public enum PlayerReportType {
	INAPPROPRIATE_BEHAVIOR("INAPPROPRIATE BEHAVIOR"),
    DISOBEYING_RULES("DISOBEYING RULES"),
    PROFANITY("PROFANITY");

	/**
	 * Attributes that defines the name of the player report type.
	 */
	private String name;

	/**
	 * Constructor
	 * @param string
	 */
	PlayerReportType(String string) {
		this.name = string;
	}

	/**
	 * @return the PlayerReport type name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the PlayerReportType
	 * @param string
	 * @return
	 */
	public static PlayerReportType get(String string) {
		if(string.equals(INAPPROPRIATE_BEHAVIOR.getName())) {
			return INAPPROPRIATE_BEHAVIOR;
		}else {
			if(string.equals(DISOBEYING_RULES.getName())) {
				return DISOBEYING_RULES;
			}else {
				return PROFANITY;
			}
		}
	}
}