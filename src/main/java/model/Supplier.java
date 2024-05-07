package main.java.model;

import javafx.beans.property.*;

public class Supplier {
    
    private final StringProperty name;
    private final StringProperty contact;

    // Constructor
    public Supplier(String name, String contact) {
        this.name = new SimpleStringProperty(name);
        this.contact = new SimpleStringProperty(contact);
    }

    // Getter methods
    public String getName() {
        return name.get();
    }

    public String getContact() {
        return contact.get();
    }

    // Setter methods
    public void setName(String name) {
        this.name.set(name);
    }

    public void setContact(String contact) {
        this.contact.set(contact);
    }

    // Property getters
    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty contactProperty() {
        return contact;
    }
}
