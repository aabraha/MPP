package org.mumyoutube.service;

import org.mumyoutube.model.Playlist;
import org.mumyoutube.model.Video;

import java.util.List;

public interface VideoService {

    List<Video> getAllVideo();
    Video getVideoById(Long listId);

    void deleteVideo(Long Video);
    void updateVideo(Video list);
    boolean addVideo(Video list);
}
