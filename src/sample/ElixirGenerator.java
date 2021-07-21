package sample;

/**
 * The type Elixir generator.
 */
public class ElixirGenerator {
    private int amount;
    private int frameRate;

    /**
     * Instantiates a new Elixir generator.
     *
     * @param frameRate the frame rate
     * @param amount    the amount
     */
    public ElixirGenerator(int frameRate , int amount){
        this.amount=amount;
        this.frameRate=frameRate;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Reduce amount.
     *
     * @param cost the cost
     */
    public void reduceAmount(int cost){
        amount-=cost;
    }

    /**
     * Step.
     *
     * @param counter the counter
     */
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
