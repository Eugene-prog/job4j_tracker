package ru.job4j.bank;

import java.util.Objects;

public class Account {
    private String requisite;
    private double balance;

    /**
     * Конструктор класса Account.
     *
     * @param requisite Реквизиты счета.
     * @param balance   Баланс счета.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Получает реквизиты счета.
     *
     * @return Реквизиты счета.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает реквизиты счета.
     *
     * @param requisite Новые реквизиты счета.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Получает баланс счета.
     *
     * @return Баланс счета.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает баланс счета.
     *
     * @param balance Новый баланс счета.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение метода equals для сравнения счетов на основе их реквизитов.
     *
     * @param o Объект для сравнения.
     * @return true, если счета имеют одинаковые реквизиты, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение метода hashCode для работы вместе с equals
     *
     * @return Хэш-код объекта счета на основе реквизитов.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}