package test;

import static org.junit.Assert.*;
import main.Weapon;

import org.junit.Test;

public class WeaponTest {

	@Test
	public void testWeaponName() {
		Weapon weapon = new Weapon();
		weapon.initialize();
		assertNotNull("The weapon name should not be null", weapon.getName());
	}

}
