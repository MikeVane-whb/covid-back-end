package com.mikevane.covid.utils;


import com.mikevane.covid.entity.StudentLeave;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-04-14-01-08
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class ListUtilTest {
    @Test
    public void copyPropertiesTest(){
        List<StudentLeave> list1 = new ArrayList<>();
        StudentLeave studentLeave = new StudentLeave();
        studentLeave.setUsername("123");
        list1.add(studentLeave);
    }
}
