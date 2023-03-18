package com.vn.blog.blogservice.repository;

import com.vn.blog.blogservice.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
}
