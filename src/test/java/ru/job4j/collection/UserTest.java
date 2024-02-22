package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> iterator = users.iterator();
        assertThat(iterator.next()).isEqualTo(new User("Ivan", 31));
        assertThat(iterator.next()).isEqualTo(new User("Petr", 32));
    }

    @Test
    public void whenAscForUsersWithEqualNameButDifferentAge() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 35));
        users.add(new User("Ivan", 31));
        users.add(new User("Petr", 25));
        users.add(new User("Ivan", 29));
        users.add(new User("Petr", 33));
        users.add(new User("Ivan", 27));
        Set<User> expected = new TreeSet<>(
                Arrays.asList(
                        new User("Ivan", 27),
                        new User("Ivan", 29),
                        new User("Ivan", 31),
                        new User("Petr", 25),
                        new User("Petr", 33),
                        new User("Petr", 35)
                )
        );
        assertThat(users).containsSequence(expected);
    }

    @Test
    public void whenComparePetrVSIvan() {
        int result = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparePetrVSPetrWithDifferentAge() {
        int result = new User("Petr", 31)
                .compareTo(
                        new User("Petr", 32)
                );
        assertThat(result).isLessThan(0);
    }
}