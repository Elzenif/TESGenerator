package main.conditions;

import java.util.function.Predicate;

public abstract class AbstractCondition {

	@SuppressWarnings("rawtypes")
	public abstract Predicate getCondition();
	
	public abstract ConditionID getConditionID();
}
