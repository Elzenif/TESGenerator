package test.conditions;

import static org.junit.Assert.*;
import main.conditions.ConditionList;
import main.conditions.GenericCondition;
import main.enums.Material;
import main.enums.WeaponType;

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
		GenericCondition<WeaponType> wtCondition =
				new GenericCondition<WeaponType>(WeaponType.class);
		GenericCondition<Material> mCondition =
				new GenericCondition<Material>(Material.class);
		conditionList.add(wtCondition);
		conditionList.add(wtCondition);
		conditionList.add(mCondition);
		assertEquals("The conditionList size should be 2",
				2, conditionList.size());
	}
	
	@Test
	public void testAddCondition() {
		ConditionList conditionList = new ConditionList();
		GenericCondition<WeaponType> wtCondition =
				new GenericCondition<WeaponType>(WeaponType.class);
		conditionList.add(wtCondition);
		assertTrue("The conditionList should contain a WeaponTypeCondition",
				conditionList.contains(wtCondition));
	}
	
	@Test
	public void testRemoveCondition() {
		ConditionList conditionList = new ConditionList();
		GenericCondition<WeaponType> wtCondition =
				new GenericCondition<WeaponType>(WeaponType.class);
		conditionList.add(wtCondition);
		assertEquals("The conditionList should remove a WeaponTypeCondition",
				wtCondition, conditionList.remove(WeaponType.class));
	}
	
}
