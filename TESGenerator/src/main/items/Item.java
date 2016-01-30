package main.items;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import main.enums.ItemType;
import main.utils.Utils;

public class Item {

	protected String name;

	public String getName() {
		return name;
	}

	protected <E extends Enum<E> & ItemType> Object pickRandomItemType(E[] array) {
		Map<E, Integer> types = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			E type = array[i];
			Integer proba = 0;
			proba = (Integer) type.getProba();
			types.put(type, proba);
		}
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
}
