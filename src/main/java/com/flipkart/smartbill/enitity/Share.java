package com.flipkart.smartbill.enitity;

public class Share {


    private String emailId;

    private Double share;

    public Share(String emailId, Double share) {
        this.emailId = emailId;
        this.share = share;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Double getShare() {
        return share;
    }

    public void setShare(Double share) {
        this.share = share;
    }

    @Override
    public String toString() {
        return "Share{" +
                "emailId='" + emailId + '\'' +
                ", share='" + share + '\'' +
                '}';
    }
}
