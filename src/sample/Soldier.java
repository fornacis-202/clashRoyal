package sample;

import javafx.geometry.Point2D;

public abstract class Soldier extends Force{
    private Speed speed;
    public Soldier(Point2D position , int range, Role role, double hitSpeed, int HP, int damage, Class targetType, boolean isAreaSplash, Speed speed){
        super(position, range,role, hitSpeed, HP, damage, targetType, isAreaSplash);
        this.speed=speed;
    }

    public Speed getSpeed() {
        return speed;
    }
    public void move(Point2D addingPosition){
        setPosition(getPosition().add(addingPosition.multiply(speed.getNumVal())));
    }
}
