package controllers;

import database.Database;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.User;

public class UserController {
//Veriables

    private Connection con;
//Constructor

    public UserController() {
        this.con = new Database().getCon();
    }
//CRUD

//create user
    public User create(String username, String email, String password) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate(""
                    + "Insert into userAccounts(username,email,password) "
                    + "values('" + username + "','" + email + "','" + password + "');"
            );

            //Retrive User
            ResultSet rs = con.createStatement().executeQuery("Select * from userAccounts where username ='" + username + "';");
            while (rs.next()) {
                User user = new User(
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                return user;
            }

        } catch (Exception e) {
            System.out.println("Create" + e);
        }
        return null;

    }
//Delete

    public void delete(String id) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate(""
                    + "Delete From userAccounts where id =" + id + ";");

        } catch (Exception e) {
            System.out.println("Delete" + e);
        }

    }

    ;
//Update
    public void update(String id, String username, String email, String password) {
        try {
            Statement st = con.createStatement();

            st.executeUpdate(""
                    + "update useraccounts "
                    + "set username = '" + username + "' "
                    + "where id = " + id + ";");
            st.executeUpdate(""
                    + "update useraccounts "
                    + "set email = '" + email + "' "
                    + "where id = " + id + ";");
            st.executeUpdate(""
                    + "update useraccounts "
                    + "set password = '" + password + "' "
                    + "where id = " + id + ";");

        } catch (Exception e) {
            System.out.println("Update:" + e);
        }
    }

//Read
    public User get(String id) {
        try {
            //Retrive User
            ResultSet rs = con.createStatement().executeQuery("Select * from userAccounts where id =" + id + ";");
            while (rs.next()) {
                User user = new User(
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                return user;
            }

        } catch (Exception e) {
            System.out.println("get:" + e);
        }
        return null;
    }

    ;
//multi read
public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            ResultSet rs = con.createStatement().executeQuery("Select * from userAccounts");
            while (rs.next()) {
                String id = rs.getString("id");
                User user = this.get(id);
                users.add(user);

            }

        } catch (Exception e) {
            System.out.println("Create" + e);
        }

        return users;
    }

    ;
    //Testing tools
  /*public static void main(String[] args) {
        //User user = new UserController().get("1");
        //System.out.println(user);
        //new UserController().delete("2");
        //new UserController().update("1", "UpdatedAdmin", "Updatedemail", "Updated");
        //new UserController().create("Nicole", "second user", "second");
        //new UserController().create("Frank", "third user", "third");
        ArrayList<User> users = new UserController().getAll();
        for (User user : users) {
            System.out.println(user);
        }

        //System.out.println(user);
    }*/

}
