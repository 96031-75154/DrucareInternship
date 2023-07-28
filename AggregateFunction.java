package java8_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AggregateFunction {
	public static void main(String[] args) {
		
		System.out.println("Group the list of items as per the name :");
		Map<String, List<Laptop>> map = grouping();
		map.forEach((name, laptops) -> System.out.println(name +" "+ laptops));
		System.out.println("Group the list of items as per the cost :");
		Map<String, List<Laptop>> priceList = checkPrice();
		priceList.forEach((name, laptops) -> System.out.println(name +" "+laptops));
		System.out.println("No's of items for each brand :");
		Map<Laptop, Long> countMap = groupAndCount();
		countMap.forEach((laptop, num) -> System.out.println("Name : "+laptop.getName() +"	No's :"+num));
		System.out.print("Average price of laptops : ");
		AggregateFunction.averagePrice();
	}
	public static List<Laptop> getAllProducts() {
		
		List<Laptop> list = new ArrayList<>();
		list.add(new Laptop(1, "HP", 30000));
		list.add(new Laptop(2, "Lenovo", 35000));
		list.add(new Laptop(3, "HP", 38000));
		list.add(new Laptop(4, "Lenovo", 36000));
		list.add(new Laptop(5, "Dell", 40000));
		return list;
	}
	public static Map<Laptop, Long> groupAndCount() {
		
		List<Laptop> laptopList = AggregateFunction.getAllProducts();
		Map<Laptop, Long> countMap = laptopList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return countMap;
	}
	public static Map<String, List<Laptop>> grouping() {
		
		List<Laptop> laptopList = AggregateFunction.getAllProducts();
		Map<String, List<Laptop>> groupByName = laptopList.stream()
				.collect(Collectors.groupingBy(Laptop::getName));

//		group.forEach((name, cars) ->{
//			System.out.println(name);
//			cars.forEach(System.out::println);
//		});
		return groupByName;
	}
	public static Map<String, List<Laptop>> checkPrice() {
		
		List<Laptop> laptopList = AggregateFunction.getAllProducts();
		Map<String, List<Laptop>> priceCheck = laptopList.stream()
				.filter(p -> p.getPrice() > 35000)
				.collect(Collectors.groupingBy(Laptop::getName));
		return priceCheck;
	}
	public static void averagePrice() {
		
		List<Laptop> laptopList = AggregateFunction.getAllProducts();
		double avgPrice = laptopList.stream().mapToDouble(Laptop::getPrice)
				.average().orElse(0);
		System.out.println(avgPrice);
	}
}

class Laptop {
	private final int id;
	private final String name;
	private final double price;
	
	public Laptop(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}