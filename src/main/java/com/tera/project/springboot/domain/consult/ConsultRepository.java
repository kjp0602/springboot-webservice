package com.tera.project.springboot.domain.consult;

import com.tera.project.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultRepository extends JpaRepository<Consult, Long> {}