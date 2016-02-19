package main.enums;

public enum NbHands {
	
	ONE_HAND(1), 
	TWO_HANDS(2),
	DEFAULT(0);

	private int value;
	
	private NbHands(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public String toString() {
		return Integer.toString(value);
	}
}
