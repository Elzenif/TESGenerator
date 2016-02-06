package test.conditions;

import static org.junit.Assert.*;
import main.conditions.GenericCondition;
import main.enums.WeaponType;

import org.junit.Test;

public class GenericConditionTest {

	@Test
	public void testGetConditionIsNotNull() {
		GenericCondition<WeaponType> condition = 
				new GenericCondition<WeaponType>(WeaponType.class);
		assertNotNull("The condition predicate should not be null", 
				condition.getPredicate());
	}

}
