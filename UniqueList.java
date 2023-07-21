package collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniqueList {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Sam", "Peter","ballon","Sam");
		Map<String, Integer> map = new HashMap<>();
		for(String name : list) {
			map.put(name, 1);
		}
		for(Entry<String, Integer> names : map.entrySet()) {
			System.out.println(names.getKey());
		}
	}
}