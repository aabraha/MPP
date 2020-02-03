package org.mumyoutube.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.mumyoutube.constants.AppConstant;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = AppConstant.Tb_Playlist)
public class Playlist {

    @Id
    @GeneratedValue
    private Long playlistId;

    @NotBlank
    private String playlistName;

    @NonNull
    private  Long userId;

    @NonNull
    private  Long videoId;

    @JoinTable
    @OneToMany
    private List<Video> videos;

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
    }

    public Long getVideoId() {    return videoId;}

    public void setVideoId(Long videoId) {  this.videoId = videoId;}

    public List<Video> getVideos() {return videos;}

    public void setVideos(List<Video> videos) { this.videos = videos;
    }
}
