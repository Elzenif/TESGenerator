package main.enums;

public enum WeaponType {
	
	BATTLE_AXE("battle axe", 2),
	BOW("bow", 2),
	CLAYMORE("claymore", 2),
	CUTLASS("cutlass", 1),
	DAGGER("dagger", 1),
	KATANA("katana", 1),
	MACE("mace", 1),
	STAFF("staff", 2),
	SWORD("sword", 1),
	WAR_AXE("war axe", 1),
	WARHAMMER("warhammer", 2);
	
	private String name;
	private int nbHands;
	private int proba;
	
	private WeaponType(String name, int nbHands) {
		this.name = name;
		this.nbHands = nbHands;
		this.proba = 10;
	}
	
	private WeaponType(String name, int nbHands, int proba) {
		this(name, nbHands);
		this.proba = proba;
	}
	
	public String getName() {
		return name;
	}

	public int getNbHands() {
		return nbHands;
	}
	
	public int getProba() {
		return proba;
	}

	public String toString() {
		return name + " (" + nbHands + " hand(s))";
	}
}
