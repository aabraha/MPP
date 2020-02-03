package org.mumyoutube.controller;

import org.mumyoutube.service.PlaylistService;
import org.mumyoutube.service.UserService;
import org.mumyoutube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class VideoController {

    private PlaylistService playlistService;
    private UserService userService;
    private VideoService videoService;

    @Autowired
    public VideoController(PlaylistService playlistService, UserService userService, VideoService videoService){
        this.playlistService = playlistService;
        this.userService = userService;
        this.videoService = videoService;
    }

    //Get all Videos
    @RequestMapping(value = "/allVideos", method = RequestMethod.POST)
    public ModelAndView displayAllVideos(){
        ModelAndView mv = new ModelAndView();
        List videosList = videoService.getAllVideo();
        List playlistList = playlistService.getAllList();

        mv.addObject("videoList", videosList);
        mv.addObject("playlistList", playlistList);

        return mv;
    }

    @RequestMapping(value = "/allVideos", method = RequestMethod.GET)
    public ModelAndView getAllVideosToView(){
        ModelAndView mv = new ModelAndView();
        List videosList = videoService.getAllVideo();
        List playlistList = playlistService.getAllList();

        mv.addObject("videoList", videosList);
        mv.addObject("playlistList", playlistList);

        return mv;
    }

}
