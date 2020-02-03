package org.mumyoutube.controller;


import org.mumyoutube.model.Video;
import org.mumyoutube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mumyoutube.controller.VideoUploadController.uploadingDir;


@RestController
@RequestMapping

public class VideoplayListController {

    @Autowired
    private MyResourceHttpRequestHandler handler;
    @Autowired
    VideoService videoService;
    static ModelAndView mv = new ModelAndView();


    File MP4_FILE;

    public VideoplayListController(VideoService videoService) {
        super();
        this.videoService = videoService;
    }


    @GetMapping(value = "/playVideo", produces = "video/mp4")
    @ResponseBody    public ModelAndView videoSource(HttpServletRequest request,
                                    HttpServletResponse response)
            throws ServletException, IOException {
        List<String> exactPaths = new ArrayList<>();
        List<String> vidP = new ArrayList<>();

        List<Video> vids = videoService.getAllVideo();

        for (Video v : vids) {
            exactPaths.add(v.getVideoPath());

            MP4_FILE = new File(v.getVideoPath());
            vidP.add(MP4_FILE.getName());

//            request.setAttribute(MyResourceHttpRequestHandler.ATTR_FILE, MP4_FILE);
//            handler.handleRequest(request, response);
//            mv.addObject(handler);
        }
        //List<Video> viddleeo = videoService.getAllVideo();

//        List v = Files.list(Paths.get(uploadingDir)).collect(Collectors.toList());
//        List vPath = new ArrayList();
//        for (Object s : v) {
//            vPath.add(Paths.get(s.toString()).getFileName());
//        }
        mv.addObject("Paths", exactPaths);

        mv.addObject("videos", vidP);

        return mv;
    }

//    @GetMapping(path = "/plain", produces = "video/mp4")
//    public FileSystemResource plain() {
//
//        return new FileSystemResource(MP4_FILE);
//    }

    //@GetMapping("/{videoName}")
    //@NotNull
    @GetMapping( value = "/{Paths}", produces = "video/mp4")
    public String video(@PathVariable String Paths, HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        MP4_FILE = new File(uploadingDir+"/"+Paths);
        request.setAttribute(MyResourceHttpRequestHandler.ATTR_FILE, MP4_FILE);
        handler.handleRequest(request, response);

//

//        Path fullPath = Path.of(uploadingDir + "/" + videoName);
//        ModelAndView model = new ModelAndView();
//        model.addObject("path",  handler.getResource(request));
//
        return "video";
    }


    @Component
    final static class MyResourceHttpRequestHandler extends ResourceHttpRequestHandler {

        private final static String ATTR_FILE = MyResourceHttpRequestHandler.class.getName() + ".file";

        @Override
        protected Resource getResource(HttpServletRequest request) throws IOException {

            final File file = (File) request.getAttribute(ATTR_FILE);
            return new FileSystemResource(file);
        }
    }
}
