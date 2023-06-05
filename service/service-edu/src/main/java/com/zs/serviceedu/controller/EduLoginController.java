package com.zs.serviceedu.controller;

import com.zs.commonutils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin       //允许跨域
public class EduLoginController {

    //login
    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }

    //info
    @GetMapping("/info")
    public R info(){
        return R.ok().data("roles","admin").data("name","进阶滴小白").data("avatar","http://www.weixintouxiang.cn/weixin/20140607090832328.gif");
    }
}
