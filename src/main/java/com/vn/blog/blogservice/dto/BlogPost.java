package com.vn.blog.blogservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BlogPost {

    private Long blogPostId;
    private String blogText;

    private String blogDescription;
    private LocalDateTime postDateTime;
    private String blogTitle;
    private User user;
}
