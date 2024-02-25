package ru.job4j.bank;

import java.util.Objects;

public class User {
    private String passport;
    private String username;

    /**
     * Конструктор класса User.
     * @param passport Паспортные данные пользователя.
     * @param username Имя пользователя.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Получает паспортные данные пользователя.
     * @return Паспортные данные пользователя.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает паспортные данные пользователя.
     * @param passport Новые паспортные данные пользователя.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Получает имя пользователя.
     * @return Имя пользователя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя.
     * @param username Новое имя пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение метода equals для сравнения пользователей на основе паспортных данных.
     * @param o Объект для сравнения.
     * @return true, если пользователи имеют одинаковые паспортные данные, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение метода hashCode для работы вместе с equals
     * @return Хэш-код объекта пользователя на основе паспортных данных.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}