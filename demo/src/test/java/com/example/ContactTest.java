package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testConstructorWithValidInput() {
        Contact contact = new Contact("123ABC", "John", "Doe", "123 Main St", "5551234567");
        assertEquals("123ABC", contact.getId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("123 Main St", contact.getAddress());
        assertEquals("5551234567", contact.getNumber());
    }

    @Test
    public void testConstructorWithInvalidIDLength() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("123ABCDEFGHIJ", "John", "Doe", "123 Main St", "5551234567"));
    }

    @Test
    public void testConstructorWithInvalidFirstNameLength() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("123ABC", "JohnJohnJohn", "Doe", "123 Main St", "5551234567"));
    }

    @Test
    public void testConstructorWithInvalidNumberFormat() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("123ABC", "John", "Doe", "123 Main St", "555-123-4567"));
    }

    @Test
    public void testSetFirstNameWithValidInput() {
        Contact contact = new Contact("123ABC", "John", "Doe", "123 Main St", "5551234567");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testSetFirstNameWithInvalidInput() {
        Contact contact = new Contact("123ABC", "John", "Doe", "123 Main St", "5551234567");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JohnJohnJohn"));
    }

    @Test
    public void testSetNumberWithInvalidInput() {
        Contact contact = new Contact("123ABC", "John", "Doe", "123 Main St", "5551234567");
        assertThrows(IllegalArgumentException.class, () -> contact.setNumber("555-123-4567"));
    }

    @Test
    public void testDisplayInfo() {
        Contact contact = new Contact("123ABC", "John", "Doe", "123 Main St", "5551234567");
        contact.displayInfo();
    }

    @Test
    public void testToString() {
        Contact contact = new Contact("123ABC", "John", "Doe", "123 Main St", "5551234567");
        String expected = "Contact{ID='123ABC', firstName='John', lastName='Doe', address='123 Main St', number='5551234567'}";
        assertEquals(expected, contact.toString());
    }
}
