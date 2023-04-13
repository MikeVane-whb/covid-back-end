package com.mikevane.covid.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author: whb
 * @date: 2023-03-22-16-05
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class TimeUtilTest {
    @Test
    public void getCurrentTimeByPatternTest(){
        String currentTimeByPattern = TimeUtil.getLocalTimeDateByPattern(LocalDateTime.now(),"yyyy-MM-dd");
        log.info(currentTimeByPattern);
    }

    @Test
    public void equalsCurrentTimeTest(){
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(2023,3,22), LocalTime.of(1,10,10));
        boolean equalsCurrentTime = TimeUtil.equalsCurrentTime(localDateTime, "yyyy-MM-dd");
        if (equalsCurrentTime){
            log.info("相同");
        }
        else {
            log.info("不相同");
        }
    }
}
