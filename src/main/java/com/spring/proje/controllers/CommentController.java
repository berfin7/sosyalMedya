package com.spring.proje.controllers;
import org.springframework.validation.annotation.Validated;


import com.spring.proje.entities.Comment;
import com.spring.proje.services.CommentService;
import org.springframework.web.bind.annotation.*;
import request.CommentCreateRequest;
import request.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId){

        return commentService.getAllCommentsWithParam(userId,postId);
    }

    @GetMapping("/{comment_id}")
    public Comment getOneCommentById(@PathVariable Long id){
        return commentService.getOneCommentById(id);
    }


    @PostMapping
    public Comment addOneComment(@RequestBody CommentCreateRequest commentRequest){
        return commentService.createOneComment(commentRequest);
    }

    @PutMapping("/{comment_id}")
public Comment updateOneCommentById(@PathVariable Long id,@RequestBody CommentUpdateRequest commentUpdateRequest){
        return commentService.updateOneCommentById(id,commentUpdateRequest);
    }

    @DeleteMapping("/{comment_id}")
    public void deleteOneComment(@PathVariable Long id){
        commentService.deleteOneComment(id);
    }






}
