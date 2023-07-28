package streamapi_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTask {
	public static void main(String[] args) {
		
		List<Integer> numberList = Arrays.asList(10, 20 ,30 ,40 ,50, 60);
		long totalNumbers = numberList.stream().count();
		System.out.println("Total numbers in list : "+totalNumbers);
		
		System.out.println("First number in list : "+numberList.stream().findFirst().get());
		
		List<String> word = Arrays.asList("aa", "bb", "cc", "dd");
		
		List<String> uCaseList = word.stream()
				.map(w -> w.toUpperCase()).collect(Collectors.toList());
		System.out.println(uCaseList);
		
		List<String> cityList = Arrays.asList("chennai", "mumbai", "banglore", "delhi", "chicago");
		
		List<String> groupList = cityList.stream()
				.filter(city -> city.contains("ai"))
				.collect(Collectors.toList());
		System.out.println(groupList);
		
		List<String> metroList = cityList.stream().sorted()
				.map(city -> city.concat(" metro"))
				.collect(Collectors.toList());
		System.out.println(metroList);
		
		List<String> list = Arrays.asList("aaa", "bbbb", "cc", "ddd", "eeeee");

		List<String> lenList = list.stream().filter(city -> city.length() > 3).toList();
		System.out.println(lenList);
		
		List<String> wordList = Arrays.asList("Java", "is", "a", "super", "cool", "language");
		
		String x = wordList.stream().collect(Collectors.joining(", "));
		System.out.println(x);
		
		String str = String.join(", ", wordList);
		System.out.println(str);
		
		String add = "";
		for(int i=0; i<wordList.size(); i++) {
			if(i != wordList.size()-1) {
				add += wordList.get(i) + ", ";
			}
			else
			{
				add += wordList.get(i);
			}
		}
		System.out.println(add);
	}
}