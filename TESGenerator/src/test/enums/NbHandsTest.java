package test.enums;

import static org.junit.Assert.*;
import main.enums.NbHands;

import org.junit.Test;

public class NbHandsTest {

	@Test
	public final void testOneHandValue() {
		assertEquals("The value associated to ONE_HAND should be 1", 
				1, NbHands.ONE_HAND.getValue());
	}

	@Test
	public final void testTwoHandsValue() {
		assertEquals("The value associated to TWO_HANDS should be 2", 
				2, NbHands.TWO_HANDS.getValue());
	}

}
