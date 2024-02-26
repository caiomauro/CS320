package com.example;

import java.util.HashMap;

public class ContactService {
    HashMap<String, Contact> ContactList = new HashMap<String, Contact>();

    public ContactService() {
        this.ContactList = new HashMap<String, Contact>();
    }

    // Create contact, auto add to map
    public void createContact(String ID, String firstName, String lastName, String address, String number) {
        Contact newContact = new Contact(ID, firstName, lastName, address, number);
        if (ContactList.containsKey(newContact.ID)) {
            throw new IllegalArgumentException("Attempted to add contact but ID already exists");
        } else {
            ContactList.put(ID, newContact);
        }
    }

    // Delete contact, removes from map
    public void deleteContact(String ID) {
        if (ContactList.containsKey(ID)) {
            ContactList.remove(ID);
        } else {
            throw new IllegalArgumentException("Attempted to delete contact but ID does not exist in map");
        }
    }

    // Update methods
    public void updateFirstName(String ID, String firstName) {
        if (ContactList.containsKey(ID)) {
            Contact contact = ContactList.get(ID);
            contact.setFirstName(firstName);
        } else {
            throw new IllegalArgumentException(
                    "Attempted to update First Name for ID: " + ID + " but contact does not exist");
        }
    }

    public void updateLastName(String ID, String lastName) {
        if (ContactList.containsKey(ID)) {
            Contact contact = ContactList.get(ID);
            contact.setLastName(lastName);
        } else {
            throw new IllegalArgumentException(
                    "Attempted to update Last Name for ID: " + ID + " but contact does not exist");
        }
    }

    public void updateAddress(String ID, String address) {
        if (ContactList.containsKey(ID)) {
            Contact contact = ContactList.get(ID);
            contact.setAddress(address);
        } else {
            throw new IllegalArgumentException(
                    "Attempted to update Address for ID: " + ID + " but contact does not exist");
        }
    }

    public void updateNumber(String ID, String number) {
        if (ContactList.containsKey(ID)) {
            Contact contact = ContactList.get(ID);
            contact.setNumber(number);
        } else {
            throw new IllegalArgumentException(
                    "Attempted to update Number for ID: " + ID + " but contact does not exist");
        }
    }

    // Display methods
    public void displayKeys() {
        for (String i : ContactList.keySet()) {
            System.out.println(i);
        }
    }

    public void displayObjects() {
        for (String i : ContactList.keySet()) {
            System.out.println(ContactList.get(i));
        }
    }

    public static void main(String[] args) {
        ContactService NewService = new ContactService();

        // Sample Data
        NewService.createContact("123ABC", "Caio", "Mauro", "115 Surfbird", "1234567890");
        NewService.createContact("456DEF", "Ariel", "Mauro", "115 Surfbird", "1234567899");
        NewService.displayObjects();
    }
}
