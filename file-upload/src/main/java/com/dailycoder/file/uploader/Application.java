package com.dailycoder.file.uploader;

import com.dailycoder.file.uploader.service.FilesStorageService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Comparator;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Resource
    private FilesStorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... arg) throws Exception {
        storageService.init();
    }
}
