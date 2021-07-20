package sample;

import javafx.geometry.Point2D;

public abstract class Component {
    private Point2D position;
    private double range;
    private Role role;

    public Component(Point2D position , double range,Role role){
        this.position=position;
        this.range=range;
        this.role=role;
    }

    public Role getRole() {
        return role;
    }

    public double getRange() {
        return range;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }
}
