package com.uc7addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookDirectory implements AddressBookDirectoryIF{
    Scanner scannerObject =new Scanner(System.in);
    Map<String ,AddressBook> addressBookDirectory=new HashMap<String, AddressBook>();

    @Override
    public void OperationDirectory() {
        boolean moreChange = true;

        do {
            System.out.println("\nChoose the operation in the directory you want to perform");
            System.out.println("1.Add anAddressBook Directory \n2.Display AddressBook Directory\n 3.Exit AddressBook System");
            switch (scannerObject.nextInt()) {
                case 1:
                    addAddressBook();
                    AddressBook addressBook = new AddressBook();
                    addressBook.addContact();
                    break;
                case 2:
                    displayDirectoryContents();
                    AddressBook addressBook2 = new AddressBook();
                    addressBook2.displayContact();
                    break;
                case 3:
                    moreChange = false;
                    System.out.println("Exiting  Address Book Directory");

            }
        }
        while (moreChange);
    }
    @Override
    public void addAddressBook() {
        System.out.println("Enter the name of AddressBook you want to add");
        String bookNameToAdd=scannerObject.next();
        // code for name duplicity
        if(addressBookDirectory.containsKey(bookNameToAdd)){
            System.out.println("Book name already exists");
            return;

        }
        AddressBook addressBook =new AddressBook();
        addressBook.setAddressBookName(bookNameToAdd);
        addressBookDirectory.put(bookNameToAdd,addressBook);


    }

    @Override
    public void displayDirectoryContents() {
        System.out.println("------Contents of AddressBook Directory------");
        for(String eachBookName : addressBookDirectory.keySet()){
            System.out.println(eachBookName);
        }
        System.out.println("-------------------------------------------------------");
    }
}
