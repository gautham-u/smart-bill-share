package com.flipkart.smartbill.service;

import com.flipkart.smartbill.enitity.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemberService {

    private static Map<String,Member> members = new HashMap<>();

    public boolean addMember(Member member) {
        if (members.containsKey(member.getEmailId())) {
            return false;
        }
        members.put(member.getEmailId(),member);
        return true;
    }

    public Member getMember(String emailId) {
        return members.getOrDefault(emailId,null);
    }

    public void cmdAddMember() {
        Scanner in = new Scanner(System.in);
        System.out.println("Add Member");
        Member member = new Member();
        System.out.println("Enter Email ID:");
        member.setEmailId(in.next());
        System.out.println("Enter Name:");
        member.setName(in.next());
        if (addMember(member)) {
            System.out.println("Member was added Successfully");
        } else {
            System.out.println("Member Already Exists");
        }
    }
}
