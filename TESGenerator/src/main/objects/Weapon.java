package main.objects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
	/*	Map<Integer, WeaponType> weaponTypes = new HashMap<Integer, WeaponType>();
		WeaponType wt;
		Set<Integer> probas = weaponTypes.keySet();
		int probaMax = Utils.sum(probas);
		int rand = Utils.seed.nextInt(probaMax);
		Iterator it = probas.iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, WeaponType> pair = (Map.Entry) it.next();
			if (rand < 10) {
				
			}
			it.remove();
		}*/
		return WeaponType.BATTLE_AXE;
	}
}
