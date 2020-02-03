package org.mumyoutube.service;

import org.mumyoutube.model.Playlist;
import org.mumyoutube.model.User;

import java.util.List;

public interface PlaylistService {

    List<Playlist> getAllList();
    Playlist getPlaylistById(long listId);

    void deletePlaylist(long listId);
    void updatePlaylist(Playlist list);
    boolean addPlaylist(Playlist list);
}
