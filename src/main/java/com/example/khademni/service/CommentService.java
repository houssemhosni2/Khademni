package com.example.khademni.service;

import com.example.khademni.entity.Comment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CommentService {
    Comment createComment(Long blogId, String postedBy, String content);
    List<Comment> getCommentsByBlogId(Long blogId);
}