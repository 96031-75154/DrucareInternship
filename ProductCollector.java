package java8practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductCollector {
	public static void main(String[] args) {
		List<Laptop> productsList = new ArrayList<Laptop>();  
        productsList.add(new Laptop(1,"HP Laptop",25000f));  
        productsList.add(new Laptop(2,"Dell Laptop",30000f));  
        productsList.add(new Laptop(3,"Lenevo Laptop",28000f));  
        productsList.add(new Laptop(4,"Sony Laptop",28000f));  
        productsList.add(new Laptop(5,"Apple Laptop",90000f));
        
        Set<Float> priceList = productsList.stream().map(p -> p.price)
        		.collect(Collectors.toSet());
        System.out.println(priceList);
        
        Double sumOfAll = productsList.stream()
        		.collect(Collectors.summingDouble(p -> p.price));
        System.out.println("Price of all products : "+sumOfAll);
        
        Double averagePrice = productsList.stream()
        		.collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("Average price : "+averagePrice);
        
        Long noOfProducts = productsList.stream().collect(Collectors.counting());
        System.out.println("Total products : "+noOfProducts);
        
        List<Float> mapPriceList = productsList.stream().filter(p -> p.price > 28000)
        		.map(p -> p.price).collect(Collectors.toList());
        System.out.println(mapPriceList);
        
        productsList.stream()
        .filter(p -> p.price == 30000).forEach(p -> System.out.println(p.name));
        
        double totalPrice = productsList.stream().map(p -> p.price)
        		.reduce(0.0f, Float::sum);
        System.out.println("Total price : "+totalPrice);
        
        Laptop minCost = productsList.stream()
        		.min((p1, p2) -> p1.price > p2.price ? 1 : -1).get();
        System.out.println("Least price : "+minCost.price);
        
        Laptop maxCost = productsList.stream()
        		.max((p1, p2) -> p1.price > p2.price ? 1 : -1).get();
        System.out.println("Highest price : "+maxCost.price);
        
        long numbers = productsList.stream().filter(p -> p.price < 30000).count();
        System.out.println(numbers);
        
        Set<Float> set = productsList.stream().filter(p -> p.price < 30000)
        		.map(p -> p.price).collect(Collectors.toSet());
        System.out.println(set);
        
        Map<Integer, String> map = productsList.stream()
        		.collect((Collectors.toMap(p -> p.id, p -> p.name)));
        System.out.println(map);
        
        Stream.iterate(1, n -> n+1).filter(x -> x%2 == 0).limit(5)
        .forEach(num -> System.out.print(num +" "));
	}
}

class Laptop {
	int id;
	String name;
	float price;
	
	public Laptop(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}