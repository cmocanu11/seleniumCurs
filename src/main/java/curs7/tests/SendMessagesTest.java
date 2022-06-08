package curs7.tests;

import curs7.pages.ContactsPage;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Screenshots;

import static org.testng.AssertJUnit.*;

public class SendMessagesTest extends BaseTest {

    @Test
    public void sendMessageReturnsSuccessMessage() {

        ContactsPage contactsPage = navMenu.navToContactsPage();
        contactsPage.sendMessage("Test", "test@ceva.com", "Test Subject", "Test Message");
        assertTrue(contactsPage.returnMessageSentInfo("Thank you for your message. It has been sent."));
    }

    @Test
    public void sendMessageWithoutNameReturnsFalse(){
        ContactsPage contactsPage = navMenu.navToContactsPage();
        contactsPage.sendMessage("", "test@ceva.com", "Test Subject", "Test Message");
        assertTrue(contactsPage.emptyFieldWarningMessage());
        assertTrue(contactsPage.returnMessageSentInfo("One or more fields have an error. Please check and try again."));
    }
}
