package java8_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDtoCopy {
	public static void main(String[] args) {
		
		List<User> users = new ArrayList<>();
		users.add(new User(101, "Ramesh", "ramesh837@gmail.com"));
		users.add(new User(102, "Praveen", "praveen93@gmail.com"));
		users.add(new User(103, "Subbu", "subbu223@gmail.com"));
		users.add(new User(104, "Rahim", "rahim34@gmail.com"));
				
		/*	Traditional process
		for(User user : users) {
			userDto.add(new UserDto(user.getId(), user.getName(), user.getEmail()));
		}
		for(UserDto dto : userDto) {
			System.out.println(dto);
		}	*/
		
		//	Stream API
		List<UserDto> dtos = users.stream()
				.map((User user) -> new UserDto(user.getId(), user.getName(), user.getEmail()))
				.collect(Collectors.toList());
		dtos.forEach(System.out::println);
		
		users.stream().map((User user) -> new UserDto(user.getId(), user.getName(), user.getEmail()))
		.forEach((userDTO) -> {
			System.out.println(userDTO);
		});
		
		List<UserDto> userDto = users.stream().map(UserDto::getAllUsers)
				.collect(Collectors.toList());
		System.out.println(userDto);
	}
}

class User {
	private int id;
	private String name;
	private String email;
	
	public User(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}

class UserDto {
	private int id;
	private String name;
	private String email;
	
	public UserDto(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	public static UserDto getAllUsers(User user) {
		
		return new UserDto(user.getId(), user.getName(), user.getEmail());
	}
}