package com.ra.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service

public class FileStorageServiceImpl implements FileStorageService {
    private ServletContext servletContext;
    public FileStorageServiceImpl(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    @Override
    public String uploadFile(MultipartFile file) {
        String uploadFolder = "/uploads/";
        String path = servletContext.getRealPath("/WEB-INF/") + uploadFolder;
        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        if(!file.isEmpty()) {
            Path filePath = Paths.get(path + file.getOriginalFilename());
            try{
                Files.write(filePath, file.getBytes());
                return uploadFolder + file.getOriginalFilename();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
