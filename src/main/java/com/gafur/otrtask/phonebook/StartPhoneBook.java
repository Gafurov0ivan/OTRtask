package com.gafur.otrtask.phonebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartPhoneBook {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        String name = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        phoneBook.findPhones(name);
    }
}
