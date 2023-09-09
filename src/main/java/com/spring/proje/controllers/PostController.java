package com.spring.proje.controllers;
import org.springframework.validation.annotation.Validated;


import com.spring.proje.entities.Post;
import com.spring.proje.services.PostService;
import org.springframework.web.bind.annotation.*;
import request.PostCreateRequest;
import request.PostUpdateRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {


    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.getAllPosts(userId);

    }


    @PostMapping
    public Post addOnePost(@RequestBody PostCreateRequest postCreateRequest){
        return postService.addOnePost(postCreateRequest);
    }



    @PutMapping("/{post_id}")
    public Post updateOnePost(@PathVariable Long id,@RequestBody PostUpdateRequest postUpdateRequest){
        return postService.updateOnePost(id,postUpdateRequest);
    }

@GetMapping("/{post_id}")
    public Post getByIdPost(@PathVariable Long id){
        return postService.getByIdPost(id);
}



@DeleteMapping("/{post_id}")
    public void deleteOnePost(@PathVariable Long id){
         postService.deleteOnePost(id);
}





















}
