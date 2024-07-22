package com.example.btl_api.object;

public class ChangePass {
    private String UserName, PassWord, newPass;

    public ChangePass( String newPass,String userName, String passWord) {
        UserName = userName;
        PassWord = passWord;
        this.newPass = newPass;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
