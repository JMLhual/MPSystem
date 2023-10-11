package com.mpsystem.test;

import cn.hutool.core.io.FileUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("file")
@CrossOrigin
@RestController
public class fileUpload {


    @PostMapping("upload")
    public String  fileUpload (@RequestParam MultipartFile file) throws IOException {


        String originalFilename =file.getOriginalFilename();
        String rootFilePath = System.getProperty("user.dir") +"/src/main/resources/files/" + originalFilename;
        //System.out.println(rootFilePath);
        try{
            FileUtil.writeBytes(file.getBytes(),rootFilePath);//保存文件
        }catch (IOException e){
            e.printStackTrace();
        }
        return originalFilename ;
    }


//    @GetMapping("csvData")
//    public List<Map<String, String>> getCsvData(@RequestParam("fileName") String fileName) throws IOException {
//
//        List<Map<String,String>> csvData = transformData();
//
//        return csvData;
//    }


    @GetMapping("data")
    public ResponseEntity<List<Map<String,String>>>  getPaginatedCsvData(
            @RequestParam("pageNum") int pageNum,
            @RequestParam("pageSize") int pageSize,
            @RequestParam("fileName") String fileName) throws IOException {

        List<Map<String,String>> csvData = transformData(fileName);
        int startIndex = (pageNum-1)*pageSize;
        int endIndex = Math.min(startIndex+pageSize,csvData.size());
//        System.out.println(pageSize);
//        System.out.println(csvData.size());
        List<Map<String,String>> pageData = csvData.subList(startIndex,endIndex);

        return ResponseEntity.ok(pageData);
    }

    private List<Map<String,String>> transformData(String fileName) throws IOException {

        String rootFilePath = System.getProperty("user.dir") +"/src/main/resources/files/" + fileName;
        List<Map<String,String>> csvData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rootFilePath));
        String line;
        String[] headers = null;
        while((line = reader.readLine()) != null){
            if (headers == null){
                headers = line.split(",");
            }else {
                String[] value = line.split(",");
                Map<String,String> row = new HashMap<>();
                for (int i=0;i<headers.length;i++){
                    if (i == value.length){
                        row.put(headers[i],null);
                        continue;
                    }
                    row.put(headers[i],value[i]);
                }
                csvData.add(row);
            }
        }
        reader.close();
        return csvData;
    }

}


