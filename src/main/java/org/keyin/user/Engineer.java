package org.keyin.user;

public class Engineer extends User {
    public Engineer(String username, String email, String password, String sector) {
        super(username, email, password, "Engineer", sector);
    }
}
