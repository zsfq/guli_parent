package com.zs.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果的封装：
 *      这里比较好的一点是采用了链式编程的规则
 */
@Data
public class R {

    @ApiModelProperty("是否成功")
    private boolean success;

    @ApiModelProperty("响应码")
    private Integer code;

    @ApiModelProperty("返回信息")
    private String message;

    @ApiModelProperty("返回数据")
    private Map<String, Object> data = new HashMap<>();

    //无参构造方法
    private R(){}

    //成功 静态方法
    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    //失败 静态方法
    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    //设置是否成功
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    //设置响应码
    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    //设置响应消息
    public R message(String message){
        this.setMessage(message);
        return this;
    }

    //设置响应数据1
    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    //设置响应数据2
    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
