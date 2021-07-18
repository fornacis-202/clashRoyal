package sample;

import java.util.ArrayList;

public class CardGenerator {
    public static ArrayList<Card> generate(int level){
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Role.BARBARIAN,4,5,level,"file:images/barbar/card.png"));
        cards.add(new Card(Role.ARCHER,2,3,level,"file:images/archer/card.png"));
        cards.add(new Card(Role.DRAGON,1,4,level,"file:images/dragon/card.png"));
        cards.add(new Card(Role.WIZARD,1,5,level,"file:images/wizard/card.png"));
        cards.add(new Card(Role.PEKKA,1,4,level,"file:images/peka/card.png"));
        cards.add(new Card(Role.GIANT,1,5,level,"file:images/giant/card.png"));
        cards.add(new Card(Role.VALKYRIE,1,5,level,"file:images/valkyrie/card.png"));
        cards.add(new Card(Role.RAGE,1,3,level,"file:images/rage/card.png"));
        cards.add(new Card(Role.FIRE_BALL,1,4,level,"file:images/fire ball/card.png"));
        cards.add(new Card(Role.ARROW,1,3,level,"file:images/arrows/card.png"));
        cards.add(new Card(Role.CANNON,1,6,level,"file:images/cannon/card.png"));
        cards.add(new Card(Role.INFERNO,1,5,level,"file:images/inferno/card.png"));

        return cards;

    }


}
