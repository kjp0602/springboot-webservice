package com.tera.project.springboot.domain.store;

import com.tera.project.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Posts, Long> {}