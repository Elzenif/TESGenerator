package main.items;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import main.enums.WeaponType;
import main.utils.Utils;

public class Weapon {
	
	private String name;
	private WeaponType type;
	
	public Weapon() {
		this.initialize();
	}
	
	public Weapon(int nbHands) {
		this.initialize(nbHands);
	}
	
	public String getName() {
		return name;
	}

	public WeaponType getType() {
		return type;
	}
	
	private void initialize() {
		try {
			type = this.pickRandomWeaponType();
		} catch (PickObjectExcpetion e) {
		
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
		Map<WeaponType, Integer> weaponTypes = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			WeaponType wt = array[i];
			weaponTypes.put(wt, wt.getProba());
		}
		int probaMax = Utils.sum(weaponTypes.values());
		int rand = Utils.seed.nextInt(probaMax);
		Iterator<Entry<WeaponType, Integer>> it = weaponTypes.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<WeaponType, Integer> pair = (Entry<WeaponType, Integer>) it.next();
			int proba = pair.getValue();
			if (rand < proba) {
				return pair.getKey();
			} else {
				rand -= proba;
			}
			it.remove();
		}
		throw new PickObjectExcpetion("WeaponType");
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
		int probaMax = Utils.sum(weaponTypes.values());
		int rand = Utils.seed.nextInt(probaMax);
		Iterator<Entry<WeaponType, Integer>> it = weaponTypes.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<WeaponType, Integer> pair = (Entry<WeaponType, Integer>) it.next();
			int proba = pair.getValue();
			if (rand < proba) {
				return pair.getKey();
			} else {
				rand -= proba;
			}
			it.remove();
		}
		throw new PickObjectExcpetion("WeaponType");
	}
	
}
