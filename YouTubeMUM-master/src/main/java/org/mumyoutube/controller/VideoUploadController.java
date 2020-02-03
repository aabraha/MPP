package org.mumyoutube.controller;

import org.mumyoutube.model.Video;
import org.mumyoutube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class VideoUploadController {

    public static final String uploadingDir = System.getProperty("user.dir") + "/uploads";
    private VideoService videoService;

    @Autowired
    public VideoUploadController(VideoService videoService){
        this.videoService = videoService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView showUpload() {
        ModelAndView mv = new ModelAndView("upload");
        mv.addObject("headerMessage", "Upload a Video");
        mv.addObject("upload", new Video());
        return  mv;
    }

    @PostMapping("/upload")
    public ModelAndView fileUpload(@RequestParam("file") MultipartFile videoFile, @ModelAttribute Video video, RedirectAttributes redirectAttributes, BindingResult result) {
        ModelAndView mv = new ModelAndView("upload");
        mv.addObject("message","Something went wrong. Please try again later.");

        if (result.hasErrors()){
            return new ModelAndView("upload");
        }

        if (videoFile.isEmpty()) {
            return new ModelAndView("upload", "message", "Please select a file and try again.");
        }

        try {
            // read and write the file to the selected location
            byte[] bytes = videoFile.getBytes();
            Path path = Paths.get(uploadingDir + videoFile.getOriginalFilename());
            Files.write(path, bytes);

            //now save the video detail to the database
            video.setVideoPath(path.toString());
            videoService.addVideo(video);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView("uploadStatus", "message", "Video Uploaded successfully.");
    }
}
