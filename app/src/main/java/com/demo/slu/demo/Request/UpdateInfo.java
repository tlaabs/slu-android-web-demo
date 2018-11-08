package com.demo.slu.demo.Request;

public class UpdateInfo {
    private String usernpwd1;
    private String usernpwd2;

    public UpdateInfo(String usernpwd1, String usernpwd2){
        this.usernpwd1 = usernpwd1;
        this.usernpwd2 = usernpwd2;
    }

    public String getUsernpwd1() {
        return usernpwd1;
    }

    public void setUsernpwd1(String usernpwd1) {
        this.usernpwd1 = usernpwd1;
    }

    public String getUsernpwd2() {
        return usernpwd2;
    }

    public void setUsernpwd2(String usernpwd2) {
        this.usernpwd2 = usernpwd2;
    }
}
