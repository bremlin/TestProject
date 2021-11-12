package ru.sssproject.testex.utils;

import org.springframework.stereotype.Component;
import ru.sssproject.testex.objects.Member;
import ru.sssproject.testex.objects.MembersGroup;

import java.util.*;
@Component("dataClass")
public class DataClass {

    private final int MIN_GROUP = 1;
    private final int MAX_GROUP = 3;
    private final int MIN_USER = 10;
    private final int MAX_USER = 30;

    private final int MAX_AGE = 80;

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
            if (membersGroup.getMembers() != null) {
                memberGroupsList.add(membersGroup);
            }
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
        ArrayList<Member> memberArrayList1 = new ArrayList<>(Arrays.asList(
                new Member("Maria", 10),
                new Member("Ivan", 100),
                new Member("Oleg", 69),
                new Member("Katya", 27),
                new Member("Boris", 55)
        ));

        ArrayList<Member> memberArrayList2 = new ArrayList<>(Arrays.asList(
                new Member("Nikolay", 49),
                new Member("Sergey", 66),
                new Member("Elvira", 3),
                new Member("Nastya", 15),
                new Member("Kefir", 88)
        ));

        return new ArrayList<>(Arrays.asList(
                new MembersGroup("A", memberArrayList1),
                new MembersGroup("B", memberArrayList2)));
    }
}
