package com.vn.blog.blogservice.models;

import lombok.*;
import org.springframework.data.util.Lazy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BLOG_USERS_CREDENTIALS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @Column(name="USER_ID")
    Long userId;

    @Column(name="USER_NAME")
    String userName;

    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<BlogPostEntity> blogPostEntityList;

}
