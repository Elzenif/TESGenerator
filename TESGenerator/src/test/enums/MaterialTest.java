package test.enums;

import static org.junit.Assert.*;
import main.enums.Material;

import org.junit.Test;

public class MaterialTest {

	@Test
	public final void testNameIsNotNull() {
		for (Material m : Material.values()) {
			assertNotNull("The material name should not be null",
					m.getName());
		}
	}

	@Test
	public final void testProbaIsValid() {
		for (Material m : Material.values()) {
			assertTrue("The proba should be positive", m.getProba() >= 0);
		}
	}
}
