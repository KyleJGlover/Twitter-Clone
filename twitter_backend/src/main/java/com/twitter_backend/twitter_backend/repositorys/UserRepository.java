package com.twitter_backend.twitter_backend.repositorys;

import com.twitter_backend.twitter_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // custom query methods here
}
