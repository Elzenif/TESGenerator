package main.conditions;

import java.util.function.Predicate;

import main.enums.WeaponType;

public class WeaponTypeCondition extends AbstractCondition {
	
	private Predicate<WeaponType> condition;
	
	public WeaponTypeCondition(Predicate<WeaponType> condition) {
		this.condition = condition;
	}

	@Override
	public Predicate getCondition() {
		return condition;
	}

	@Override
	public ConditionID getConditionID() {
		return ConditionID.WEAPON_TYPE;
	}

}
