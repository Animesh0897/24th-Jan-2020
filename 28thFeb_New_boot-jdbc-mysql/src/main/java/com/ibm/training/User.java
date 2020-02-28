package com.ibm.training;
 
public class User {
    int userID;
    String userName, userAddress;
    
     
    public User(String userName, String userAddress) {
 
        this.userName = userName;
        this.userAddress = userAddress;
    }
    public User() {
         
    }
    public int getUserID() {
        return userID;
    }
 
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}