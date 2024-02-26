package com.example;

public class Contact {
    final String ID;
    String firstName;
    String lastName;
    String address;
    String number;

    // Constructor
    public Contact(String ID, String firstName, String lastName, String address, String number) {

        if (ID.length() <= 10 && ID.length() > 0) {
            this.ID = ID;
        } else {
            throw new IllegalArgumentException("ID must be at most 10 characters");
        }

        if (firstName.length() <= 10 && firstName.length() > 0) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name must be at most 10 characters");
        }

        if (lastName.length() <= 10 && lastName.length() > 0) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name must be at most 10 characters");
        }

        if (address.length() <= 30 && address.length() > 0) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address must be at most 30 characters");
        }

        if (number.length() == 10 && number.matches("[0-9]+")) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Number must be 10 characters long, only digits [0-9] are allowed");
        }

    };

    // Get methods
    public String getId() {
        return this.ID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getNumber() {
        return this.number;
    }

    // Set methods

    // No set method for ID as it cannot be changed

    public void setFirstName(String firstName) {
        if (firstName.length() <= 10 && firstName.length() > 0) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name must be at most 10 characters");
        }
    }

    public void setLastName(String lastName) {
        if (lastName.length() <= 10 && lastName.length() > 0) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name must be at most 10 characters");
        }
    }

    public void setAddress(String address) {
        if (address.length() <= 30 && address.length() > 0) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address must be at most 30 characters");
        }
    }

    public void setNumber(String number) {
        if (number.length() == 10 && number.matches("[0-9]+")) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Number must be 10 characters long, only digits [0-9] are allowed");
        }
    }

    // See all info

    public void displayInfo() {
        System.out.println("ID: " + this.ID);
        System.out.println(this.firstName);
        System.out.println(this.lastName);
        System.out.println(this.address);
        System.out.println(this.number);
    }

    // Fix to get readable information from map.get() in ContactServices
    @Override
    public String toString() {
        return "Contact{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Contact newContact = new Contact("123ABC", "Caio", "Mauro", "115 Surfbird", "9789771153");
        newContact.displayInfo();
    }
}
