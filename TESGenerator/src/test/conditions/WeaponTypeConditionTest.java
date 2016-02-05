package test.conditions;

import static org.junit.Assert.*;

import main.conditions.WeaponTypeCondition;

import org.junit.Test;

public class WeaponTypeConditionTest {

	@Test
	public void testGetConditionIsNotNull() {
		WeaponTypeCondition wtCondition = new WeaponTypeCondition(wt -> true);
		assertNotNull("The weaponTypeCondition should not be null", 
				wtCondition.getCondition());
	}

}
