package test.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import main.utils.Utils;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testSumArray() {
		int[] array = {1,3,15,2,9};
		assertEquals("The result is incorrect", 30, Utils.sum(array));
	}
	
	@Test
	public void testSumCollection() {
		Integer[] array = {1,3,15,2,9};
		Collection<Integer> collec = new ArrayList<Integer>(Arrays.asList(array));
		assertEquals("The result is incorrect", 30, Utils.sum(collec));	
	}
}
