package sample;

import javafx.geometry.Point2D;

import java.util.ArrayList;

public class Model {
    private Account account;
    private ArrayList<Component> friendlyComponent;
    private ArrayList<Component> enemyComponent;
    private ElixirGenerator friendlyElixir;
    private ElixirGenerator enemyElixir;
    private MyTimer timer;
    private final int frameRate;
    private Bridge bridge1;
    private Bridge bridge2;



    public Model(){
        friendlyComponent=new ArrayList<>();
        enemyComponent=new ArrayList<>();
        frameRate=View.getInstance().getFrameRate();
        friendlyElixir  = new ElixirGenerator(frameRate, 3);
        enemyElixir  = new ElixirGenerator(frameRate, 3);
        timer=new MyTimer(frameRate,180);

    }


    private static Model model;
    public static Model getInstance() {
        if(model==null){
            model=new Model();
        }
        return model;
    }


    public void initialize(){
        bridge1=new Bridge(new Point2D(375,90),0,null);
        bridge2=new Bridge(new Point2D(375,350),0,null);

    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
