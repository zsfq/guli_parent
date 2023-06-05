package com.zs.oss.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.zs.oss.service.OssService;
import com.zs.oss.utils.ConstantsPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service         //service注解要加载实现类上，不能加在接口上面
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFileAvatar(MultipartFile file) {

        //1.获取OSS中的配置信息
        String endpoint = ConstantsPropertiesUtils.END_POINT;
        String accessKeyId = ConstantsPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantsPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantsPropertiesUtils.BUCKET_NAME;

        try {
            // 2.创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            //3.获取文件输入流
            InputStream inputStream = file.getInputStream();

            //4.获取文件名称
            String fileName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString().replace("-","");
            fileName = uuid + fileName;

            String datePath = new DateTime().toString("yyyy/MM/dd");
            fileName = "avatar/" + datePath + "/"  + fileName;

            //5.调用OSS方法实现上传
            ossClient.putObject(bucketName,fileName,inputStream);

            //6.关闭OSSClient
            ossClient.shutdown();

            //7.拼接文件路径
            String url = "https://" + bucketName + "." + endpoint + "/" + fileName;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
