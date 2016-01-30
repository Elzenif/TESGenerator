package test.objects;

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
		assertNotNull("The weapon name should not be null", weapon.getName());
	}

	@Test
	public final void testWeaponTypeIsNotNull() {
		Weapon weapon = new Weapon();
		assertNotNull("The weapon type should not be null", weapon.getType());
	}
	
	@Test
	public final void testWeaponTypeIsValid() {
		Weapon weapon = new Weapon();
		Set<WeaponType> weaponTypes = new HashSet<WeaponType>(Arrays.asList(WeaponType.values()));
		assertTrue("The weapon type should be be within the WeaponType enum", 
				weaponTypes.contains(weapon.getType()));
	}
	
}