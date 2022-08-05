package com.uc7addressbook;

import java.util.*;

public class AddressBook implements AddressBookIF{
    Scanner scannerObject=new Scanner(System.in);
    Map<String ,ContactPerson> contactList =new HashMap<String, ContactPerson>();
    public static String addressBookName;
    Boolean isPresent =false;
    public String getAddressBookName(){
        return addressBookName;

    }
    public static void setAddressBookName(String bookNameToAdd){
        AddressBook.addressBookName=addressBookName;

    }



    @Override
    public void operation() {
        boolean moreChanges = true;
        do {
            System.out.println("\n Choose the operations you want to perform");
            System.out.println("1.Add to  AddressBook\n2.Display AddressBook");

            switch (scannerObject.nextInt()) {
                case 1:
                    addContact();
                    break;
                case 2:
                    displayContact();
                case 3:
                    moreChanges = false;
                    System.out.println("Exiting addressBook:" + this.getAddressBookName() + "!!!");

            }
        }
        while (moreChanges);
    }
    @Override
    public void addContact() {
        ContactPerson person =new ContactPerson();
        Address address =new Address();
        System.out.println("Enter First name");
        String firstName =scannerObject.next();
        contactList.entrySet().stream().forEach(entry ->{
            if(entry.getKey().equals(firstName.toLowerCase())){
                System.out.println("Contact Already Exist");
                isPresent=true;
                return;
            }
        });
        if(isPresent==false){
            System.out.println("Enter Last Name");
            String lastName =scannerObject.next();

            System.out.println("Enter Phone number");
            String phoneNumber = String.valueOf(scannerObject.nextLong());

            System.out.println("Enter Email");
            String email =scannerObject.next();

            System.out.println("Enter City ");
            String city =scannerObject.next();

            System.out.println("Enter State");
            String state =scannerObject.next();

            System.out.println("Enter ZipCode");
            String zip = String.valueOf(scannerObject.nextLong());

            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setPhoneNumber(Long.parseLong(phoneNumber));
            person.setEmail(email);
            address.setCity(city);
            address.setState(state);
            address.setZip(Long.parseLong(zip));
            person.setAddress(address);

            contactList.put(firstName.toLowerCase(),person);

        }
    }
    @Override
    public void displayContact() {
        System.out.println("-----Content of the addressBook"+this.getAddressBookName()+"-----------");
        for (String eachContact :contactList.keySet()){
            ContactPerson person = contactList.get(eachContact);
            System.out.println("person");
        }
        System.out.println("***********");
    }
}