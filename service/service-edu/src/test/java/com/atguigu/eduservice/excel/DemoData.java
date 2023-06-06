package com.atguigu.eduservice.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {

    @ExcelProperty(value = "学号", index = 0)
    private Integer sno;

    @ExcelProperty(value = "姓名", index = 1)
    private String sname;
}
