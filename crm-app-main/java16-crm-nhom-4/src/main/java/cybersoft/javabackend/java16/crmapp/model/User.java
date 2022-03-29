package cybersoft.javabackend.java16.crmapp.model;

public class User {
	private String id;
	private String email;
	private String password;
	private String fullname;
	private String address;
	private String phone;
	private int role;
	
	public User() {
		this.id = "";
		this.email = "";
		this.password = "";
		this.fullname = "";
		this.address = "";
		this.phone = "";
		}
	
	public User(String id, String email, String password, String fullname, String address, String phone) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	
}
