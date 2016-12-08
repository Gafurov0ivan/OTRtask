package com.gafur.otrtask.phonebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private static Map<String, ArrayList<String>> phoneBook = new HashMap<String, ArrayList<String>>();

    public static void main(String[] args) throws IOException {

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

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        getPhones(name);
    }

    public static void getPhones(String name) {
        ArrayList<String> output = phoneBook.get(name);
        if (output.size() == 0) {
            System.out.println("Данного ФИО в БД нет");
        }
        for (int i = 0; i < output.size(); i++) {
            System.out.println((i + 1) + ". " + output.get(i));
        }
    }
}
