public class Card {

    private long CardNumber;
    private short cvv;
    private long userId;
    private long balance;

    Card() {
        this.CardNumber = 0;
        this.cvv = 0;
        this.balance = 0;
    }

    public void createCard(long userId){
        this.CardNumber = (long) (Math.random() * 999999999);
        this.cvv = (short) (100 + (Math.random()*900));
        this.userId = userId;
    }

    public long getCardNumber() {
        return CardNumber;
    }

    public short getCvv() {
        return cvv;
    }

    public long getUserId() {
        return userId;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long amount) {
        this.balance = amount;
    }
}
