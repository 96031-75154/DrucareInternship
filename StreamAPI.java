package streamapi_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
	public static void main(String[] args) {
		
		StreamAPI streamAPI = new StreamAPI();
		List<String> list = Arrays.asList("Acer", "About", "boat", "app", "Bat", "air", "bike", "car");
		System.out.println(streamAPI.search(list));
		List<Integer> numberList = Arrays.asList(10, 20, 30, 40 ,50, 60, 70, 80, 90, 100);
		System.out.println("Average of list numbers :"+ streamAPI.averageValue(numberList));
		System.out.println("Upper case list :"+streamAPI.upperCase(list));
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
		int empty = (int)strList.stream().filter(str -> str.isEmpty()).count();
		System.out.println("Empty Strings in a list :"+empty);
		int lenMoreThan3 = (int)list.stream().filter(str -> str.length() > 3).count();
		System.out.println("Length of String more than three :"+lenMoreThan3);
		int startsWithA = (int)list.stream().filter(str -> str.startsWith("a")).count();
		System.out.println("String starts with a letter :"+startsWithA);
		System.out.println(streamAPI.removeEmptyString(strList));
		System.out.println(streamAPI.moreThanThree(strList));
		System.out.println(streamAPI.delimeter(list));
		List<Integer> numList = Arrays.asList(3, 5, 8, 2, 3, 9, 4, 5, 3, 8);
		System.out.println("List of Squares :"+streamAPI.squares(numList));
		streamAPI.calculte(numList);
	}
	public List<String> search(List<String> list) {
		
		List<String> findList = list.stream()
				.filter(s -> s.length() == 3 && s.startsWith("a")).toList();
		return findList;
	}
	public Double averageValue(List<Integer> list) {
		
		Double average = list.stream().mapToDouble(num -> num.doubleValue())
				.average().getAsDouble();
		return average;
	}
	public List<String> upperCase(List<String> list) {
		
		List<String> uppCaseList = list.stream().map(str -> str.toUpperCase()).toList();
		return uppCaseList;
	}
	public List<String> removeEmptyString(List<String> list) {
		
		List<String> emptyStringList = list.stream()
				.filter(str -> !str.contentEquals("")).toList();
		return emptyStringList;
	}
	public List<String> moreThanThree(List<String> list) {
		
		List<String> lengthList = list.stream().filter(str -> str.length() > 2).toList();
		return lengthList;
	}
	public String delimeter(List<String> list) {
		
		String delimeterList = list.stream().map(str -> str.toUpperCase())
				.collect(Collectors.joining("-"));
		return delimeterList;
	}
	public List<Integer> squares(List<Integer> list) {
		
		List<Integer> squareList = list.stream().distinct()
				.map(num -> num*num).sorted().toList();
		return squareList;
	}
	public void calculte(List<Integer> list) {
		
		int addition = list.stream().mapToInt(num -> num).sum();
		System.out.println("Sum of list :"+addition);
		int min = list.stream().min((n1, n2) -> n1 > n2 ? 1 : -1).get();
		System.out.println("Minimum number :"+min);
		int max = list.stream().max((n1, n2) -> n1 > n2 ? 1 : -1).get();
		System.out.println("Maximum number :"+max);
		int count = (int) list.stream().mapToInt(num -> num).count();
		System.out.println("Count of list :"+count);
		Double average = list.stream().mapToDouble(num -> num.doubleValue())
				.average().getAsDouble();
		System.out.println("Average :"+average);
	}
}