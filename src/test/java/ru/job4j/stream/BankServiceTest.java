package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BankServiceTest {
    @Test
    void whenUserWasFound() {
        Map<User, List<Account>> users = Map.of(
                new User("123", "name_1"), List.of(
                        new Account("321123", 200D),
                        new Account("123321", 100D)
                )
        );
        User result = new BankService(users).findByPassport("123");
        User expected = new User("123", "name_1");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenUserWasNotFound() {
        Map<User, List<Account>> users = Map.of(
                new User("123", "name_1"), List.of(
                        new Account("321123", 200D),
                        new Account("123321", 100D)
                )
        );
        User result = new BankService(users).findByPassport("321");
        assertThat(result).isNull();
    }

    @Test
    void whenAccountWasFound() {
        Map<User, List<Account>> users = Map.of(
                new User("123", "name_1"), List.of(
                        new Account("321123", 200D),
                        new Account("123321", 100D)
                )
        );
        Account result = new BankService(users).findByRequisite("123", "321123");
        Account expected = new Account("321123", 200D);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenAccountWasNotFound() {
        Map<User, List<Account>> users = Map.of(
                new User("123", "name_1"), List.of(
                        new Account("321123", 200D),
                        new Account("123321", 100D)
                )
        );
        Account result = new BankService(users).findByRequisite("123", "123456");
        assertThat(result).isNull();
    }
}