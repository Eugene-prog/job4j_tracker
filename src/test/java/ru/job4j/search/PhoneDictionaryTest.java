package ru.job4j.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Ivanov", "+7(499)499-01-01", "Moscow")
        );
        var persons = phones.find("Ivan");
        assertThat(persons.get(0).getSurname()).isEqualTo("Ivanov");
    }

    @Test
    public void whenNotFind() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Ivanov", "+7(499)499-01-01", "Moscow")
        );
        var persons = phones.find("Ilya");
        assertTrue(persons.isEmpty());
    }
}