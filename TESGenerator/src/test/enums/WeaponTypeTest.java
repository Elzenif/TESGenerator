package test.enums;

import static org.junit.Assert.*;
import main.enums.ItemType;
import main.enums.WeaponType;

import org.junit.Test;

public class WeaponTypeTest {

	@Test
	public final void testNameIsNotNull() {
		for (WeaponType wt : WeaponType.values()) {
			assertNotNull("The weapon type name should not be null",
					wt.getName());
		}
	}

	@Test
	public final void testOneOrTwoHand() {
		for (WeaponType wt : WeaponType.values()) {
			if (wt.getProba() > 0) {
				assertTrue("The weapon type should be one or two hands", 
						wt.getNbHands() == 1 || wt.getNbHands() == 2);
			}
		}
	}
	
	@Test
	public final void testProbaIsValid() {
		for (WeaponType wt : WeaponType.values()) {
			assertTrue("The proba should be positive", wt.getProba() >= 0);
		}
	}
	
	@Test
	public final void testGetDefaultIsDefault() {
		assertEquals("The weapon type default value should be DEFAULT",
				WeaponType.DEFAULT, ItemType.getDefault(WeaponType.class));
	}
}
