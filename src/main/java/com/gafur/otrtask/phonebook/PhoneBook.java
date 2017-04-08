package com.gafur.otrtask.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Application to find phones from phone book
 *
 * @author igafurov
 * @since 05.12.2016
 */
public class PhoneBook {
    private static Map<String, ArrayList<String>> phoneBook = fillPhoneBook();

    /**
     * Find phones from phone book by name
     *
     * @param name name
     * @return phonesByName - list of phones
     */
    public ArrayList<String> findPhones(String name) {
        ArrayList<String> phonesByName = getPhones(name);
        return phonesByName;
    }

    private static Map<String, ArrayList<String>> fillPhoneBook() {
        Map<String, ArrayList<String>> phoneBook = new HashMap<String, ArrayList<String>>();

        ArrayList<String> ivanovPhones = new ArrayList<String>();
        ivanovPhones.add("+8 800 2000 500");
        ivanovPhones.add("+8 800 2000 600");

        ArrayList<String> petrovPhones = new ArrayList<String>();
        petrovPhones.add("+8 800 2000 700");

        ArrayList<String> sidorovPhones = new ArrayList<String>();
        sidorovPhones.add("+8 800 2000 800");
        sidorovPhones.add("+8 800 2000 900");
        sidorovPhones.add("+8 800 2000 000");

        phoneBook.put("Иванов И.И.", ivanovPhones);
        phoneBook.put("Петров П.П.", petrovPhones);
        phoneBook.put("Сидоров С.С.", sidorovPhones);

        return phoneBook;
    }

    private static ArrayList<String> getPhones(String name) {
        ArrayList<String> phones = new ArrayList<String>();
        if (phoneBook.containsKey(name)) {
            phones = phoneBook.get(name);
            if (phones.size() == 0) {
                System.out.println("У данного абонента телефонов в БД нет");
            }
            for (int i = 0; i < phones.size(); i++) {
                System.out.println((i + 1) + ". " + phones.get(i));
            }
        } else {
            System.out.println("Данного ФИО в БД нет");
        }
        return phones;
    }
}
