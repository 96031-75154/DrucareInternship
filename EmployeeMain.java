package java8_streams;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeMain {
	public static void main(String[] args) {
		
		EmployeeMain employeeMain = new EmployeeMain();
		System.err.println("Employee list by Gender :");
		System.out.println(employeeMain.groupByGender(employeeDtos()) + "\n");
		System.err.println("List employees by each department :");
		employeeMain.listEmployeesByDepartment();
		System.out.println("");
		System.err.print("List of departments :");
		employeeMain.listOfDepartments();
		System.out.println("");
		System.err.println("List the employee names who joined after 2022 :");
		employeeMain.listNames();
		System.out.println();
		System.err.println("Number of males and females in the organization :");
		employeeMain.countByGender(employeeDtos());
		System.out.println();
		System.err.println("Number of males and females in testing :");
		employeeMain.genderInTesting();
	}
	public static List<EmployeeDto> employeeDtos() {
		
		List<EmployeeDto> dtoList = new ArrayList<>();
		dtoList.add(new EmployeeDto(129, "Raju", "Male", "Development", LocalDateTime.of(2020, 10, 12, 9, 45, 25)));
		dtoList.add(new EmployeeDto(432, "Suraksha", "Female", "Development", LocalDateTime.of(2022, 12, 18, 10, 45, 10)));
		dtoList.add(new EmployeeDto(132, "Kiran", "Male", "Testing", LocalDateTime.of(2023, 11, 23, 11, 10, 15)));
		dtoList.add(new EmployeeDto(546, "Ramya", "Female", "Testing", LocalDateTime.of(2021, 05, 03, 9, 35, 55)));
		dtoList.add(new EmployeeDto(115, "Rohini", "Female", "Admin", LocalDateTime.of(2023, 03, 04, 10, 20, 45)));
		dtoList.add(new EmployeeDto(345, "Shiva", "Male", "Admin", LocalDateTime.of(2023, 10, 12, 10, 15, 30)));
		return dtoList;
	}
	public Map<String, List<EmployeeDto>> groupByGender(List<EmployeeDto> dtos) {
		
		Map<String, List<EmployeeDto>> genderMap = dtos.stream()
				.collect(Collectors.groupingBy(EmployeeDto::getGender));
		return genderMap;
	}
	public void countByGender(List<EmployeeDto> dtos) {
		
		Map<String, List<EmployeeDto>> genMap = dtos.stream().collect(Collectors.groupingBy(EmployeeDto::getGender));
		genMap.forEach((gender, genderCount) -> System.out.println(gender+" "+genderCount.stream().map(count -> count.getGender()).count()));
	}
	public void listEmployeesByDepartment() {
		
		List<EmployeeDto> dtos = employeeDtos();
		Map<String, List<EmployeeDto>> deptMap = dtos.stream()
				.collect(Collectors.groupingBy(EmployeeDto::getDepartment));
		deptMap.forEach((dept, list) -> System.out.println(dept + "\n" +list));
	}
	public void listOfDepartments() {
		
		List<EmployeeDto> dtos = employeeDtos();
		Set<String> deptList = dtos.stream()
				.map(dept -> dept.getDepartment()).collect(Collectors.toSet());
		deptList.forEach(d -> System.out.print("\n" + d));
		System.out.println("");
	}
	public void listNames() {
		
		List<EmployeeDto> dtos = employeeDtos();
//		Predicate<List<EmployeeDto>> predicate = dtos.stream().filter(date -> date.getDateOfJoin().getYear() > 2022);
		List<String> list = dtos.stream()
				.filter(date -> date.getDateOfJoin().getYear() > 2022)
				.map(name -> name.getName()).toList();
		list.forEach(System.out::println);
	}
	public void genderInTesting() {
		
		List<EmployeeDto> dtos = employeeDtos();
		Map<String, List<EmployeeDto>> map = dtos.stream()
				.filter(dept -> dept.getDepartment() == "Testing")
				.collect(Collectors.groupingBy(EmployeeDto::getGender));
		map.forEach((gender, genderCount) -> System.out.println(gender + " " +genderCount.stream().map(count -> count.getGender()).count()));
	}
}

class EmployeeDto {
	
	private int id;
	private String name;
	private String gender;
	private String department;
	private LocalDateTime dateOfJoin;
	
	public EmployeeDto(int id, String name, String gender, String department, LocalDateTime dateOfJoin) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.dateOfJoin = dateOfJoin;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public LocalDateTime getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(LocalDateTime dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department
				+ ", dateOfJoin=" + dateOfJoin + "]"+"\n";
	}
}