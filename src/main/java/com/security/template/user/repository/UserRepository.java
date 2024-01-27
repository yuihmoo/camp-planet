package com.security.template.user.repository;

import com.security.template.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User save(User user);
    User findByName(String name);
}
