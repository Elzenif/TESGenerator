package main.enums;

public enum Material implements ItemType {
	
	DRAGON_BONES("dragon bones", 1),
	IRON("iron"),
	STEEL("steel");

	private String name;
	private int proba;
	
	private Material(String name) {
		this.name = name;
		this.proba = 10;
	}
	
	private Material(String name, int proba) {
		this(name);
		this.proba = proba;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getProba() {
		return proba;
	}

}
