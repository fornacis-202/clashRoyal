package sample;

public class SharedData {
    private static Account account;
    private static Bot bot;

    public static void setBot(Bot bot) {
        SharedData.bot = bot;
    }

    public static Bot getBot() {
        return bot;
    }

    public static void setAccount(Account account) {
        SharedData.account = account;
    }

    public static Account getAccount() {
        return account;
    }
}
