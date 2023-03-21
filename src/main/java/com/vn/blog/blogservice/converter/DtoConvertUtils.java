package com.vn.blog.blogservice.converter;


import com.vn.blog.blogservice.dto.BlogPost;
import com.vn.blog.blogservice.dto.User;
import com.vn.blog.blogservice.models.BlogPostEntity;
import com.vn.blog.blogservice.models.UserEntity;
import org.springframework.jdbc.core.metadata.OracleCallMetaDataProvider;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;

import static org.springframework.jdbc.datasource.DataSourceUtils.getConnection;

public class DtoConvertUtils {
    public static BlogPost convertBlogPostEntityToDTO(BlogPostEntity entity) throws SQLException, IOException {
        return BlogPost.builder().
                blogPostId(entity.getPostId()).
                blogTitle(entity.getPostTitle()).
                blogDescription(entity.getDescription()).
                blogText(convertClobToString(entity.getClob())).
                postDateTime(entity.getPostDateTime()).
                user(User.builder().
                        userId(entity.getUserEntity().getUserId()).
                        userName(entity.getUserEntity().getUserName()).build()).
                build();
    }

    public static BlogPostEntity convertBlogDtoToEntity(BlogPost blog) throws SQLException, IOException {
        return BlogPostEntity.builder().
                postId(blog.getBlogPostId()).
                postTitle(blog.getBlogTitle()).
                description(blog.getBlogDescription()).
                clob(convertStringToClob(blog.getBlogText())).
                postDateTime(blog.getPostDateTime()).
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

    public static Clob convertStringToClob(String blogContent) throws SQLException, IOException {
        Connection conn = getConnection();
        Clob clob = conn.createClob();
        clob.setString(1,blogContent);
        return clob;
    }

    private static Connection getConnection() throws SQLException {
        // establish and return a database connection
        return null;
    }
}
