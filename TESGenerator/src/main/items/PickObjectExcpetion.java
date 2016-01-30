package main.items;

public class PickObjectExcpetion extends Exception {

	private static final long serialVersionUID = 1L;

	public PickObjectExcpetion(String objectType) {
		System.out.println("Error while picking " + objectType);
	}
}
