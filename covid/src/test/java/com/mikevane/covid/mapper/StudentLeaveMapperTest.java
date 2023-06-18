package com.mikevane.covid.mapper;

import com.mikevane.covid.entity.StudentLeave;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-04-27-23-40
 * @version: 1.0
 */
@SpringBootTest
public class StudentLeaveMapperTest {
    @Resource
    private StudentLeaveMapper studentLeaveMapper;
    @Test
    public void selectPendApprovalIdTest(){
        List<Integer> list = studentLeaveMapper.selectPendApprovalId(8, "", "");
        list.forEach(System.out::println);
    }

    @Test
    public void selectPendApprovalStudentTest(){
        List<StudentLeave> studentLeaves = studentLeaveMapper.selectPendApprovalStudent(8, 2, 2, null, null);
        studentLeaves.forEach(System.out::println);
    }
}
