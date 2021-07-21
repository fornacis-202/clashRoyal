package sample;

import java.io.*;
import java.util.ArrayList;

/**
 * The type Account returner.
 */
public class AccountReturner {
    private ArrayList<User> users;

    /**
     * Instantiates a new Account returner.
     */
    public AccountReturner(){
        users=new ArrayList<>();
        loadUsers();
    }

    private void loadUsers(){
        try {

            FileInputStream fileInputStream = new FileInputStream("users");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            users = (ArrayList<User>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();

        }
        catch (IOException | ClassNotFoundException e){

        }
    }

    /**
     * Save users.
     */
    public void saveUsers(){
        try {
            File file = new File("users");
            FileOutputStream fileOutputStream = new FileOutputStream(file) ;
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(users);
            objectOutputStream.close();
            fileOutputStream.close();



        } catch (IOException e) {
            System.out.println("could not save file");
            e.printStackTrace();
        }

    }

    /**
     * Login account.
     *
     * @param username the username
     * @param password the password
     * @return the account
     */
    public Account login(String username,String password){
        User user = new User(username,password);
        for (User user1 : users){
            if(user1.equals(user)){
                Account account = Account.loadAccount(user.getName());
                return account;

            }
        }
        return null;
    }

    /**
     * Register account.
     *
     * @param username the username
     * @param password the password
     * @return the account
     */
    public Account register(String username,String password){
        User user = new User(username,password);
        for (User user1 : users){
            if(user1.getName().equals(user.getName())){
                return null;
            }
        }
        users.add(user);
        saveUsers();
        Account account = new Account(user.getName());
        account.saveAccount();
        return account;
    }




}
