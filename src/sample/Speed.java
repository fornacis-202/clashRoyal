package sample;

public enum Speed {
    FAST(4),MEDIUM(3),SLOW(2);
    private int numVal;

    Speed(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }

}
