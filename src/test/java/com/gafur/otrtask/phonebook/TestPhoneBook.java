package com.gafur.otrtask.phonebook;

import org.hamcrest.collection.IsMapContaining;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class TestPhoneBook {
    private static final Class PHONEBOOK_CLASS = PhoneBook.class;
    private PhoneBook phoneBook = null;

    @Before
    public void before() throws IllegalAccessException, InstantiationException {
        phoneBook = (PhoneBook) PHONEBOOK_CLASS.newInstance();
    }

    @After
    public void after() {
        phoneBook = null;
    }

    @Test
    public void checkPhones() {
        PhoneBook phoneBook = new PhoneBook();
        ArrayList<String> check = phoneBook.findPhones("Петров П.П.");
        assertEquals(1, check.size());
    }

    @Test
    public void testAssertMap() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException {
        PhoneBook obj = new PhoneBook();

        Field f = obj.getClass().getDeclaredField("phoneBook");
        f.setAccessible(true);
        Map<String, ArrayList<String>> phoneBook = (Map<String, ArrayList<String>>) f.get(obj);

        Map<String, ArrayList<String>> expected = new HashMap<String, ArrayList<String>>();
        ArrayList<String> ivanovPhones = new ArrayList<String>();
        ivanovPhones.add("+8 800 2000 500");
        ivanovPhones.add("+8 800 2000 600");

        ArrayList<String> petrovPhones = new ArrayList<String>();
        petrovPhones.add("+8 800 2000 700");

        ArrayList<String> sidorovPhones = new ArrayList<String>();
        sidorovPhones.add("+8 800 2000 800");
        sidorovPhones.add("+8 800 2000 900");
        sidorovPhones.add("+8 800 2000 000");

        expected.put("Иванов И.И.", ivanovPhones);
        expected.put("Петров П.П.", petrovPhones);
        expected.put("Сидоров С.С.", sidorovPhones);

        //All passed / true

        //1. Test equal, ignore order
        assertThat(phoneBook, is(expected));

        //2. Test size
        assertThat(phoneBook.size(), is(3));

        //3. Test map entry
        assertThat(phoneBook, IsMapContaining.hasEntry("Иванов И.И.", ivanovPhones));

        assertThat(phoneBook, not(IsMapContaining.hasEntry("Алексеев А.А.", ivanovPhones)));

        //4. Test map key
        assertThat(phoneBook, IsMapContaining.hasKey("Петров П.П."));

        //5. Test map value
        assertThat(phoneBook, IsMapContaining.hasValue(sidorovPhones));
    }
}
