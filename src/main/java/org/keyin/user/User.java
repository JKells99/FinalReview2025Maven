package org.keyin.user;

public class User {
//    Fields
    private int user_Id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String sector; ;


    // Constructors
    public User(int user_Id, String username, String email, String password, String role, String sector) {
        this.user_Id = user_Id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.sector = sector;
    }

    public User(String username, String email, String password, String role, String sector) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.sector = sector;
    }

    // Getters and Setters
    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    // Methods go after getters and setters

    @Override
    public String toString() {
        return "User{" +
                "user_Id=" + user_Id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", sector='" + sector + '\'' +
                '}';
    }
}
