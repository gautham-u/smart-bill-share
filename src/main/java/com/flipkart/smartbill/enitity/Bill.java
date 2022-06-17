package com.flipkart.smartbill.enitity;

import java.util.List;

public class Bill {

    private String billId;

    private double billAmount;

    private Group group;

    private List<Share> shares;

    public Bill(String billId, double billAmount, Group group, List<Share> shares) {
        this.billId = billId;
        this.billAmount = billAmount;
        this.group = group;
        this.shares = shares;
    }

    public Bill() {
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", billAmount=" + billAmount +
                ", group=" + group +
                ", shares=" + shares +
                '}';
    }
}
