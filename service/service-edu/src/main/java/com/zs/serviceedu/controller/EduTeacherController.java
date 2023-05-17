package com.zs.serviceedu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zs.commonutils.R;
import com.zs.serviceedu.entity.EduTeacher;
import com.zs.serviceedu.entity.vo.TeacherQuery;
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
    public R findAllTeacher(){
        List<EduTeacher> teacherList = eduTeacherService.list(null);
        return R.ok().data("items",teacherList);
    }

    //2.逻辑删除讲师
    @DeleteMapping("{id}")
    public R removeTeacher(@PathVariable String id){
        boolean flag = eduTeacherService.removeById(id);
        if(flag){
            return R.ok();
        }else{
            return R.error();
        }
    }

    //3.分页查询讲师
    //page:当前页
    //limit:每页显示的记录数
    @GetMapping("/pageList/{page}/{limit}")
    public R pageList(@PathVariable Long page, @PathVariable Long limit){
        Page<EduTeacher> pageTeacher = new Page<>(page, limit);
        //执行分页查询操作，将数据封装到pageTeacher中
        eduTeacherService.page(pageTeacher,null);
        //获取查询到的数据
        List<EduTeacher> eduTeachers = pageTeacher.getRecords();
        //获取总记录数
        long total = pageTeacher.getTotal();
        return R.ok().data("total",total).data("rows",eduTeachers);
    }

    //4.多条件查询带分页
    @PostMapping("/pageTeacherConditon/{page}/{limit}")
    public R pageTeacherConditon(@PathVariable Long page,
                                 @PathVariable Long limit,
                                 @RequestBody TeacherQuery teacherQuery){
        //创建分页对象
        Page<EduTeacher> pageParam = new Page<>();

        //调用方法实现多条件分页
        eduTeacherService.pageQuery(pageParam, teacherQuery);

        //获取查询到的数据
        List<EduTeacher> eduTeachers = pageParam.getRecords();

        //获取总记录数
        long total = pageParam.getTotal();

        return R.ok().data("total", total).data("rows", eduTeachers);
    }

    //5.新增讲师
    @PostMapping("/save")
    public R save(@RequestBody EduTeacher eduTeacher){
        boolean flag = eduTeacherService.save(eduTeacher);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    //6.根据id查询
    @GetMapping("/getById/{id}")
    public R getById(@PathVariable String id){
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return R.ok().data("item", eduTeacher);
    }

    //7.修改讲师
    @PostMapping("/updateById")
    public R updateById(@RequestBody EduTeacher eduTeacher){
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }
}

