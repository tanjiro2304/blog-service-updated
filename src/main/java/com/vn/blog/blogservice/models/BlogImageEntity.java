package com.vn.blog.blogservice.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BLOG_IMAGES")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogImageEntity {

    @Id
    @Column(name="IMAGE_ID")
    Long imageId;

    @Column(name="IMAGE")
    byte[] image;

    @ManyToMany(mappedBy = "blogImageEntityList")
    List<BlogPostEntity> blogPostEntityList;
}
