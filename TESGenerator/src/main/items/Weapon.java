package main.items;

import java.util.function.Predicate;

import main.conditions.ConditionList;
import main.conditions.GenericCondition;
import main.enums.ItemType;
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
	
	private Weapon() {
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
	 * Requires weaponType and material to be set
	 */
	private void setName() {
		name = weaponType.toString() + " " + material.getName();
	}
		
	private void setMaterial(Predicate<Material> predicate) {
		material = setItemType(Material.values(), predicate, Material.class);
	}
	
	private void setWeaponType(Predicate<WeaponType> predicate) {
		weaponType = setItemType(WeaponType.values(), predicate, WeaponType.class);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
