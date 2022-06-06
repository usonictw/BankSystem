import java.util.Random;

public class User {

    private InfoUser infoUser;
    private Card card;
    private long id;


    User(){

    }

    void setUser(long id){
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
        return "User{" +
                "infoUser=" + infoUser +
                ", card=" + card +
                ", id=" + id +
                '}';
    }
}
