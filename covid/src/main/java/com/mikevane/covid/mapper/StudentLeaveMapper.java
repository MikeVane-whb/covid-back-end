package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikevane.covid.entity.StudentLeave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
* @author MikeV
* @description 针对表【student_leave】的数据库操作Mapper
* @createDate 2023-04-13 21:08:52
* @Entity generator.domain.StudentLeave
*/
@Mapper
public interface StudentLeaveMapper extends BaseMapper<StudentLeave> {

    /**
     * 查找未审批请假表id
     * @param teacherId
     * @param studentName
     * @param gradeClass
     * @return
     */
    List<Integer> selectPendApprovalId(@Param("teacherId") Integer teacherId,
                                      @Param("studentName") String studentName,
                                      @Param("gradeClass") String gradeClass);

    /**
     * 分页查询未审批的请假
     * @param teacherId
     * @param currIndex
     * @param pageSize
     * @param studentName
     * @param gradeClass
     * @return
     */
    List<StudentLeave> selectPendApprovalStudent(@Param("teacherId")Integer teacherId,
                                                 @Param("currIndex")Integer currIndex,
                                                 @Param("pageSize")Integer pageSize,
                                                 @Param("studentName")String studentName,
                                                 @Param("gradeClass")String gradeClass);

    List<Integer> selectApprovedId(@Param("teacherId") Integer teacherId,
                                 @Param("studentName") String studentName,
                                 @Param("gradeClass") String gradeClass);

    /**
     * 分页查询已审批的请假
     * @param teacherId
     * @param currIndex
     * @param pageSize
     * @param studentName
     * @param gradeClass
     * @return
     */
    List<StudentLeave> selectApprovedStudent(@Param("teacherId")Integer teacherId,
                                             @Param("currIndex")Integer currIndex,
                                             @Param("pageSize")Integer pageSize,
                                             @Param("studentName")String studentName,
                                             @Param("gradeClass")String gradeClass);
}




