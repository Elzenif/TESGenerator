package test.items;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import main.enums.WeaponType;
import main.items.Weapon;

import org.junit.Before;
import org.junit.Test;

public class WeaponTest {
	
	private Weapon weapon;
	
	@Before
	public final void constructWeapon() {
		weapon = new Weapon();
	}

	@Test
	public final void testWeaponNameIsNotNull() {
		assertNotNull("The weapon name should not be null", weapon.getName());
	}

	@Test
	public final void testWeaponTypeIsNotNull() {
		assertNotNull("The weapon type should not be null", weapon.getType());
	}
	
	@Test
	public final void testWeaponTypeIsValid() {
		Set<WeaponType> weaponTypes = new HashSet<WeaponType>(Arrays.asList(WeaponType.values()));
		assertTrue("The weapon type should be a WeaponType enum : " + weapon.getType().toString(), 
				weaponTypes.contains(weapon.getType()));
	}
	
	@Test
	public final void testOneHandWeaponInitialization() {
		Weapon weapon = new Weapon(1);
		assertEquals("The weapon should be one hand type : " + weapon.toString(), 1, weapon.getType().getNbHands());
	}
	
	@Test
	public final void testTwoHandsWeaponIntitialization() {
		Weapon weapon = new Weapon(2);
		assertEquals("The weapon should be one hand type : " + weapon.toString(), 2, weapon.getType().getNbHands());	
	}
	
	@Test
	public final void testWeaponToStringIsNotNull() {
		String s = weapon.toString();
		assertNotNull("The toString method should not return null", s);
	}
	
	@Test
	public final void testWeaponToStringIsValid() {
		String s = weapon.toString();
		System.out.println(s);
		assertFalse("The toString method should be overridden : " + s, s.contains("@"));
	}

}
