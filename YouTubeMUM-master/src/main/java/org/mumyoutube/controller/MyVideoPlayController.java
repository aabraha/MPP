package org.mumyoutube.controller;

import org.mumyoutube.model.Video;
import org.mumyoutube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MyVideoPlayController {
/*

    @Autowired
    private MyResourceHttpRequestHandler handler;
    @Autowired
    private VideoService videoService;

    public MyVideoPlayController(VideoService videoService) {
    }

    File MP4_FILE;

    // supports byte-range requests
    @GetMapping("/{hanok}")
    public void home(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        MP4_FILE = new File("/home/hhh/IdeaProjects/YouTubeMUM/uploads/134 Section Introduction - Spring Old Course.mp4");

        request.setAttribute(MyResourceHttpRequestHandler.ATTR_FILE, MP4_FILE);
        handler.handleRequest(request, response);
    }

    // does not support byte-range requests
    @GetMapping(path = "/plain", produces = "video/mp4")
    public FileSystemResource plain() {

        return new FileSystemResource(MP4_FILE);
    }


    @Component
    final static class MyResourceHttpRequestHandler extends ResourceHttpRequestHandler {

        private final static String ATTR_FILE = MyResourceHttpRequestHandler.class.getName() + ".file";

        @Override
        protected Resource getResource(HttpServletRequest request) throws IOException {

            final File file = (File) request.getAttribute(ATTR_FILE);
            return new FileSystemResource(file);
        }
    }*/
}
