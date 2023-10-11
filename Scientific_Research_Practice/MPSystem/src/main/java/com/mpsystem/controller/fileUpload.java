package com.mpsystem.controller;

import cn.hutool.core.io.FileUtil;
import com.mpsystem.service.fileUploadService;
import com.mpsystem.utils.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private fileUploadService fileUploadService;

    @PostMapping("upload")
    public Result fileUpload(@RequestParam MultipartFile file){
        Result result = fileUploadService.fileUpload(file);
        System.out.println(result);
        return result;
    }



    @GetMapping("data")
    public Result getPaginatedCsvData(
            @RequestParam("pageNum") int pageNum,
            @RequestParam("pageSize") int pageSize,
            @RequestParam("fileName") String fileName) throws IOException {
        Result result = fileUploadService.getPagintedCsvData(pageNum,pageSize,fileName);
        return result;
    }

    @GetMapping("download")
    public void downloadFile (HttpServletResponse response) throws IOException {
        fileUploadService.downloadFile(response);
    }


}


