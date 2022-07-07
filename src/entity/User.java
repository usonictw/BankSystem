package entity;

import java.util.Objects;
import java.util.Random;

public class User {

    private InfoUser infoUser;
    private Card card;
    private long id;


    public  User(){

    }

    public void setUser(long id){
        infoUser = new InfoUser();
        infoUser.setInfo();
        this.id = id;
    }


    public InfoUser getInfo() {
        return infoUser;
    }

    public Card getCard() {
        return card;
    }



    public void setCard(Card card) {
        this.card = card;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "entity.User{" +
                "infoUser=" + infoUser +
                ", card=" + card +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() && infoUser.equals(user.infoUser) && getCard().equals(user.getCard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(infoUser, getCard(), getId());
    }
}
