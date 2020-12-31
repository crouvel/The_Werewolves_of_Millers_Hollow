/**
 * 
 */
package businesslogic.domain;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
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
	 * 
	 */
	private String name;

	/**
	 * 
	 * @param string
	 */
	Role(String string) {
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
