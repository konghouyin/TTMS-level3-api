package com.xupt.ttms.controller;

import com.xupt.ttms.dto.returnUTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {


    private String UPLOAD_FOLDER="/root/ttms-v3/fileUpload/";
    //private String UPLOAD_FOLDER="C:\\Users\\加雷斯 贝尔\\Desktop\\";


    @PostMapping("/singlefile")
    public Object singleFileUpload(MultipartFile file) {

        returnUTO uto = new returnUTO();
        if (Objects.isNull(file) || file.isEmpty()) {
            uto.setMsg("文件为空");
            uto.setStyle(0);
        }

        try {
            byte[] bytes = file.getBytes();
            long l = System.currentTimeMillis();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename()+l);
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            uto.setMsg("http://132.232.169.227"+path.toString());
            uto.setStyle(1);
        } catch (IOException e) {
            e.printStackTrace();
            uto.setMsg("后端异常。。。");
            uto.setStyle(0);
        }
        return uto;
    }
}

