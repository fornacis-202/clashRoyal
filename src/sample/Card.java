package sample;

import java.io.Serializable;
import java.util.Objects;

public class Card implements Serializable {
    private Role role;
    private int count;
    private int cost;
    private int level;
    private String photo;
    public Card(Role role,int count,int cost,int level,String photo){
        this.cost=cost;
        this.count=count;
        this.role=role;
        this.level=level;
        this.photo=photo;
    }

    public Role getRole() {
        return role;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public int getCost() {
        return cost;
    }

    public int getCount() {
        return count;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return  role == card.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, count, cost, level, photo);
    }
}
