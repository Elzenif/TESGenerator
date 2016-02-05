package test.conditions;

import static org.junit.Assert.*;
import main.conditions.ConditionID;
import main.conditions.ConditionList;
import main.conditions.WeaponTypeCondition;

import org.junit.Test;

public class ConditionListTest {

	@Test
	public void testGetListIsNotNull() {
		ConditionList conditionList = new ConditionList();
		assertNotNull("The conditionList should not be null", conditionList);
	}

	@Test
	public void testConditionListSize() {
		ConditionList conditionList = new ConditionList();
		WeaponTypeCondition wtCondition = new WeaponTypeCondition(wt -> true);
		conditionList.add(wtCondition);
		conditionList.add(wtCondition);
		assertEquals("The conditionList size should be 1",
				1, conditionList.size());
	}
	
	@Test
	public void testAddCondition() {
		ConditionList conditionList = new ConditionList();
		WeaponTypeCondition wtCondition = new WeaponTypeCondition(wt -> true);
		conditionList.add(wtCondition);
		assertTrue("The conditionList should contain a WeaponTypeCondition",
				conditionList.contains(wtCondition));
	}
	
	@Test
	public void testRemoveCondition() {
		ConditionList conditionList = new ConditionList();
		WeaponTypeCondition wtCondition = new WeaponTypeCondition(wt -> true);
		conditionList.add(wtCondition);
		assertEquals("The conditionList should remove a WeaponTypeCondition",
				wtCondition, conditionList.remove(ConditionID.WEAPON_TYPE));
	}
	
}
