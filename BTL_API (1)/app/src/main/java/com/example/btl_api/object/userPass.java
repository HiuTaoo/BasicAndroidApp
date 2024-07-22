package com.example.btl_api.object;

public class userPass{
    private String UserName;
    private String Password;
    private String ID;

    public userPass(String userName, String password, String ID) {
        UserName = userName;
        Password = password;
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
