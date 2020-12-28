package com.cheky.springboot.demo.fdfs;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Cheky
 * @date 2020-12-27
 */
@SpringBootTest
//@RunWith(SpringRunner.class) // 可用可不用，不影响最终测试结果
public class FastDFSTest {

    private final String jpgFilePath = "demo\\sample.jpg";
    private final String xmlFilePath = "demo\\sample.xml";
    private final String txtFilePath = "demo\\sample.txt";

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    @Test
    public void testUpload() throws FileNotFoundException {
        // 要上传的文件
        File file = new File(jpgFilePath); // 本机文件地址
        // 上传并保存图片，参数：1-上传的文件流 2-文件的大小 3-文件的后缀
        StorePath storePath = this.storageClient.uploadFile(
                new FileInputStream(file), file.length(), "jpg", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
    }

    @Test
    public void testUploadAndCreateThumb() throws FileNotFoundException {
        File file = new File(jpgFilePath);
        // 上传并且生成缩略图
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(
                new FileInputStream(file), file.length(), "png", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
        // 获取缩略图路径
        String path = thumbImageConfig.getThumbImagePath(storePath.getPath());
        System.out.println(path);
    }

    @Test
    public void testUploadXml() throws FileNotFoundException {
        // 要上传的文件
        File file = new File(xmlFilePath); // 本机文件地址
        // 上传并保存XML，参数：1-上传的文件流 2-文件的大小 3-文件的后缀
        StorePath storePath = this.storageClient.uploadFile(
                new FileInputStream(file), file.length(), "xml", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
    }

    @Test
    public void testUploadTxt() throws FileNotFoundException {
        // 要上传的文件
        File file = new File(txtFilePath); // 本机文件地址
        // 上传并保存TXT，参数：1-上传的文件流 2-文件的大小 3-文件的后缀
        StorePath storePath = this.storageClient.uploadFile(
                new FileInputStream(file), file.length(), "txt", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
    }
}
