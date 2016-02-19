package main.conditions;

import java.util.function.Predicate;

import main.enums.ItemType;

public abstract class AbstractCondition {

	public abstract <E extends Enum<E> & ItemType> Predicate<E> getPredicate();
		
	public abstract <E extends Enum<E> & ItemType> Class<E> getPredicateType();
}
