package main.enums;

public interface ItemType {

	public String getName();
	
	public int getProba();
	
	public static <E extends Enum<E> & ItemType> E getDefault(Class<E> enumClass) {
		return (E) Enum.valueOf(enumClass, "DEFAULT");
	}
}
