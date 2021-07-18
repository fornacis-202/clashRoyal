package sample;

public class MyTimer {
    private int frameRate;
    private int seconds;
    public MyTimer(int frameRate , int seconds){
        this.frameRate=frameRate;
        this.seconds=seconds;
    }

    public int getSeconds() {
        return seconds;
    }
    public void step(long counter){
        if(seconds>0 && counter%frameRate==0)
            seconds--;
    }
}
