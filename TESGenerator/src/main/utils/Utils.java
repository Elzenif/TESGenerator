package main.utils;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Iterator;

public class Utils {

	public static SecureRandom seed = new SecureRandom();
	
	public static int sum(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		return result;
	}

	public static int sum(Collection<Integer> collec) {
		int result = 0;
		Iterator<Integer> it = collec.iterator();
		while(it.hasNext()) {
			result += it.next();
		}
		return result;
	}
}
