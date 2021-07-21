package sample;

/**
 * The type Shared data.
 */
public class SharedData {
    private static Account account;
    private static Bot bot;

    /**
     * Sets bot.
     *
     * @param bot the bot
     */
    public static void setBot(Bot bot) {
        SharedData.bot = bot;
    }

    /**
     * Gets bot.
     *
     * @return the bot
     */
    public static Bot getBot() {
        return bot;
    }

    /**
     * Sets account.
     *
     * @param account the account
     */
    public static void setAccount(Account account) {
        SharedData.account = account;
    }

    /**
     * Gets account.
     *
     * @return the account
     */
    public static Account getAccount() {
        return account;
    }
}
