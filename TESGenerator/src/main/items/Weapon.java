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
	 * Requires weaponType to be set
	 */
	private void setName() {
		name = weaponType.toString();
	}
		
	private void setMaterial(Predicate<Material> predicate) {
		material = setItemType(Material.values(), predicate, Material.class);
	}
	
	private void setWeaponType(Predicate<WeaponType> predicate) {
		weaponType = setItemType(WeaponType.values(), predicate, WeaponType.class);
	}
	
	private <E extends Enum<E> & ItemType> E setItemType(
			E[] values, Predicate<E> predicate, Class<E> enumClass) {
		E itemType = null;
		try {
			itemType = pickRandomItemType(values, predicate, enumClass.getName());
		} catch (PickObjectException e) {
			e.printStackTrace();
		} finally {
			if (itemType == null)
				return ItemType.getDefault(enumClass);
		}
		return itemType;
	}
	
	/**
 	 * Pick a random itemType from the values array
	 * @param values The array containing the enum values from which we pick the item
	 * @param predicate The predicate that keep only some values to pick
	 * @param enumName The name of the Enum of the itemType
	 * @return a randomly picked itemType
	 * @throws PickObjectException
	 */
	private <E extends Enum<E> & ItemType> E pickRandomItemType(
			E[] values, Predicate<E> predicate, String enumName)
			throws PickObjectException {
		E itemType = pickRandomItemType(values, predicate);
		if (itemType == null)
			throw new PickObjectException(enumName);
		else
			return itemType;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + material.getName();
	}
}
