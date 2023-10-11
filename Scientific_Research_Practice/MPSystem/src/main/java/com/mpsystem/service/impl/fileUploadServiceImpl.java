package com.mpsystem.service.impl;

import cn.hutool.core.io.FileUtil;
import com.mpsystem.service.fileUploadService;
import com.mpsystem.utils.Result;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@Service
public class fileUploadServiceImpl implements fileUploadService {


    @Override
    public Result fileUpload(MultipartFile file) {

        String originalFilename =file.getOriginalFilename();
        String rootFilePath = System.getProperty("user.dir") +"/src/main/resources/files/" + originalFilename;
        //System.out.println(rootFilePath);
        try{
            FileUtil.writeBytes(file.getBytes(),rootFilePath);//保存文件
        }catch (IOException e){
            e.printStackTrace();
        }
        return Result.ok(originalFilename);
    }

    @Override
    public Result getPagintedCsvData(int pageNum, int pageSize, String fileName) throws IOException {


        List<Map<String,String>> csvData = transformData(fileName);
        int startIndex = (pageNum-1)*pageSize;
        int endIndex = Math.min(startIndex+pageSize,csvData.size());
        System.out.println(startIndex);
        System.out.println(endIndex);
        List<Map<String,String>> pageData = csvData.subList(startIndex,endIndex);

//        for (Map<String ,String> item :pageData){
//            System.out.println(item);
//        }
//        Result<Map<String,String>> response = new Result<>(csvData.size(), pageData);

        return Result.upload(pageData, csvData.size());
    }

    @Override
    public void downloadFile(HttpServletResponse response) throws IOException {

        String fileName ="test_data.csv";
        String rootFilePath = System.getProperty("user.dir") +"/src/main/resources/files/" + fileName;

        File downloadFile = new File(rootFilePath);

        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));

        response.setContentType("application/octet-stream");

        os.write(FileUtil.readBytes(downloadFile));
        os.flush();
        os.close();
    }

    private List<Map<String,String>> transformData(String fileName) throws IOException {

        String rootFilePath = System.getProperty("user.dir") +"/src/main/resources/files/" + fileName;
        ArrayList<Map<String,String>> csvData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rootFilePath));
        String line;
        String[] headers = null;
        while((line = reader.readLine()) != null){
            if (headers == null){
                headers = line.split(",");
            }else {
                String[] value = line.split(",");
                Map<String,String> row = new LinkedHashMap<>();
                for (int i=0;i<headers.length;i++){
                    if (i == value.length){
                        row.put(headers[i],null);
                        continue;
                    }
                    row.put(headers[i],value[i]);
                }
                csvData.add(row);
            }
            for (Map<String,String> item :csvData){
                System.out.println(item);
            }
        }
        reader.close();
        return csvData;
    }

}
