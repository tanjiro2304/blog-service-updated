package com.vn.blog.blogservice.utils;

public class GenerateId {
    public static final Long generateId(){
        int max = 9999;
        int min = 1;
        int range = max - min + 1;

        return Double.valueOf((Math.random() * range) + min).longValue();
    }
}
