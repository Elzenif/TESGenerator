package test;

import static org.junit.Assert.*;
import main.objects.Weapon;

import org.junit.Test;

public class WeaponTest {

	@Test
	public final void testWeaponNameNotNull() {
		Weapon weapon = new Weapon();
		weapon.initialize();
		assertNotNull("The weapon name should not be null", weapon.getName());
	}

	@Test
	public final void testWeaponTypeNotNull() {
		Weapon weapon = new Weapon();
		weapon.initialize();
		assertNotNull("The weapon type should not be null", weapon.getType());
	}
}
