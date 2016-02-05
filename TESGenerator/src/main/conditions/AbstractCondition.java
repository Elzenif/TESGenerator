package main.conditions;

import java.util.function.Predicate;

public abstract class AbstractCondition {

	public abstract Predicate getCondition();
	
	public abstract ConditionID getConditionID();
}
