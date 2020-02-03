package org.mumyoutube.data;

import org.mumyoutube.model.Playlist;
import org.mumyoutube.model.Video;
import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
}
