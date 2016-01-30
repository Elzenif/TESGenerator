package main.objects;

import main.enums.WeaponType;

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
		name = "sword";
		type = WeaponType.SWORD;
	}
}
