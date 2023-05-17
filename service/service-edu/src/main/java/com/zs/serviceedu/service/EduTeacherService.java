package com.zs.serviceedu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zs.serviceedu.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.serviceedu.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author 进阶滴小白
 * @since 2023-05-15
 */
public interface EduTeacherService extends IService<EduTeacher> {

    //多条件查询讲师带分页
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);
}
