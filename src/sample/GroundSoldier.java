package sample;

import javafx.geometry.Point2D;

public class GroundSoldier extends Soldier implements Ground{
    public GroundSoldier(Point2D position , double range, Role role, double hitSpeed, int HP, int damage, Class targetType, boolean isAreaSplash, Speed speed){
        super(position, range,role, hitSpeed, HP, damage, targetType, isAreaSplash,speed);

    }


}
