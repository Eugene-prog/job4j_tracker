package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestDoublePassport() {
        Citizen citizen1 = new Citizen("0111", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        Citizen citizen2 = new Citizen("0111", "Ivan Ivanov");
        assertThat(office.add(citizen2)).isFalse();
    }
}