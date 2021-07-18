package sample;

public class ElixirGenerator {
    private int amount;
    private int frameRate;
    public ElixirGenerator(int frameRate , int amount){
        this.amount=amount;
        this.frameRate=frameRate;
    }

    public int getAmount() {
        return amount;
    }
    public void reduceAmount(int cost){
        amount-=cost;
    }
    public void step(long counter){
        if(counter < 2L *60*frameRate){
            if(counter%(2*frameRate)==0 && amount<10){
                amount++;
            }
        }else {
            if(counter%frameRate==0 && amount<10){
                amount++;
            }

        }
    }
}
