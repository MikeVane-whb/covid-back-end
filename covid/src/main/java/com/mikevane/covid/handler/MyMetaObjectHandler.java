package com.mikevane.covid.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.mikevane.covid.utils.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert]...");
        setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充[update]...");
        setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
