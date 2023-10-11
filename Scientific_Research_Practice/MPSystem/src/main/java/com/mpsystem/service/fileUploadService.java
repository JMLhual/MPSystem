package com.mpsystem.service;

import com.mpsystem.utils.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface fileUploadService {

    Result fileUpload(MultipartFile file);

    Result getPagintedCsvData(int pageNum, int pageSize, String fileName) throws IOException;

    void downloadFile(HttpServletResponse response) throws IOException;
}
