package com.vn.blog.blogservice.controller;

import com.vn.blog.blogservice.converter.DtoConvertUtils;
import com.vn.blog.blogservice.dto.BlogPost;
import com.vn.blog.blogservice.repository.BlogPostRepo;
import com.vn.blog.blogservice.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController

@RequestMapping("/blog")
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;


    @GetMapping("/welcome")
    public String welcomePage(){
        return "Welcome to My Blog";
    }

    @GetMapping("/findById/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public BlogPost getPost(@PathVariable("id") Long id) throws SQLException, IOException {
        if(id == null){
            throw new RuntimeException("Invalid Id Please Try Again");
        }
        return blogPostService.findById(id);
    }

    @GetMapping("/findAll")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<BlogPost> findAllPost() throws SQLException, IOException {
        return blogPostService.findAll();
    }
}
