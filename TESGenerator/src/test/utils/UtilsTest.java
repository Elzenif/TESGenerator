package test.utils;

import static org.junit.Assert.*;
import main.utils.Utils;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testSumArray() {
		int[] array = {1,3,15,2,9};
		assertEquals(30, Utils.sum(array));
	}

}
