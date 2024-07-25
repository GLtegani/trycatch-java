package ex1.model.entities;

import ex1.model.exceptions.WithdrawException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public final Integer getNumber() {
        return number;
    }

    public final void setNumber(Integer number) {
        this.number = number;
    }

    public final String getHolder() {
        return holder;
    }

    public final void setHolder(String holder) {
        this.holder = holder;
    }

    public final Double getBalance() {
        return balance;
    }

    public final Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public final void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public final void deposit(Double amount) {
        this.balance += amount;
    }

    public final void validateWithdraw(Double amount) throws WithdrawException {
        if(amount > this.getWithdrawLimit()) {
            throw new WithdrawException("The amount exceeds withdraw limit");
        }
        if(this.getBalance() <= 0 || this.getBalance() < amount) {
            throw new WithdrawException("Not enough balance");
        }
    }

    public final void withdraw(Double amount) throws WithdrawException {
        this.validateWithdraw(amount);
        this.balance -= amount;
    }

    @Override
    public final String toString() {
        return "New balance: " + String.format("%.2f", this.balance);
    }
}
