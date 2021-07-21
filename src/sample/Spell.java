package sample;

import javafx.geometry.Point2D;

/**
 * The type Spell.
 */
public class Spell extends Component{
    private Double duration;
    private double parameter;

    /**
     * Instantiates a new Spell.
     *
     * @param position  the position
     * @param range     the range
     * @param role      the role
     * @param parameter the parameter
     * @param duration  the duration
     */
    public Spell(Point2D position , int range,Role role, double parameter,Double duration){
        super(position,range,role);
        this.duration=duration;
        this.parameter=parameter;
    }

    /**
     * Gets parameter.
     *
     * @return the parameter
     */
    public double getParameter() {
        return parameter;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Step duration.
     *
     * @param frameRate the frame rate
     */
    public void stepDuration(int frameRate){
        duration-=1.0/frameRate;
    }
}
