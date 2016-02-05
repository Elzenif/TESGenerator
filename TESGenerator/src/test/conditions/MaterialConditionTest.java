package test.conditions;

import static org.junit.Assert.*;
import main.conditions.MaterialCondition;

import org.junit.Test;

public class MaterialConditionTest {

	@Test
	public void testGetConditionIsNotNull() {
		MaterialCondition mCondition = new MaterialCondition(m -> true);
		assertNotNull("The materialcondition should not be null",
				mCondition.getCondition());
	}

}
