package kr.or.connect.mvcexam.dto;

public class User {
	private String name;
	private String email;
	private int age;
	 
	@Override
	public String toString() {
		return "user [name=" + name + ", email=" + email + ", age=" + age + "]";
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
