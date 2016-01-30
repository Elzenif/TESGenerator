package main.objects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import main.enums.WeaponType;
import main.utils.Utils;

public class Weapon {
	
	private String name;
	private WeaponType type;
	
	public Weapon() {
		this.initialize();
	}
	
	public String getName() {
		return name;
	}

	public WeaponType getType() {
		return type;
	}
	
	private void initialize() {
		type = this.pickRandomWeaponType();
		name = type.toString();
	}
	
	/**
	 * Pick a random weapon type from the WeaponType enum
	 * @return a random WeaponType
	 */
	private WeaponType pickRandomWeaponType() {
		WeaponType[] array = WeaponType.values();
		Map<Integer, WeaponType> weaponTypes = new HashMap<Integer, WeaponType>();
		for (int i = 0; i < array.length; i++) {			
			weaponTypes.put(array[i].getProba(), array[i]);
		}
		int probaMax = Utils.sum(weaponTypes.keySet());
		int rand = Utils.seed.nextInt(probaMax);
		Iterator<Entry<Integer, WeaponType>> it = weaponTypes.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, WeaponType> pair = (Entry<Integer, WeaponType>) it.next();
			int proba = pair.getKey();
			if (rand < proba) {
				return pair.getValue();
			} else {
				rand -= proba;
			}
			it.remove();
		}
		return null;
	}
}
