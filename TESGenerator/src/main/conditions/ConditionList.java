package main.conditions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import main.enums.ItemType;

public class ConditionList {

	private Collection<AbstractCondition> list;
	
	public ConditionList() {
		this.list = new HashSet<AbstractCondition>();
	}
	
	public int size() {
		return list.size();
	}
	
	public void add(AbstractCondition condition) {
		list.add(condition);
	}
	
	public boolean contains(AbstractCondition condition) {
		return list.contains(condition);
	}
	
	public <E extends Enum<E> & ItemType> AbstractCondition remove(Class<E> type) {
		Iterator<AbstractCondition> it = list.iterator();
		while (it.hasNext()) {
			AbstractCondition currentCondition = it.next();
			if (currentCondition.getPredicateType() == type) {
				list.remove(currentCondition);
				return currentCondition;
			}
		}
		return null;
	}
}
