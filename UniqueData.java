package collections;

import java.util.ArrayList;
import java.util.List;

public class UniqueData {
	public static void main(String[] args) {
		
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Surya", "Kumar", "surya74@gmail.com", "Male", 15));
		list.add(new Person(2, "Pavan", "Kalyan", "pavan88@gmail.com", "Male", 19));
		list.add(new Person(3, "Sai", "Rajesh", "sai99@gmail.com", "Male", 13));
		list.add(new Person(4, "Vamshi", "Krishna", "vamshi41@gmail.com", "Male", 18));
		list.add(new Person(5, "Praveen", "Kumar", "praveen66@gmail.com", "Male", 16));
		list.add(new Person(6, "Rajesh", "Kumar", "rajesh94@gmail.com", "Male", 14));
		list.add(new Person(7, "Supriya", "Sharma", "supriya34@gmail.com", "female", 17));
		list.add(new Person(8, "Suresh", "Babu", "suresh45@gmail.com", "Male", 20));
		list.add(new Person(9, "David", "Warner", "david23@gmail.com", "Male", 21));
		list.add(new Person(10, "Sravani", "chowdary", "sravani55@gmail.com", "female", 13));
		list.add(new Person(11, "Rani", "Reddy", "rani23@gmail.com", "female", 23));
		
		System.out.println("List of persons by age 18 and below :");
		System.out.println(getPersonByAge(list));
		System.out.println(getFirstTen(list));
	}
	static List<Person> getPersonByAge(List<Person> persons) {
		List<Person> list = new ArrayList<>();
		
		for(Person person : persons) {
			if(person.getAge() <= 18)
				list.add(person);
		}
		return list;
	}
	static List<Person> getFirstTen(List<Person> list) {
		List<Person> firstTenList = new ArrayList<>();
		int count = 1;
		for(Person person : list) {
			if(person.getAge() <=18 && count <= 10) {
				firstTenList.add(person);
				count++;
			}
		}
		return firstTenList;
	}
}

class Person {

	final Integer id;
	final String firstName;
	final String lastName;
	final String email;
	final String gender;
	final Integer age;

	public Person(Integer id, String firstName, String lastName, String email, String gender, Integer age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getGender() {
		return gender;
	}
	public Integer getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", email='" + email + '\'' + ", gender='" + gender + '\'' + ", age=" + age + '}';
	}
}