package com.example.khademni.service;

import com.example.khademni.entity.Blog;

import java.util.List;

public interface BlogService {
    Blog saveBlog(Blog blog);

    List<Blog> getAllBlogs();
    Blog getBlogById(Long blogId);
    void likeBlog(Long blogId);
    List<Blog> searchByName(String name);
    void deleteBlog(Long blogId);
    Blog updateBlog(Long blogId, Blog updatedBlog);

}
