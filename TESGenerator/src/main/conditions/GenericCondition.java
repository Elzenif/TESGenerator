package main.conditions;

import java.util.function.Predicate;

import main.enums.ItemType;

public class GenericCondition<E extends Enum<E> & ItemType> extends AbstractCondition{
	
	private final Class<E> type;
	private Predicate<E> predicate;

	public GenericCondition(Class<E> type) {
		this.type = type;
		this.predicate = p -> true;
	}
	
	public GenericCondition(Class<E> type, Predicate<E> predicate) {
		this(type);
		this.predicate = predicate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Predicate<E> getPredicate() {
		return predicate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<E> getPredicateType() {
		return type;
	}	
}
