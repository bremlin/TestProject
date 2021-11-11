package ru.sssproject.testex.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("finder")
public class Finder {
    @Autowired
    private FinderOldMan finderOldMan;

    public FinderOldMan getFinderOldMan() {
        return finderOldMan;
    }
}
