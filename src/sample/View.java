package sample;

public class View {
    private final int frameRate=15;

    private static View view;
    public static View getInstance() {
        if(view==null){
            view=new View();
        }
        return view;
    }

    public static int getFrameRate() {
        return frameRate;
    }
}
