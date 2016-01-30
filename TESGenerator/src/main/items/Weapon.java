package main.items;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import main.enums.WeaponType;
import main.utils.Utils;

public class Weapon extends Item {
	
	private WeaponType type;
	
	public Weapon() {
		this.initialize();
	}
	
	public Weapon(int nbHands) {
		this.initialize(nbHands);
	}
	
	public WeaponType getType() {
		return type;
	}
	
	private void initialize() {
		try {
			type = this.pickRandomWeaponType();
		} catch (PickObjectExcpetion e) {
			e.printStackTrace();
		} finally {
			if (type == null)
				type = WeaponType.SWORD;
		}
		name = type.toString();
	}
	
	private void initialize(int nbHands) {
		try {
			type = this.pickRandomWeaponType(nbHands);
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
	private WeaponType pickRandomWeaponType() throws PickObjectExcpetion {
		WeaponType[] array = WeaponType.values();
		WeaponType wt = (WeaponType) super.pickRandomItemType(
				array,
				t -> true);
		if (wt == null)
			throw new PickObjectExcpetion(WeaponType.class.getName());
		else
			return wt;
	}
	
	/**
	 * Pick a random weapon type from the WeaponType enumeration
	 * @param nbHands the nbHands we want the weapon to be
	 * @return a random weapon of nbHands type
	 * @throws PickObjectExcpetion
	 */
	private WeaponType pickRandomWeaponType(int nbHands) throws PickObjectExcpetion {
		WeaponType[] array = WeaponType.values();
		Map<WeaponType, Integer> weaponTypes = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			WeaponType wt = array[i];
			if (wt.getNbHands() == nbHands)
				weaponTypes.put(wt, wt.getProba());
		}
		WeaponType wt = (WeaponType) super.pickRandomItemType(weaponTypes);
		if (wt == null)
			throw new PickObjectExcpetion(WeaponType.class.getName());
		else
			return wt;
	}
	
}
