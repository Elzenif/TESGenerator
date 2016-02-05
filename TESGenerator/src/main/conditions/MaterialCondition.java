package main.conditions;

import java.util.function.Predicate;

import main.enums.Material;

public class MaterialCondition extends AbstractCondition {

	private Predicate<Material> condition;
	
	public MaterialCondition(Predicate<Material> condition) {
		this.condition = condition;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Predicate getCondition() {
		return condition;
	}

	@Override
	public ConditionID getConditionID() {
		return ConditionID.MATERIAL;
	}

}
