package com.twitter_backend.twitter_backend.repositorys;

import com.twitter_backend.twitter_backend.models.Hashtag;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    Hashtag findByName(String name);
}
