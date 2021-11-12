package ru.sssproject.testex.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
class FinderOldManTest {
    @Autowired
    private DataClass dataClass;

    @Autowired
    private FinderOldMan finderOldMan;

    @Test
    void findOldMembers() {
        Set<String> testSet = new HashSet<>(Arrays.asList("Ivan", "Kefir", "Boris", "Sergey", "Oleg"));
        Assertions.assertEquals(finderOldMan.findOldMembers(dataClass.getStaticData()), testSet);
    }
}