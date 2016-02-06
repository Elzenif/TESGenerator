package main.conditions;

import java.util.function.Predicate;

import main.enums.ItemType;

public abstract class AbstractCondition {

	@SuppressWarnings("rawtypes")
	public abstract Predicate getPredicate();
		
	public abstract <E extends Enum<E> & ItemType> Class<E> getPredicateType();
}
