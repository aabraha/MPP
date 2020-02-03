package org.mumyoutube.service;

import org.mumyoutube.data.PlaylistRepository;
import org.mumyoutube.model.Playlist;
import org.mumyoutube.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlaylistServiceImpl implements PlaylistService {


    private PlaylistRepository repository;

    @Autowired
    public  PlaylistServiceImpl(PlaylistRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Playlist> getAllList() {
        return (List<Playlist>)repository.findAll();
    }

    @Override
    public Playlist getPlaylistById(long userId) {
        return repository.findById(userId).get();
    }

    @Override
    public boolean addPlaylist(Playlist list) {
        try{
             repository.save(list);
             return  true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public void updatePlaylist(Playlist list) {

         repository.save(list);
    }

    @Override
    public void deletePlaylist(long listId) {
        repository.deleteById(listId);

    }
}
