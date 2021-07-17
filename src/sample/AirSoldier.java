package sample;

import javafx.geometry.Point2D;

public class AirSoldier extends Force{
    private Speed speed;
    public AirSoldier(Point2D position , int range, Role role, double hitSpeed, int HP, int damage, Class targetType, boolean isAreaSplash, Speed speed){
        super(position, range,role, hitSpeed, HP, damage, targetType, isAreaSplash);
        this.speed=speed;
    }

    public Speed getSpeed() {
        return speed;
    }
}
