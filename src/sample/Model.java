package sample;

public class Model {
    private Account account;

    private static Model model;
    public static Model getInstance() {
        if(model==null){
            model=new Model();
        }
        return model;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
