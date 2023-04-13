package com.mikevane.covid.controller.teacher;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.common.BaseContext;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.StudentDto;
import com.mikevane.covid.controller.dto.TeacherDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.Teacher;
import com.mikevane.covid.entity.TeacherStudent;
import com.mikevane.covid.service.StudentService;
import com.mikevane.covid.service.TeacherService;
import com.mikevane.covid.service.TeacherStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @GetMapping("/select.do")
    public Result<TeacherDto> select(HttpSession session){
        TeacherDto teacherDto = new TeacherDto();
        Teacher teacher = teacherService.getById((Integer) session.getAttribute("teacherId"));
        BeanUtils.copyProperties(teacher,teacherDto);
        return teacherDto != null ? Result.success(teacherDto) : Result.error();
    }

    @PutMapping("/update.do")
    @Transactional
    public Result update(HttpSession session,
                         @RequestBody TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDto,teacher);
        teacher.setId((Integer) session.getAttribute("teacherId"));
        return teacherService.updateById(teacher) ? Result.success() : Result.error();
    }


}
