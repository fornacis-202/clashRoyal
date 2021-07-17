package sample;

import javafx.geometry.Point2D;

public abstract class Component {
    private Point2D position;
    private int range;
    private Role role;

    public Component(Point2D position , int range,Role role){
        this.position=position;
        this.range=range;
        this.role=role;
    }

    public Role getRole() {
        return role;
    }

    public int getRange() {
        return range;
    }

    public Point2D getPosition() {
        return position;
    }
}
