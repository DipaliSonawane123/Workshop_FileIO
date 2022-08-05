package com.uc7addressbook;

import org.w3c.dom.ls.LSOutput;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("***Welcome to Address Book program");
        AddressBookDirectory addressBookDirectory =new AddressBookDirectory();
        addressBookDirectory.OperationDirectory();

    }
}