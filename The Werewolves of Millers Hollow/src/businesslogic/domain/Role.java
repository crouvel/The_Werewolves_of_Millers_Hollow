/**
 * package businesslogic.domain
 */
package businesslogic.domain;

/**
 * Role enumeration.
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 *
 */
public enum Role {
	WEREWOLF("Werewolf"),
	LITTLE_GIRL("Little Girl"),
	HUNTER("Hunter"),
	WITCH("Witch"),
	FORTUNE_TELLER("Fortune Teller"),
	CUPID("Cupid"),
	VILLAGER("Villager");

	/**
	 * Attribute that defines the role name.
	 */
	private String name;

	/**
	 * Constructor
	 * @param string
	 */
	Role(String string) {
		this.name = string;
	}

	/**
	 * @return the name of the Role
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the Role
	 * @param string
	 * @return the Role
	 */
	public static Role get(String string) {
		if(string.equals(WEREWOLF.getName())) {
			return WEREWOLF;
		}else {
			if(string.equals(HUNTER.getName())) {
				return HUNTER;
			}else {
				if(string.equals(LITTLE_GIRL.getName())) {
					return LITTLE_GIRL;
				}else {
					if(string.equals(WITCH.getName())) {
						return WITCH;
					}else {
						if(string.equals(FORTUNE_TELLER.getName())) {
							return FORTUNE_TELLER;
						}else {
							if(string.equals(CUPID.getName())) {
								return CUPID;
							}else {
								return VILLAGER;
							}
						}
					}
				}
			}
		}
	}
}
