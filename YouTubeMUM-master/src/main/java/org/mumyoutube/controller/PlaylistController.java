package org.mumyoutube.controller;


import org.mumyoutube.model.Playlist;
import org.mumyoutube.service.PlaylistService;
import org.mumyoutube.service.UserService;
import org.mumyoutube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class PlaylistController {

    private PlaylistService playlistService;
    private UserService userService;
    private VideoService videoService;

    @Autowired
    public  PlaylistController(PlaylistService playlistService, UserService userService, VideoService videoService){
        this.playlistService = playlistService;
        this.userService = userService;
    }

    //Get all playlists
    @RequestMapping(value = "/allPlaylists", method = RequestMethod.POST)
    public ModelAndView displayAllPlaylists(){
        ModelAndView mv = new ModelAndView();
        List playlistList = playlistService.getAllList();
        mv.addObject("playlistList", playlistList);
        return mv;
    }

    @RequestMapping(value = "/allPlaylists", method = RequestMethod.GET)
    public ModelAndView getAllPlaylistsToView(){
        ModelAndView mv = new ModelAndView();
        List playlistList = playlistService.getAllList();
            mv.addObject("playlistList", playlistList);
       return mv;
    }

    //Add a new playlist
    @RequestMapping(value = "/addNewPlaylist", method = RequestMethod.GET)
    public ModelAndView displayNewPlaylistForm(){
        ModelAndView mv = new ModelAndView("addNewPlaylist");
        mv.addObject("headerMessage", "Add Playlist Details");
        mv.addObject("playlist", new Playlist());
        return mv;
    }

    @RequestMapping(value = "/addNewPlaylist", method = RequestMethod.POST)
    public ModelAndView saveNewPlaylist(@ModelAttribute Playlist playlist, BindingResult result){
        ModelAndView mv = new ModelAndView("playlistCreation");
        mv.addObject("message","Something went wrong. Please try again later.");

        if (result.hasErrors()){
            return new ModelAndView("playlistCreation");
        }
        boolean isAdded = playlistService.addPlaylist(playlist);
        if (isAdded){
            mv.addObject("message", "New Playlist added");
        }else {
                    ModelAndView model = new ModelAndView("playlistCreation");
                    model.addObject("message","Something went wrong. Please try again later.");
                    return  model;
        }
        return mv;
    }
}
