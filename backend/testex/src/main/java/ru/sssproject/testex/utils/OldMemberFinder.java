package ru.sssproject.testex.utils;

import ru.sssproject.testex.objects.MembersGroup;

import java.util.List;
import java.util.Set;

public interface OldMemberFinder {
    public Set<String> findOldMembers(List<MembersGroup> listMembers);
}
