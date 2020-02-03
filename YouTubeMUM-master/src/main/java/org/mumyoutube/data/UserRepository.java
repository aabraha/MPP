package org.mumyoutube.data;

import org.mumyoutube.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {
    User findByUserName(String userName);

}
