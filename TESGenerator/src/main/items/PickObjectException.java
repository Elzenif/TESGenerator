package main.items;

public class PickObjectException extends Exception {

	private static final long serialVersionUID = 1L;

	public PickObjectException(String objectType) {
		System.out.println("Error while picking " + objectType);
	}
}
