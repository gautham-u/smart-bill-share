package com.flipkart.smartbill.service;

import com.flipkart.smartbill.SmartBillException;
import com.flipkart.smartbill.enitity.BillShare;
import com.flipkart.smartbill.enitity.Group;
import com.flipkart.smartbill.enitity.Member;
import com.flipkart.smartbill.enitity.Share;

import java.util.*;

public class GroupService {

    private static Map<String, Group> groupMap = new HashMap<>();

    private MemberService memberService = new MemberService();

    public boolean addGroup(Group group) {
        if (groupMap.containsKey(group.getGroupId())) {
            return false;
        }
        groupMap.put(group.getGroupId(), group);
        return true;
    }

    public void updateGroup (Group group) {
        groupMap.put(group.getGroupId(), group);
    }

    public Group getGroup(String groupId) {
        return groupMap.getOrDefault(groupId,null);
    }

    public void cmdAddGroup() throws SmartBillException {
        Scanner in = new Scanner(System.in);
        System.out.println("Add Group");
        Group group = new Group();
        System.out.println("Enter Group ID:");
        group.setGroupId(in.next());
        if (getGroup(group.getGroupId()) != null)
            throw new SmartBillException("Group Id already Exists");
        System.out.println("Enter Group Name:");
        group.setGroupName(in.next());
        System.out.println("Add new Member email ID or enter STOP ");
        String input = in.next();
        Set<String> members = new HashSet<>();
        List<Member> groupMembers = new ArrayList<>();
        while (!input.equalsIgnoreCase("STOP")) {
            if ( input.isEmpty() || memberService.getMember(input) == null || members.contains(input)) {
                System.out.println("Member is null or already added");
            } else {
                members.add(input);
                groupMembers.add(memberService.getMember(input));
                System.out.println("Member added to group "+ group.getGroupName());
            }
            System.out.println("Add new Member email ID or enter STOP ");
            input = in.next();
        }
        if (members.isEmpty()) {
            throw new SmartBillException("No Members are added to the group");
        }
        group.setMembers(groupMembers);
        addGroup(group);
        System.out.println("Group has been added");
    }

    public void calculateAllBills() {
        for (String key : groupMap.keySet()) {
            groupPerMemberCalculation(key);
        }
    }

    private void groupPerMemberCalculation(String key) {
        Group group = groupMap.get(key);
        Map<String,Double> evaluation = new HashMap<>();
        for (BillShare billShare : group.getBillPaid()) {
            for (Share share : billShare.getShares()) {
                if (evaluation.containsKey(share.getEmailId())) {
                    evaluation.put(share.getEmailId(), evaluation.get(share.getEmailId()) + share.getShare());
                } else {
                    evaluation.put(share.getEmailId(), share.getShare());
                }
            }
        }
        for (BillShare billShare : group.getBillShares()) {
            for (Share share : billShare.getShares()) {
                if (evaluation.containsKey(share.getEmailId())) {
                    evaluation.put(share.getEmailId(), evaluation.get(share.getEmailId()) - share.getShare());
                } else {
                    evaluation.put(share.getEmailId(), share.getShare());
                }
            }
        }
        for (String mem : evaluation.keySet()) {
            System.out.println("Group Name: "+group.getGroupName()+ " Person: "+memberService.getMember(mem).getName() +" Price: "+ evaluation.get(mem));
        }
    }
}
