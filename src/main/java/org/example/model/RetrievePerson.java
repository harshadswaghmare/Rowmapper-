package org.example.model;

public class RetrievePerson {


    String identifier;
    String  accountlogin;
    String accountid;
    String status;
    String email;


    public RetrievePerson() {

    }

    public RetrievePerson(String identifier, String accountlogin, String accountid, String status,
                          String email) {

        this.identifier = identifier;
        this.accountlogin = accountlogin;
        this.accountid = accountid;
        this.status = status;
        this.email = email;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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
