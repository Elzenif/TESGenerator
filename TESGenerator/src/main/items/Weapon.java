package main.items;

import java.util.function.Predicate;

import main.conditions.ConditionList;
import main.conditions.GenericCondition;
import main.enums.Material;
import main.enums.WeaponType;

public class Weapon extends Item {
	
	private WeaponType weaponType;
	private Material material;
	
	public static Weapon createWeaponWithoutConstraints() {
		Weapon weapon = new Weapon();
		ConditionList conditionList = new ConditionList();
		conditionList.add(new GenericCondition<WeaponType>(WeaponType.class));
		conditionList.add(new GenericCondition<Material>(Material.class));
		weapon.initialize(conditionList);
		return weapon;
	}
	
	public static Weapon createWeaponWithXHands(int nbHands) {
		Weapon weapon = new Weapon();
		ConditionList conditionList = new ConditionList();
		conditionList.add(new GenericCondition<WeaponType>(WeaponType.class,
				wt -> wt.getNbHands() == nbHands));
		conditionList.add(new GenericCondition<Material>(Material.class));
		weapon.initialize(conditionList);
		return weapon;
	}
	
	protected Weapon() {
		super();
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public WeaponType getType() {
		return weaponType;
	}
	
	@SuppressWarnings("unchecked")
	private void initialize(ConditionList conditionList) {
		setWeaponType(conditionList.remove(WeaponType.class).getPredicate());
		setMaterial(conditionList.remove(Material.class).getPredicate());
		setName();
	}
	
	/**
	 * Pick a random weapon type from the WeaponType enumeration
	 * @return a random WeaponType
	 * @throws PickObjectExcpetion
	 */
	private WeaponType pickRandomWeaponType(Predicate<WeaponType> condition)
			throws PickObjectExcpetion {
		WeaponType wt = (WeaponType) pickRandomItemType(WeaponType.values(), condition);
		if (wt == null)
			throw new PickObjectExcpetion(WeaponType.class.getName());
		else
			return wt;
	}
	
	private Material pickRandomMaterialType(Predicate<Material> condition) 
			throws PickObjectExcpetion {
		Material m = (Material) pickRandomItemType(Material.values(), condition);
		if (m == null) 
			throw new PickObjectExcpetion(Material.class.getName());
		else
			return m;			
	}
	
	private void setMaterial(Predicate<Material> predicate) {
		try {
			material = pickRandomMaterialType(predicate);
		} catch (PickObjectExcpetion e) {
			e.printStackTrace();
		} finally {
			if (material == null) 
				material = Material.IRON;
		}
	}
	
	/**
	 * Requires weaponType to be set
	 */
	private void setName() {
		name = weaponType.toString();
	}
	
	private void setWeaponType(Predicate<WeaponType> predicate) {
		try {
			weaponType = pickRandomWeaponType(predicate);
		} catch (PickObjectExcpetion e) {
			e.printStackTrace();
		} finally {
			if (weaponType == null)
				weaponType = WeaponType.SWORD;
		}		
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + material.getName();
	}
}
