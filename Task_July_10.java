package july_10;

public class Task_July_10 {

	public static void main(String[] args) {
		
		// Exercise 1
		String message = "That was great - lol";
		System.out.println(message);
		String replace = message.replace("lol", "laugh out loud");
		System.out.println(replace);
		
		// Exercise 2
		String firstLetterCaps = "ALEX";
		System.out.println("Actual : "+firstLetterCaps);
		System.out.println("New : "+firstLetterCaps.substring(0, 1).toUpperCase().concat(firstLetterCaps.substring(1).toLowerCase()));
		
		// Exercise 3
		String book = "";
		String movie = "";
		book = book.join(book, "Discovery Of India");
		System.out.println("Book name : "+book);
		movie = movie.join(movie, "Sherlock Holmes");
		System.out.println("Movie name : "+movie);
		
		// Exercise 4
		// Approach I
		String animal = "";
		String food = "";
		System.out.println("Animal name : "+ animal + "Elephant");
		System.out.println("Food name : "+ food + "Chicken biryani with green pea");
		// Approach II
		System.out.println("Animal name : "+ animal.concat("Jiraffie"));
		System.out.println("Food name : "+ food.concat("Paw Bajji"));
		
		// Execise 5
		String name = "julian";
		String color = "green";
		String foodItem = "pizza";
		String total = String.join(".", name + "'s favourite color is " + color, " His favourite food is " + foodItem);
		System.out.println(total);
	}
}
