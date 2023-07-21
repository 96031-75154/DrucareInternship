package exceptionhandling;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CharacterOccurence {
	public static void main(String[] args) {

		String str = "rapoluprashanth";
		Map<Character, Integer> chMap = characterCount(str);
		for (Entry<Character, Integer> entry : chMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	public static Map<Character, Integer> characterCount(String sentence) {

		char[] letters = sentence.toUpperCase().toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : letters) {
			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
		}
		return map;
	}
}