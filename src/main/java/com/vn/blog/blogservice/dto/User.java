package com.vn.blog.blogservice.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    Long userId;
    String userName;
}
