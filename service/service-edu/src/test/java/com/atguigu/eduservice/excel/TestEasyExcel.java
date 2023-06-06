package com.atguigu.eduservice.excel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {

    @Test
    public void writeExcel() {
        //实现excel写的操作
        //1.设置写入文件夹地址和excel文件名称
        String fileName = "D:\\write.xlsx";

        //2.调用easyexcel里面的方法实现写操作
        EasyExcel.write(fileName, DemoData.class).sheet("学生列表").doWrite(getData());
    }

    @Test
    public void readExcel(){
        String fileName = "D:\\write.xlsx";

        EasyExcel.read(fileName, DemoData.class, new ExcelListener()).sheet().doRead();
    }

    //创建方法返回list集合
    private List<DemoData> getData(){
        List<DemoData> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            DemoData data = new DemoData();
            data.setSno(i);
            data.setSname("name_" + i);
            list.add(data);
        }
        return list;
    }

}
