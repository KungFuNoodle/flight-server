package models;

public class User {
//veriables

    private String id, username, email, password;

//Constructor
    public User(String id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

//Getters
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + '}';
    }

}
