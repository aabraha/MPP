package org.mumyoutube.service;

import org.mumyoutube.data.PlaylistRepository;
import org.mumyoutube.data.VideoRepository;
import org.mumyoutube.model.Playlist;
import org.mumyoutube.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {


    private VideoRepository repository;

    @Autowired
    public VideoServiceImpl(VideoRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Video> getAllVideo() {
        return (List<Video>)repository.findAll();
    }

    @Override
    public Video getVideoById(Long userId) {
        return repository.findById(userId).get();
    }

    @Override
    public boolean addVideo(Video list) {
        try{
             repository.save(list);
             return  true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public void updateVideo(Video list) {

         repository.save(list);
    }

    @Override
    public void deleteVideo(Long listId) {
        repository.deleteById(listId);

    }
}
