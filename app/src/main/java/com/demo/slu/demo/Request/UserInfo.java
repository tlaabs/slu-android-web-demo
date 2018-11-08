package com.demo.slu.demo.Request;

/*
회원가입에 필요한 유저 정보를 담고 있는 객체

 */
public class UserInfo {
    private String email;
    private String state;
    private String userid;
    private String username;
    private String userpwd;

    public UserInfo(String email, String state, String userid, String username, String userpwd){
        this.email = email;
        this.state = state;
        this.userid = userid;
        this.username = username;
        this.userpwd = userpwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
}
