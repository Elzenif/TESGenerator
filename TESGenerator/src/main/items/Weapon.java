package main.items;

import java.util.function.Predicate;

import main.enums.WeaponType;

public class Weapon extends Item {
	
	private WeaponType weaponType;
	
	public Weapon() {
		this.initialize(wt -> true);
	}
	
	public Weapon(int nbHands) {
		this.initialize(wt -> wt.getNbHands() == nbHands);
	}
	
	public WeaponType getType() {
		return weaponType;
	}
	
	private void initialize(Predicate<WeaponType> condition) {
		setType(condition);
		setName();
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
	
	/**
	 * Requires weaponType to be set
	 */
	private void setName() {
		name = weaponType.toString();
	}
	
	private void setType(Predicate<WeaponType> condition) {
		try {
			weaponType = this.pickRandomWeaponType(condition);
		} catch (PickObjectExcpetion e) {
			e.printStackTrace();
		} finally {
			if (weaponType == null)
				weaponType = WeaponType.SWORD;
		}		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
