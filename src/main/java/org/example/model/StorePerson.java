package org.example.model;

public class StorePerson {

    String  accountlogin;
    String accountid;
    String status;
    String email;


    public StorePerson() {

    }

    public StorePerson( String accountlogin, String accountid, String status,
                       String email) {


        this.accountlogin = accountlogin;
        this.accountid = accountid;
        this.status = status;
        this.email = email;
    }


    public String getAccountlogin() {
        return accountlogin;
    }

    public void setAccountlogin(String accountlogin) {
        this.accountlogin = accountlogin;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
