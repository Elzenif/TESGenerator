package main.enums;

public enum WeaponType implements ItemType {
	
	BATTLE_AXE("battle axe", NbHands.TWO_HANDS),
	BOW("bow", NbHands.TWO_HANDS),
	CLAYMORE("claymore", NbHands.TWO_HANDS),
	CUTLASS("cutlass", NbHands.ONE_HAND),
	DAGGER("dagger", NbHands.ONE_HAND),
	KATANA("katana", NbHands.ONE_HAND),
	MACE("mace", NbHands.ONE_HAND),
	STAFF("staff", NbHands.TWO_HANDS),
	SWORD("sword", NbHands.ONE_HAND),
	WAR_AXE("war axe", NbHands.ONE_HAND),
	WARHAMMER("warhammer", NbHands.TWO_HANDS),
	DEFAULT("default", NbHands.DEFAULT, 0);
	
	private String name;
	private NbHands nbHands;
	private int proba;
	
	private WeaponType(String name) {
		this.name = name;
	}
	
	private WeaponType(String name, NbHands nbHands) {
		this(name);
		this.nbHands = nbHands;
		this.proba = 10;
	}
	
	private WeaponType(String name, NbHands nbHands, int proba) {
		this(name, nbHands);
		this.proba = proba;
	}
	
	public String getName() {
		return name;
	}

	public int getNbHands() {
		return nbHands.getValue();
	}
	
	public int getProba() {
		return proba;
	}

	public String toString() {
		String pluralFrom = "";
		if (nbHands == NbHands.TWO_HANDS)
			pluralFrom = "s";
		return name + " (" + nbHands + " hand" + pluralFrom + ")";
	}
}
