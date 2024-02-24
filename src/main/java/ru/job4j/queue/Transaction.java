package ru.job4j.queue;

public class Transaction {
    private int id;

    private String purpose;

    private int amount;

    public Transaction(int id, String purpose, int amount) {
        this.id = id;
        this.purpose = purpose;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "id=" + id
                + ", purpose='" + purpose + '\''
                + ", amount=" + amount
                + '}';
    }
}