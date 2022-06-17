package com.flipkart.smartbill;

import com.flipkart.smartbill.service.BillService;
import com.flipkart.smartbill.service.GroupService;
import com.flipkart.smartbill.service.MemberService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try {
            MemberService memberService = new MemberService();
            GroupService groupService = new GroupService();
            BillService billService = new BillService();

            Scanner in = new Scanner(System.in);
            System.out.println("Add Member? Y/N");
            String input = in.next();
            while(input.equalsIgnoreCase("Y")) {
                memberService.cmdAddMember();
                System.out.println("Add Member? Y/N");
                input = in.next();
            }
            System.out.println("Add Group? Y/N");
            input = in.next();
            while(input.equalsIgnoreCase("Y")) {
                groupService.cmdAddGroup();
                System.out.println("Add Group? Y/N");
                input = in.next();
            }
            System.out.println("Add Bill? Y/N");
            input = in.next();
            while(input.equalsIgnoreCase("Y")) {
                billService.cmdAddBill();
                System.out.println("Add Bill? Y/N");
                input = in.next();
            }
            groupService.calculateAllBills();
        }catch (SmartBillException e) {
            e.printStackTrace();
        }
    }
}
