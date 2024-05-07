package com.example.khademni.service;

import com.example.khademni.entity.Blog;
import com.example.khademni.entity.Comment;
import com.example.khademni.repository.BlogRepository;
import com.example.khademni.repository.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class BlogServiceImp implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CommentRepository commentRepository;

    public Blog saveBlog(Blog blog) {
        blog.setLikeCount(0);
        blog.setViewCount(0);
        blog.setDate(new Date());
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();


    }

    public Blog getBlogById(Long blogId) {
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);
        if (optionalBlog.isPresent()) {
            Blog blog = optionalBlog.get();
            blog.setViewCount(blog.getViewCount() + 1);
            return blogRepository.save(blog);
        } else {
            throw new EntityNotFoundException("Blog not found");
        }

    }

    public void likeBlog(Long blogId){
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);
        if (optionalBlog.isPresent()) {
            Blog blog = optionalBlog.get();
            blog.setLikeCount(blog.getLikeCount() + 1);
            blogRepository.save(blog);
        }else{
            throw new EntityNotFoundException("Blog not found: " + blogId);
        }

    }
    public List<Blog> searchByName(String name) {
        return blogRepository.findAllByNameContaining(name);
    }
    public void deleteBlog(Long blogId) {
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);
        if (optionalBlog.isPresent()) {
            Blog blog = optionalBlog.get();
            // Delete associated comments
            List<Comment> comments = blog.getComments();
            commentRepository.deleteAll(comments);
            // Delete the blog
            blogRepository.deleteById(blogId);
        } else {
            throw new EntityNotFoundException("Blog not found: " + blogId);
        }
    }
    public Blog updateBlog(Long blogId, Blog updatedBlog) {
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);
        if (optionalBlog.isPresent()) {
            Blog blog = optionalBlog.get();
            blog.setName(updatedBlog.getName());
            blog.setContent(updatedBlog.getContent());
            blog.setImg(updatedBlog.getImg());
            blog.setTags(updatedBlog.getTags());
            // Update other fields as needed

            return blogRepository.save(blog);
        } else {
            throw new EntityNotFoundException("Blog not found: " + blogId);
        }
    }
}
