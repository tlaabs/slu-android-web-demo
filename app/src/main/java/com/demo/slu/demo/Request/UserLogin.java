package com.demo.slu.demo.Request;

public class UserLogin {
    private String userid;
    private String userpwd;

    public UserLogin(String userid, String userpwd){
        this.userid = userid;
        this.userpwd = userpwd;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
}
