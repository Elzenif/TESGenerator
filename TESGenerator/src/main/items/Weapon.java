package main.items;

import java.util.function.Predicate;

import main.enums.WeaponType;

public class Weapon extends Item {
	
	private WeaponType type;
	
	public Weapon() {
		this.initialize(wt -> true);
	}
	
	public Weapon(int nbHands) {
		this.initialize(wt -> wt.getNbHands() == nbHands);
	}
	
	public WeaponType getType() {
		return type;
	}
	
	private void initialize(Predicate<WeaponType> condition) {
		try {
			type = this.pickRandomWeaponType(condition);
		} catch (PickObjectExcpetion e) {
			e.printStackTrace();
		} finally {
			if (type == null)
				type = WeaponType.SWORD;
		}
		name = type.toString();
	}
	
	/**
	 * Pick a random weapon type from the WeaponType enumeration
	 * @return a random WeaponType
	 * @throws PickObjectExcpetion
	 */
	private WeaponType pickRandomWeaponType(Predicate<WeaponType> condition)
			throws PickObjectExcpetion {
		WeaponType[] array = WeaponType.values();
		WeaponType wt = (WeaponType) super.pickRandomItemType(array, condition);
		if (wt == null)
			throw new PickObjectExcpetion(WeaponType.class.getName());
		else
			return wt;
	}	
}
