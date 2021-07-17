package sample;

import javafx.geometry.Point2D;

public class DefenseBuilding extends Force implements Ground{
    private Double duration;
    public DefenseBuilding(Point2D position , int range, Role role, double hitSpeed, int HP, int damage, Class targetType, boolean isAreaSplash , Double duration){
        super(position, range, role, hitSpeed, HP, damage, targetType, isAreaSplash);
        this.duration=duration;
    }
    public void stepDuration(int frameRate){
        duration-=1.0/frameRate;
    }

    public Double getDuration() {
        return duration;
    }
}
