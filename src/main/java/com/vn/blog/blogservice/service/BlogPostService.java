package com.vn.blog.blogservice.service;


import com.vn.blog.blogservice.dto.BlogPost;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface BlogPostService {
    BlogPost findById(Long id) throws SQLException, IOException;

    List<BlogPost> findAll() throws SQLException, IOException ;
}
