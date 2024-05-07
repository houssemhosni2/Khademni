package com.example.khademni.controller;

import com.example.khademni.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("comments/create")
    public ResponseEntity<?> createComment(@RequestParam Long blogId, @RequestParam String postedBy, @RequestBody String content){
        try {
            return ResponseEntity.ok(commentService.createComment(blogId, postedBy, content));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }
    @GetMapping("comments/{blogId}")
    public ResponseEntity<?> getCommentsByBlogID(@PathVariable Long blogId){
        try{
            return ResponseEntity.ok(commentService.getCommentsByBlogId(blogId));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
        }
    }


}