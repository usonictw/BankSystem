package entity;

import java.util.List;
import java.util.Objects;

public class Bank {

    private String bankName;
    private List<User> users;
    private Card cards;
    private float bankCommission;

    public Bank(String bankName, float bankCommission) {
        this.bankName = bankName;
        this.bankCommission = bankCommission;

    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Card getCards() {
        return cards;
    }


    public float getBankCommission() {
        return bankCommission;
    }

    public void setBankCommission(float bankCommission) {
        this.bankCommission = bankCommission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Float.compare(bank.getBankCommission(), getBankCommission()) == 0 && Objects.equals(getBankName(), bank.getBankName()) && Objects.equals(getUsers(), bank.getUsers()) && Objects.equals(getCards(), bank.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBankName(), getUsers(), getCards(), getBankCommission());
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", users=" + users +
                ", cards=" + cards +
                ", bankCommission=" + bankCommission +
                '}';
    }
}
