package io.app.SpringBootApp.Entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {
	
	private String fName;
	private String lName;
	
	@Id
	private String ID;
	
	@Column(unique=true)
	private String email;
	private String city;
	
	public User(){
		this.ID=UUID.randomUUID().toString();
	}
	public User(String fName, String lName, String email, String city) {
		this.ID = UUID.randomUUID().toString();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.city = city;

	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "User [fName=" + fName + ", lName=" + lName + ", ID=" + ID + ", email=" + email + ", city=" + city + "]";
	}
	
	
	
	

}
