package com.vn.blog.blogservice.repository;

import com.vn.blog.blogservice.models.BlogPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepo extends JpaRepository<BlogPostEntity, Long> {
}
