package org.mumyoutube;

import org.mumyoutube.controller.VideoUploadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        new File(VideoUploadController.uploadingDir).mkdirs();
        SpringApplication.run(MainApplication.class, args);
   }
}
