package test.items;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import main.enums.Material;
import main.enums.WeaponType;
import main.items.Weapon;

import org.junit.Before;
import org.junit.Test;

public class WeaponTest {
	
	private Weapon weapon;
	
	@Before
	public final void constructWeapon() {
	}

	@Test
	public final void testWeaponNameIsNotNull() {
		weapon = Weapon.createWeaponWithoutConstraints();
		assertNotNull("The weapon name should not be null", weapon.getName());
	}

	@Test
	public final void testWeaponTypeIsNotNull() {
		weapon = Weapon.createWeaponWithoutConstraints();
		assertNotNull("The weapon type should not be null", weapon.getType());
	}
	
	@Test
	public final void testWeaponTypeIsValid() {
		weapon = Weapon.createWeaponWithoutConstraints();
		Set<WeaponType> weaponTypes = new HashSet<WeaponType>(
				Arrays.asList(WeaponType.values()));
		assertTrue("The weapon type should be a WeaponType enum : "
				+ weapon.getType().toString(), 
				weaponTypes.contains(weapon.getType()));
	}
	
	@Test
	public final void testOneHandWeaponInitialization() {
		weapon = Weapon.createWeaponWithXHands(1);
		assertEquals("The weapon should be one hand type : " + weapon.toString(),
				1, weapon.getType().getNbHands());
	}
	
	@Test
	public final void testTwoHandsWeaponIntitialization() {
		weapon = Weapon.createWeaponWithXHands(2);
		assertEquals("The weapon should be one hand type : " + weapon.toString(),
				2, weapon.getType().getNbHands());	
	}
	
	@Test
	public final void testWeaponToStringIsNotNull() {
		weapon = Weapon.createWeaponWithoutConstraints();
		assertNotNull("The toString method should not return null",
				weapon.toString());
	}
	
	@Test
	public final void testWeaponToStringIsValid() {
		weapon = Weapon.createWeaponWithoutConstraints();
		String s = weapon.toString();
		System.out.println("Generating weapon : " + s);
		assertFalse("The toString method should be overridden : " + s,
				s.contains("@"));
	}
	
	@Test
	public final void testWeaponMaterialIsNotNull() {
		weapon = Weapon.createWeaponWithoutConstraints();
		assertNotNull("The weapon material should not be null",
				weapon.getMaterial());
	}
	
	@Test
	public final void testWeaponMaterialIsValid() {
		weapon = Weapon.createWeaponWithoutConstraints();
		Set<Material> materials = new HashSet<Material>(
				Arrays.asList(Material.values()));
		assertTrue("The material should be a Material enum : "
				+ weapon.getMaterial().toString(),
				materials.contains(weapon.getMaterial()));
	}

}
