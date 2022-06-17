package com.flipkart.smartbill.enitity;

public class Member {

    private String emailId;
    private String name;

    public Member() {
    }

    public Member(String emailId, String name) {
        this.emailId = emailId;
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member{" +
                "emailId='" + emailId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
