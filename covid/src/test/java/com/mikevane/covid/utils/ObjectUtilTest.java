package com.mikevane.covid.utils;

import com.mikevane.covid.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: whb
 * @date: 2023-04-06-16-33
 * @version: 1.0
 */
@SpringBootTest
public class ObjectUtilTest {
    @Test
    public void replaceFieldsValTest() throws IllegalAccessException {
        Student student = new Student();
        student.setId(1);
        student.setUsername("123");
        ObjectUtil.replaceFieldValueByType(student,String.class,null,"默认值");
        System.out.println(student);
    }

    @Test
    public void replaceFieldValueByNameTest() throws IllegalAccessException {
        Student student = new Student();
        student.setId(1);
        student.setUsername("123");
        ObjectUtil.replaceFieldValueByName(student,"id",123456);
        System.out.println(student);
    }
}
