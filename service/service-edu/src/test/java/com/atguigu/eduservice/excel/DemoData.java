package com.atguigu.eduservice.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {

    @ExcelProperty("学号")
    private Integer sno;

    @ExcelProperty("姓名")
    private Integer sName;
}
