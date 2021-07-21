package sample;

/**
 * The type My timer.
 */
public class MyTimer {
    private int frameRate;
    private int seconds;

    /**
     * Instantiates a new My timer.
     *
     * @param frameRate the frame rate
     * @param seconds   the seconds
     */
    public MyTimer(int frameRate , int seconds){
        this.frameRate=frameRate;
        this.seconds=seconds;
    }

    /**
     * Gets seconds.
     *
     * @return the seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Step.
     *
     * @param counter the counter
     */
    public void step(long counter){
        if(seconds>0 && counter%frameRate==0)
            seconds--;
    }
}
