package com.flipkart.smartbill.enitity;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String groupId;

    private String groupName;

    private List<Member> members;

    private List<BillShare> billShares;

    private List<BillShare> billPaid;

    public Group() {
    }

    public Group(String groupId, String groupName, List<Member> members) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.members = members;
        this.billShares = new ArrayList<>();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<BillShare> getBillShares() {
        return billShares;
    }

    public void setBillShares(List<BillShare> billShares) {
        this.billShares = billShares;
    }

    public List<BillShare> getBillPaid() {
        return billPaid;
    }

    public void setBillPaid(List<BillShare> billPaid) {
        this.billPaid = billPaid;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                "member=" + members.toString()+ '\'' +
                '}';
    }
}
