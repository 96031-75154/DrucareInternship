package july_11;

import java.util.Arrays;

public class Task_Strings {
	public static void main(String[] args) {
		String actual = "Backend Java Developer";
		System.out.println(wordRevesre(actual));
		
		Task_Strings.palindrome("malayalam");
		
		System.out.println("Total word count : " + wordsCount("java is a programming language"));
		
		vowelsAndConsonants("java is a programming language");
		
		boolean solution = Task_Strings.anagrams("care", "race");
		if(solution) {
			System.out.println("Given strings are anagrams");
		}
		else
		{
			System.out.println("Given strings are not anagrams");
		}
	}
	
	static String wordRevesre(String sentence) {
		String[] words = sentence.split(" ");
		String reverse = "";
		for(String word : words) {
			for(int i=word.length()-1; i>=0; i--) {
				reverse += word.charAt(i);
			}
			reverse += " ";
		}
		return reverse;
	}
	
	static void palindrome(String name) {
		String result = "";
		for(int i=name.length()-1; i>=0; i--) {
			result += name.charAt(i);
		}
		if(name.equals(result)) {
			System.out.println(name + " is palindrome");
		}
		else
		{
			System.out.println(name + " is not palindrome");
		}
	}
	
	public static boolean anagrams(String firstInput, String secondInput) {
		boolean flag = true;
		char first[] = firstInput.toCharArray();
		char second[] = secondInput.toCharArray();
		Arrays.sort(first);
		Arrays.sort(second);
		if(first.length == second.length) {
			if(Arrays.equals(first, second))
				flag = true;
		}
		else
		{
			flag = false;
		}
		return flag;
	}
	
	public static int wordsCount(String string) {
		
		string = string.trim();
		String totalWords[] = string.split(" ");
		return totalWords.length;
	}
	
	static void vowelsAndConsonants(String letters) {
		
		letters = letters.toLowerCase();
		int vowels = 0;
		int consonants = 0;
		for(int i=0; i<letters.length(); i++) {
			char find = letters.charAt(i);
			if(find == 'a' || find == 'e' || find == 'i' || find == 'o' || find == 'u')
				vowels++;
			else if(find >= 'a' && find <='z')
				consonants++;
		}
		System.out.println("Vowels : "+vowels + "\s"+ "Consonants : "+consonants);
	}
}
