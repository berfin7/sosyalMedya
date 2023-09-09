package com.spring.proje.services;
import java.util.List;
import java.util.Optional;
import com.spring.proje.entities.User;

import com.spring.proje.entities.Comment;
import com.spring.proje.entities.Post;
import com.spring.proje.repos.CommentRepository;
import org.springframework.stereotype.Service;
import request.CommentCreateRequest;
import request.CommentUpdateRequest;

@Service
public class CommentService {

    private PostService postService;
    private UserService userService;

private CommentRepository commentRepository;
public CommentService(CommentRepository commentRepository,UserService userService,PostService postService){
    this.commentRepository=commentRepository;
    this.postService =postService;
    this.userService=userService;
}

    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId ) {
        if (userId.isPresent() && postId.isPresent()) {
            return  commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return  commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        }
else return commentRepository.findAll();

    }



    public Comment getOneCommentById(Long id) {
        return commentRepository.getById(id);
    }

    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {


  User user =userService.getOneUser(commentCreateRequest.getUserId());
  Post post=postService.getByIdPost(commentCreateRequest.getPostId());


    if (post != null && user != null){
        Comment comment=new Comment();
        comment.setId(commentCreateRequest.getId());
        comment.setUser(user);
        comment.setPost(post);
        comment.setText(commentCreateRequest.getText());
        return  commentRepository.save(comment);
    }

    else return null;

    }

    public Comment updateOneCommentById(Long id, CommentUpdateRequest updateOneCommentById) {
        Optional<Comment> commentCheck=commentRepository.findById(id);

        if(commentCheck.isPresent()){
            Comment comment=commentCheck.get();
            comment.setText(updateOneCommentById.getText());
            return commentRepository.save(comment);
        }


    else return null;
    }


    public void deleteOneComment(Long id) {
    commentRepository.deleteById(id);
    }
}
