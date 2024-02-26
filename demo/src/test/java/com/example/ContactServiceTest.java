package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testCreateContact() {
        contactService.createContact("123ABC", "John", "Doe", "123 Main St", "555-1234");
        assertNotNull(contactService.ContactList.get("123ABC"));
    }

    @Test
    public void testCreateContactWithExistingID() {
        contactService.createContact("123ABC", "John", "Doe", "123 Main St", "555-1234");
        assertThrows(IllegalArgumentException.class,
                () -> contactService.createContact("123ABC", "Jane", "Doe", "456 Oak St", "555-5678"));
    }

    @Test
    public void testDeleteContact() {
        contactService.createContact("123ABC", "John", "Doe", "123 Main St", "555-1234");
        contactService.deleteContact("123ABC");
        assertNull(contactService.ContactList.get("123ABC"));
    }

    @Test
    public void testDeleteNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("123ABC"));
    }

    @Test
    public void testUpdateFirstName() {
        contactService.createContact("123ABC", "John", "Doe", "123 Main St", "555-1234");
        contactService.updateFirstName("123ABC", "Jane");
        assertEquals("Jane", contactService.ContactList.get("123ABC").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        contactService.createContact("123ABC", "John", "Doe", "123 Main St", "555-1234");
        contactService.updateLastName("123ABC", "Smith");
        assertEquals("Smith", contactService.ContactList.get("123ABC").getLastName());
    }

    @Test
    public void testUpdateAddress() {
        contactService.createContact("123ABC", "John", "Doe", "123 Main St", "555-1234");
        contactService.updateAddress("123ABC", "456 Oak St");
        assertEquals("456 Oak St", contactService.ContactList.get("123ABC").getAddress());
    }

    @Test
    public void testUpdateNumber() {
        contactService.createContact("123ABC", "John", "Doe", "123 Main St", "555-1234");
        contactService.updateNumber("123ABC", "555-5678");
        assertEquals("555-5678", contactService.ContactList.get("123ABC").getNumber());
    }

    @Test
    public void testUpdateLastNameNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> contactService.updateLastName("123ABC", "Smith"));
    }

    @Test
    public void testUpdateAddressNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> contactService.updateAddress("123ABC", "456 Oak St"));
    }

    @Test
    public void testUpdateNumberNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> contactService.updateNumber("123ABC", "555-5678"));
    }

    @Test
    public void testDisplayKeys() {
        contactService.createContact("123ABC", "John", "Doe", "123 Main St", "555-1234");
        contactService.createContact("456DEF", "Jane", "Doe", "456 Oak St", "555-5678");
        contactService.displayKeys();
        assertEquals("123ABC\n456DEF\n", outputStream.toString());
    }

    @Test
    public void testDisplayObjects() {
        contactService.createContact("123ABC", "John", "Doe", "123 Main St", "555-1234");
        contactService.createContact("456DEF", "Jane", "Doe", "456 Oak St", "555-5678");
        contactService.displayObjects();
        assertEquals(
                "Contact{id='123ABC', firstName='John', lastName='Doe', address='123 Main St', number='555-1234'}\n" +
                        "Contact{id='456DEF', firstName='Jane', lastName='Doe', address='456 Oak St', number='555-5678'}\n",
                outputStream.toString());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
