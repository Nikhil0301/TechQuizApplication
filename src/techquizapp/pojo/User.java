/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

/**
 *
 * @author hp
 */
public class User {
    private String userId;
    private String password;
    private String userType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUsertype(String userType) {
        this.userType = userType;
    }
    /*
USERID     PASSWORD   USERTYPE
---------- ---------- ----------
amit       abcd       student
sumit      demo       student
sachin     sca        Admin
deepak     deep       student
    */
}
