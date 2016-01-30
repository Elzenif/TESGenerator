package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import main.enums.WeaponType;
import main.objects.Weapon;

import org.junit.Test;

public class WeaponTest {

	@Test
	public final void testWeaponNameisNotNull() {
		Weapon weapon = new Weapon();
		weapon.initialize();
		assertNotNull("The weapon name should not be null", weapon.getName());
	}

	@Test
	public final void testWeaponTypeIsNotNull() {
		Weapon weapon = new Weapon();
		weapon.initialize();
		assertNotNull("The weapon type should not be null", weapon.getType());
	}
	
	@Test
	public final void testWeaponTypeIsValid() {
		Weapon weapon = new Weapon();
		weapon.initialize();
		Set<WeaponType> expected = new HashSet<WeaponType>(Arrays.asList(WeaponType.values()));
		Set<WeaponType> actual = new HashSet<WeaponType>();
		for (WeaponType wt : WeaponType.values()) {
			actual.add(wt);
		}
		assertEquals(expected, actual);
	}
}
