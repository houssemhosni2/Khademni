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
public class CommentServiceImp implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BlogRepository blogRepository;

    public Comment createComment(Long blogId, String postedBy, String content) {
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);
        if (optionalBlog.isPresent()) {
            Comment comment = new Comment();
            comment.setBlog(optionalBlog.get());
            comment.setContent(content);
            comment.setPostedBy(postedBy);
            comment.setCreatedAt(new Date());
            return commentRepository.save(comment);

        }
        throw new EntityNotFoundException("Blog not found");
    }

    public List<Comment> getCommentsByBlogId(Long blogId){
        return commentRepository.findByBlogId(blogId);
    }

}

