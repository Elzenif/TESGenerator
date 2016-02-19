package main.items;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

import main.enums.ItemType;
import main.utils.Utils;

public abstract class Item {

	protected String name;
	
	protected Item() {
		
	}
	
	public String getName() {
		return name;
	}

	/**
	 * Pick a random item from the array that fulfills the condition
	 * @param array From which we pick an item
	 * @param condition Condition on E
	 * @return An item from the array that fulfills the condition
	 */
	protected <E extends Enum<E> & ItemType> E pickRandomItemType(
			E[] array, Predicate<E> condition) {
		return this.pickRandomItemType(fillMap(array, condition));
	}
	
	private <E extends Enum<E> & ItemType> Map<E, Integer> fillMap(
			E[] array, Predicate<E> condition) {
		Map<E, Integer> types = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			E type = array[i];
			if (condition.test(type)) {
				types.put(type, type.getProba());
			}
		}
		return types;
	}
	
	private <E extends Enum<E> & ItemType> E pickRandomItemType(
			 Map<E, Integer> types) {
		int probaMax = Utils.sum(types.values());
		int rand = Utils.seed.nextInt(probaMax);
		Iterator<Entry<E, Integer>> it = types.entrySet().iterator();
		while (it.hasNext()) {	
			Map.Entry<E, Integer> pair = (Entry<E, Integer>) it.next();
			int proba = pair.getValue();
			if (rand < proba) {
				return pair.getKey();
			} else {
				rand -= proba;
			}
			it.remove();
		}
		return null;
	}
	
	protected <E extends Enum<E> & ItemType> E setItemType(
			E[] values, Predicate<E> predicate, Class<E> enumClass) {
		E itemType = null;
		try {
			itemType = pickRandomItemType(values, predicate, enumClass.getName());
		} catch (PickObjectException e) {
			e.printStackTrace();
		} finally {
			if (itemType == null)
				return ItemType.getDefault(enumClass);
		}
		return itemType;
	}
	
	/**
 	 * Pick a random itemType from the values array
	 * @param values The array containing the enum values from which we pick the item
	 * @param predicate The predicate that keep only some values to pick
	 * @param enumName The name of the Enum of the itemType
	 * @return a randomly picked itemType
	 * @throws PickObjectException
	 */
	protected <E extends Enum<E> & ItemType> E pickRandomItemType(
			E[] values, Predicate<E> predicate, String enumName)
			throws PickObjectException {
		E itemType = pickRandomItemType(values, predicate);
		if (itemType == null)
			throw new PickObjectException(enumName);
		else
			return itemType;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}
