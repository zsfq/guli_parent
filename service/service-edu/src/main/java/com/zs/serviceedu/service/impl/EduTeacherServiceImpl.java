package com.zs.serviceedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zs.serviceedu.entity.EduTeacher;
import com.zs.serviceedu.entity.vo.TeacherQuery;
import com.zs.serviceedu.mapper.EduTeacherMapper;
import com.zs.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author 进阶滴小白
 * @since 2023-05-15
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery) {
        //构建查询条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        //是否包含教师名称
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name", name);  //参数1：数据库字段名  参数2：模糊查询值
        }
        //教师头衔
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level", level);        //等于
        }
        //创建时间
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create", begin);   //大于等于
        }
        //更新时间
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_modified", end);   //小于等于
        }

        //排序
        wrapper.orderByDesc("gmt_create");

        //带上门判断后的条件进行分页查询
        baseMapper.selectPage(pageParam, wrapper);
    }
}
