package ru.sssproject.testex.utils;

import org.springframework.stereotype.Component;
import ru.sssproject.testex.objects.MembersGroup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component("finderOldMan")
public class FinderOldMan implements OldMemberFinder{
    @Override
    public Set<String> findOldMembers(List<MembersGroup> groups) {
        Set<String> groupsNames = new HashSet<>();
        groups.forEach(membersGroup ->
                membersGroup.getMembers().stream()
                        .filter((member) -> member.getAge() > 50)
                        .forEach(member -> groupsNames.add(member.getName())));
        return groupsNames;
    }
}
