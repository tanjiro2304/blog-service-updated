package com.vn.blog.blogservice.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Clob;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "BLOG_POSTS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogPostEntity {
    @Id
    @Column(name = "POST_ID")
    Long postId;

    @Column(name="POST_CONTENT")
    Clob clob;

    @Column(name="POST_DATE_TIME")
    LocalDateTime postDateTime;

    @Column(name = "POST_TITLE")
    String postTitle;


    @ManyToOne
    @JoinColumn(name="USER_ID")
    UserEntity userEntity;

    @ManyToMany
    @JoinTable(name = "BLOG_IMAGE_POST",
            joinColumns = @JoinColumn (name="POST_ID"),
            inverseJoinColumns = @JoinColumn(name = "IMAGE_ID"))
    List<BlogImageEntity> blogImageEntityList;
}
