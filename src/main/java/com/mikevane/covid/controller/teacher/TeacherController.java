package com.mikevane.covid.controller.teacher;

import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.TeacherDto;
import com.mikevane.covid.entity.Teacher;
import com.mikevane.covid.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author: whb
 * @date: 2023-03-10-17-32
 * @version: 1.0
 */
@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {
    private TeacherService teacherService;
    @Autowired
    public void setTeacherService(TeacherService teacherService) { this.teacherService = teacherService;}

    @GetMapping("/select")
    public Result<TeacherDto> select(HttpSession session){
        TeacherDto teacherDto = new TeacherDto();
        Teacher teacher = teacherService.getById((Integer) session.getAttribute("teacherId"));
        BeanUtils.copyProperties(teacher,teacherDto);
        return teacherDto != null ? Result.success(teacherDto) : Result.error();
    }

    @PutMapping("/update")
    @Transactional
    public Result update(HttpSession session,
                         @RequestBody TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDto,teacher);
        teacher.setId((Integer) session.getAttribute("teacherId"));
        return teacherService.updateById(teacher) ? Result.success() : Result.error();
    }


}
