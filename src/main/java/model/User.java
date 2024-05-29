package main.java.model;

import javafx.beans.property.*;

public class User {

	private IntegerProperty id;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty email;
    private StringProperty tel;
    private StringProperty username;
    private StringProperty password;

    // Constructor
    public User(String firstName, String lastName, String email, String tel, String username, String password) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.tel = new SimpleStringProperty(tel);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }
    // Constructor
    	public User(int id,String firstName, String lastName, String email, String tel, String username, String password) {
    		this.id = new SimpleIntegerProperty(id);
    		this.firstName = new SimpleStringProperty(firstName);
    		this.lastName = new SimpleStringProperty(lastName);
    		this.email = new SimpleStringProperty(email);
    		this.tel = new SimpleStringProperty(tel);
    		this.username = new SimpleStringProperty(username);
    		this.password = new SimpleStringProperty(password);
    	}

    // Getters and setters for each property
    public StringProperty firstNameProperty() {
        if (firstName == null) {
            firstName = new SimpleStringProperty(this, "firstName");
        }
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstNameProperty().set(firstName);
    }

    public String getFirstName() {
        return firstNameProperty().get();
    }

    public StringProperty lastNameProperty() {
        if (lastName == null) {
            lastName = new SimpleStringProperty(this, "lastName");
        }
        return lastName;
    }

    public void setLastName(String lastName) {
        lastNameProperty().set(lastName);
    }

    public String getLastName() {
        return lastNameProperty().get();
    }

    public StringProperty emailProperty() {
        if (email == null) {
            email = new SimpleStringProperty(this, "email");
        }
        return email;
    }

    public void setEmail(String email) {
        emailProperty().set(email);
    }

    public String getEmail() {
        return emailProperty().get();
    }

    public StringProperty telProperty() {
        if (tel == null) {
            tel = new SimpleStringProperty(this, "tel");
        }
        return tel;
    }

    public void setTel(String tel) {
        telProperty().set(tel);
    }

    public String getTel() {
        return telProperty().get();
    }

    public StringProperty usernameProperty() {
        if (username == null) {
            username = new SimpleStringProperty(this, "username");
        }
        return username;
    }

    public void setUsername(String username) {
        usernameProperty().set(username);
    }

    public String getUsername() {
        return usernameProperty().get();
    }

    public StringProperty passwordProperty() {
        if (password == null) {
            password = new SimpleStringProperty(this, "password");
        }
        return password;
    }

    public void setPassword(String password) {
        passwordProperty().set(password);
    }

    public String getPassword() {
        return passwordProperty().get();
    }

    public IntegerProperty idProperty() {
        if (id == null) {
            id = new SimpleIntegerProperty(this, "id");
        }
        return id;
    }

    public int getId() {
        return idProperty().get();
    }
}
