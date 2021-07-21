package sample;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Card.
 */
public class Card implements Serializable {
    private Role role;
    private int count;
    private int cost;
    private int level;
    private String photo;

    /**
     * Instantiates a new Card.
     *
     * @param role  the role
     * @param count the count
     * @param cost  the cost
     * @param level the level
     * @param photo the photo
     */
    public Card(Role role,int count,int cost,int level,String photo){
        this.cost=cost;
        this.count=count;
        this.role=role;
        this.level=level;
        this.photo=photo;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * Gets photo.
     *
     * @return the photo
     */
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
