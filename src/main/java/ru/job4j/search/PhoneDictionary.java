package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    private boolean personContainsKey(Person person, String key) {
        String personName = person.getName();
        String personSurname = person.getSurname();
        String personPhone = person.getPhone();
        String personAddress = person.getAddress();
        return personName.contains(key) || personSurname.contains(key)
                || personPhone.contains(key) || personAddress.contains(key);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (personContainsKey(person, key)) {
                result.add(person);
            }
        }
        return result;
    }
}