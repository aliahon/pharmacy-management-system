package main.java.model;

import javafx.beans.property.*;

public class User {

    private  StringProperty firstName;
    private  StringProperty lastName;
    private  StringProperty email;
    private  StringProperty tel;
    private  StringProperty username;
    private  StringProperty password;

    // Constructor
    public User(String firstName,String lastName,String email,String tel,String username,String password) {
        this.setFirstName(new SimpleStringProperty(firstName));
        this.setLastName(new SimpleStringProperty(lastName));
        this.setEmail(new SimpleStringProperty(email));
        this.setTel(new SimpleStringProperty(tel));
        this.setUsername(new SimpleStringProperty(username));
        this.setPassword(new SimpleStringProperty(password));
    }

	public StringProperty getFirstName() {
		return firstName;
	}

	public void setFirstName(StringProperty firstName) {
		this.firstName = firstName;
	}

	public StringProperty getLastName() {
		return lastName;
	}

	public void setLastName(StringProperty lastName) {
		this.lastName = lastName;
	}

	public StringProperty getEmail() {
		return email;
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	public StringProperty getTel() {
		return tel;
	}

	public void setTel(StringProperty tel) {
		this.tel = tel;
	}

	public StringProperty getUsername() {
		return username;
	}

	public void setUsername(StringProperty username) {
		this.username = username;
	}

	public StringProperty getPassword() {
		return password;
	}

	public void setPassword(StringProperty password) {
		this.password = password;
	}


}
