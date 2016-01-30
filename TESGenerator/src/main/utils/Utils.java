package main.utils;

import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Set;

public class Utils {

	public static SecureRandom seed = new SecureRandom();
	
	public static int sum(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		return result;
	}
	
	public static int sum(Set<Integer> set) {
		int result = 0;
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			result += it.next();
		}
		return result;
	}
}
