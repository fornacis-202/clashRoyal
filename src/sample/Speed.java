package sample;

/**
 * The enum Speed.
 */
public enum Speed {
    /**
     * Fast speed.
     */
    FAST(4),
    /**
     * Medium speed.
     */
    MEDIUM(3),
    /**
     * Slow speed.
     */
    SLOW(2);
    private int numVal;

    Speed(int numVal) {
        this.numVal = numVal;
    }

    /**
     * Gets num val.
     *
     * @return the num val
     */
    public int getNumVal() {
        return numVal;
    }

}
