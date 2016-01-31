package main.items;

import java.util.function.Predicate;

import main.enums.Material;
import main.enums.WeaponType;

public class Weapon extends Item {
	
	private WeaponType weaponType;
	private Material material;
	
	public Weapon() {
		super();
		this.initialize(wt -> true, m -> true);
	}
	
	public Weapon(int nbHands) {
		super();
		this.initialize(
				wt -> wt.getNbHands() == nbHands, 
				m -> true);
	}
	/*
	public Weapon(int material) {
		this.initialize(
				wt -> true, 
				m -> true);
	}*/
	
	public Material getMaterial() {
		return material;
	}
	
	public WeaponType getType() {
		return weaponType;
	}
	
	private void initialize(Predicate<WeaponType> weaponTypeCondition, 
			Predicate<Material> materialCondition) {
		setType(weaponTypeCondition);
		setMaterial(materialCondition);
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
	
	private void setMaterial(Predicate<Material> condition) {
		try {
			material = pickRandomMaterialType(condition);
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
	
	private void setType(Predicate<WeaponType> condition) {
		try {
			weaponType = pickRandomWeaponType(condition);
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
