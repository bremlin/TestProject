package ru.sssproject.testex.utils;

import org.springframework.stereotype.Component;
import ru.sssproject.testex.objects.Member;
import ru.sssproject.testex.objects.MembersGroup;

import java.util.*;
@Component("dataClass")
public class DataClass {

    private int MIN_GROUP = 1;
    private int MAX_GROUP = 3;
    private int MIN_USER = 10;
    private int MAX_USER = 30;

    private int MAX_AGE = 80;

    public ArrayList<MembersGroup> getRandomData() {
        ArrayList<MembersGroup> membersGroups = generateMemberGroup(generateMembers());

        for (MembersGroup membersGroup : membersGroups) {
            System.out.println("Group: " + membersGroup.getGroupName());
            for (Member member : membersGroup.getMembers()) {
                System.out.println("name: " + member.getName() + " | age: " + member.getAge());
            }
            System.out.println("--------------------------------------");
        }

        return membersGroups;
    }

    private ArrayList<Member> generateMembers() {
        ArrayList<Member> membersList = new ArrayList<>();
        int membersCount = getRandomInt(MIN_USER, MAX_USER);
        for (int i = 0; i <= membersCount; i++) {
            Member member = new Member(getRandomName(), getRandomInt(1, MAX_AGE));
            membersList.add(member);
        }

        return membersList;
    }

    private Integer getRandomInt(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    private ArrayList<MembersGroup> generateMemberGroup(ArrayList<Member> members) {
        ArrayList<MembersGroup> memberGroupsList = new ArrayList<>();
        int groupsCount = getRandomInt(MIN_GROUP, MAX_GROUP);
        HashMap<Integer, ArrayList<Member>> memberMap = new HashMap<>();

        for (Member member : members) {
            int groupId = getRandomInt(0, groupsCount + 1);
            if (memberMap.containsKey(groupId)) {
                memberMap.get(groupId).add(member);
            } else {
                memberMap.put(groupId, new ArrayList<>(Collections.singletonList(member)));
            }
        }

        for (int i = 0; i <= groupsCount; i++) {
            MembersGroup membersGroup = new MembersGroup(getRandomName(), memberMap.get(i));
            memberGroupsList.add(membersGroup);
        }
        return memberGroupsList;
    }

    private String getRandomName() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 5;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public ArrayList<MembersGroup> getStaticData() {
        Member member1 = new Member("a", 10);
        Member member2 = new Member("b", 100);
        Member member3 = new Member("c", 1490);
        Member member4 = new Member("d", 49);
        Member member5 = new Member("e", 32);
        Member member6 = new Member("f", 51);
        Member member7 = new Member("klj", 56);
        Member member8 = new Member("ch5", 5);
        ArrayList<Member> temp = new ArrayList();
        temp.add(member1);
        temp.add(member2);
        temp.add(member3);
        temp.add(member7);

        ArrayList<Member> temp2 = new ArrayList();
        temp2.add(member4);
        temp2.add(member5);
        temp2.add(member6);
        temp2.add(member8);

        MembersGroup membersGroup1 = new MembersGroup("A", temp);
        MembersGroup membersGroup2 = new MembersGroup("B", temp2);

        ArrayList<MembersGroup> membersGroups = new ArrayList<>();
        membersGroups.add(membersGroup1);
        membersGroups.add(membersGroup2);

        return membersGroups;
    }
}
