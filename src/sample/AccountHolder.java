package sample;

public class AccountHolder {
    private static Account account;

    public static void setAccount(Account account) {
        AccountHolder.account = account;
    }

    public static Account getAccount() {
        return account;
    }
}
