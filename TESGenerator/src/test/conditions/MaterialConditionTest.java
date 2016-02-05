package test.conditions;

import static org.junit.Assert.*;
import main.conditions.ConditionID;
import main.conditions.MaterialCondition;

import org.junit.Test;

public class MaterialConditionTest {

	@Test
	public void testGetConditionIsNotNull() {
		MaterialCondition mCondition = new MaterialCondition(m -> true);
		assertNotNull("The materialCondition should not be null",
				mCondition.getCondition());
	}

	@Test
	public void testGetConditionIDIsOK() {
		MaterialCondition mCondition = new MaterialCondition(m -> true);
		assertEquals("The materialConditionID is wrong",
				ConditionID.MATERIAL, mCondition.getConditionID());	
	}
}
