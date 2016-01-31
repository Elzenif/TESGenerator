package test.factories;

import static org.junit.Assert.*;
import main.factories.ItemFactory;

import org.junit.Before;
import org.junit.Test;

public class ItemFactoryTest {

	ItemFactory itemFactory;
	
	@Before
	public final void loadFactory() {
		itemFactory = new ItemFactory();
	}
	
	@Test
	public final void testItemFactoryCreateItemIsNotNull() {
		assertNotNull("The item returned by the createItem method should not be null",
				itemFactory.createItem("weapon"));
	}

}
