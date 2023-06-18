package com.mikevane.covid.mapper;

import com.mikevane.covid.controller.dto.TeacherClockDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-31-17-45
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class StudentClockMapperTest {
    @Autowired
    private StudentClockMapper studentClockMapper;

    @Test
    public void selectClockStudentTest(){
        List<TeacherClockDto> studentClocks = studentClockMapper.selectClockStudent("34071903");
        log.info(Arrays.toString(new List[]{studentClocks}));
    }
}
