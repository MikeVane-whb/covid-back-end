package com.mikevane.covid.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mikevane.covid.controller.dto.TeacherGradeDto;
import com.mikevane.covid.entity.TeacherGrade;
import com.mikevane.covid.utils.ListUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-04-19-01-58
 * @version: 1.0
 */
@SpringBootTest
public class TeacherGradeServiceTest {
    @Autowired
    private TeacherGradeService teacherGradeService;

    @Test
    public void getGradePageByTeacherIdTest(){
        Page pageByTeacherId = teacherGradeService.getGradePageByTeacherId(8, 1, 2, "34071903");
        System.out.println(Arrays.toString(new List[]{pageByTeacherId.getRecords()}));
        System.out.println(pageByTeacherId.getTotal());
    }

    @Test
    public void insertGradeTest(){
        if (teacherGradeService.insertGrade(8,"34071908")){
            System.out.println("插入成功");
        }
    }

    @Test
    public void deleteGradeTest(){
        if (teacherGradeService.deleteGrade(8,"34071906")){
            System.out.println("删除成功");
        }
    }

    @Test
    public void deleteBatchGradeTest(){
        List<String> gradeClass = new ArrayList<>();
        gradeClass.add("34071907");
        gradeClass.add("34071908");
        if (teacherGradeService.deleteBatchGrade(8,gradeClass)){
            System.out.println("批量删除成功");
        }
    }

    @Test
    public void getGradesTest(){
        List<TeacherGradeDto> teacherGradeDtos = teacherGradeService.selectGrades(8);
        teacherGradeDtos.forEach(teacherGradeDto -> System.out.println(teacherGradeDto));
    }


    @Test
    public void deleteBatchRelationTest(){
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(6);
        boolean deleteBatchRelation = teacherGradeService.deleteBatchRelation(list);
        if (deleteBatchRelation){
            System.out.println("删除成功");
        }
    }
}
