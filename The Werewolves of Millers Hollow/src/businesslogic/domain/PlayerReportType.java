/**
 * package businesslogic.domain
 */
package businesslogic.domain;

/**
 * 
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */
public enum PlayerReportType {
	INAPPROPRIATE_BEHAVIOR("INAPPROPRIATE BEHAVIOR"),
    DISOBEYING_RULES("DISOBEYING RULES"),
    PROFANITY("PROFANITY");

	/**
	 * 
	 */
	private String name;

	/**
	 * Constructor of Player Report Type
	 * @param string
	 */
	PlayerReportType(String string) {
		this.name = string;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
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