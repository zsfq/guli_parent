package com.zs.serviceedu.controller;


import com.zs.serviceedu.entity.EduTeacher;
import com.zs.serviceedu.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 进阶滴小白
 * @since 2023-05-15
 */
@RestController
@RequestMapping("/eduservice/teacher/")
public class EduTeacherController {

    @Autowired
    EduTeacherService eduTeacherService;

    //1.查询讲师表所有数据
    @GetMapping("findAll")
    public List<EduTeacher> findAllTeacher(){
        List<EduTeacher> teacherList = eduTeacherService.list(null);
        return teacherList;
    }

    //2.逻辑删除讲师
    @DeleteMapping("{id}")
    public boolean removeTeacher(@PathVariable String id){
        return eduTeacherService.removeById(id);
    }
}

