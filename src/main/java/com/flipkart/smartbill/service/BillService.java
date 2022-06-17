package com.flipkart.smartbill.service;

import com.flipkart.smartbill.SmartBillException;
import com.flipkart.smartbill.enitity.*;

import java.util.*;

public class BillService {

    private GroupService groupService = new GroupService();

    private static Map<String, Bill> billMap = new HashMap<>();

    public boolean addBill(Bill bill) {
        if (billMap.containsKey(bill.getBillId())) {
            return false;
        }
        billMap.put(bill.getBillId(), bill);
        return true;
    }

    public Bill getBill(String billId) {
        return billMap.getOrDefault(billId, null);
    }

    public void cmdAddBill() throws SmartBillException{
        System.out.println("Add New Bill");
        Bill bill = new Bill();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Bill ID");
        String input = in.next();
        if (getBill(input) != null)
            throw new SmartBillException("Bill Id already Exist");
        bill.setBillId(input);
        System.out.println("Enter bill amount (ex: 3000.00)");
        bill.setBillAmount(in.nextDouble());
        System.out.println("Enter the Group Id");
        input = in.next();
        Group group = groupService.getGroup(input);
        if (group == null)
            throw new SmartBillException("Group not valid");
        bill.setGroup(group);

        System.out.println("Members Owes");

        BillShare billShare = new BillShare();
        billShare.setBillId(bill.getBillId());
        List<Share> shares = new ArrayList<>();
        Double count = 0.0;
        Double price = 0.0;
        for (Member member : group.getMembers()) {
            System.out.println("Enter the share for member - "+member.getName());
            price = in.nextDouble();
            shares.add(new Share(member.getEmailId(), price));
            count +=price;
            if (bill.getBillAmount() < count)
                throw new SmartBillException("Price is greater than share");
        }
        billShare.setShares(shares);
        List<BillShare> groupBills = group.getBillShares();
        if (groupBills == null)
            groupBills = new ArrayList<>();
        groupBills.add(billShare);


        group.setBillShares(groupBills);


        System.out.println("Bill Paid by ");
        count = 0.0;
        price = 0.0;
        BillShare paidShare = new BillShare();
        paidShare.setBillId(bill.getBillId());
        List<Share> paid = new ArrayList<>();
        for (Member member : group.getMembers()) {
            System.out.println("Enter the paid by member - "+member.getName());
            price = in.nextDouble();
            paid.add(new Share(member.getEmailId(), price));
            count +=price;
            if (bill.getBillAmount() < count)
                throw new SmartBillException("Price is greater than Paid");
        }
        paidShare.setShares(paid);
        List<BillShare> paidBills = group.getBillPaid();
        if (paidBills == null)
            paidBills = new ArrayList<>();
        paidBills.add(paidShare);
        group.setBillPaid(paidBills);
        groupService.updateGroup(group);
        bill.setShares(shares);
        addBill(bill);
    }
}
