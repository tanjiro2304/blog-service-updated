package com.vn.blog.blogservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.sql.Clob;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BlogPost {

    private Long blogPostId;

    private Long userId;

    private String blogText;

    private LocalDateTime postDateTime;

    private String postTitle;

    private User user;
}
