package main.factories;

import main.items.Item;
import main.items.Weapon;

public class ItemFactory {

	public Item createItem(String itemID) {
		
		return new Weapon();
	}

}
