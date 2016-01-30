package main.enums;

public enum WeaponType {
	
	BATTLE_AXE("battle axe", 2),
	BOW("bow", 2),
	CLAYMORE("claymore", 2),
	CUTLASS("cutlass", 1),
	DAGGER("dagger", 1),
	KATANA("katana", 1),
	MACE("mace", 1),
	STAFF("staff", 1),
	SWORD("sword", 1),
	WAR_AXE("war axe", 1),
	WARHAMMER("warhammer", 2);

	private String name;
	private int nbHands;
	
	private WeaponType(String name, int nbHands) {
		this.name = name;
		this.nbHands = nbHands;
	}
	
	public String getName() {
		return name;
	}

	public int getNbHands() {
		return nbHands;
	}

	public String toString() {
		return name + " (" + nbHands + " hand(s))";
	}
}
