package sample;

import javafx.geometry.Point2D;

public class Spell extends Component{
    private Double duration;
    private double parameter;
    public Spell(Point2D position , int range,Role role, double parameter,Double duration){
        super(position,range,role);
        this.duration=duration;
        this.parameter=parameter;
    }

    public double getParameter() {
        return parameter;
    }

    public double getDuration() {
        return duration;
    }
    public void stepDuration(int frameRate){
        duration-=1.0/frameRate;
    }
}
