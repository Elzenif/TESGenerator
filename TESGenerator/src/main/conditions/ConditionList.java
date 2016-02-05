package main.conditions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConditionList {

	private Set<AbstractCondition> list;
	
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

	public AbstractCondition remove(ConditionID conditionID) {
		Iterator<AbstractCondition> it = list.iterator();
		while (it.hasNext()) {
			AbstractCondition currentCondition = it.next();
			if (currentCondition.getConditionID() == conditionID) {
				list.remove(currentCondition);
				return currentCondition;
			}
		}
		return null;
	}
}
