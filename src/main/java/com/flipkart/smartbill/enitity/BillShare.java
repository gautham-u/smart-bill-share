package com.flipkart.smartbill.enitity;

import java.util.List;

public class BillShare {

    private String billId;
    private List<Share> shares;

    public BillShare(String billId, List<Share> shares) {
        this.billId = billId;
        this.shares = shares;
    }

    public BillShare() {

    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }
}
