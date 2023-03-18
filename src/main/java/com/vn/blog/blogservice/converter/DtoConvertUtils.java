package com.vn.blog.blogservice.converter;


import com.vn.blog.blogservice.dto.BlogPost;
import com.vn.blog.blogservice.dto.User;
import com.vn.blog.blogservice.models.BlogPostEntity;
import com.vn.blog.blogservice.models.UserEntity;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

public class DtoConvertUtils {
    public static BlogPost convertBlogPostEntityToDTO(BlogPostEntity entity) throws SQLException, IOException {
        return BlogPost.builder().
                blogPostId(entity.getPostId()).
                postTitle(entity.getPostTitle()).
                blogText(convertClobToString(entity.getClob())).
                postDateTime(entity.getPostDateTime()).
                user(User.builder().
                        userId(entity.getUserEntity().getUserId()).
                        userName(entity.getUserEntity().getUserName()).build()).
                build();
    }

    public static User convertUserEntityToDTO(UserEntity userEntity){
        return User.builder().
                userId(userEntity.getUserId()).
                userName(userEntity.getUserName()).build();
    }

    public static String convertClobToString(Clob clob) throws SQLException, IOException {
        Reader reader = clob.getCharacterStream();
        StringBuilder data = new StringBuilder();
        char[] buffer = new char[10000];
        int bytesRead;

        while((bytesRead = reader.read(buffer))!= -1){
            data.append(buffer, 0, bytesRead);
        }
        return data.toString();
    }
}
