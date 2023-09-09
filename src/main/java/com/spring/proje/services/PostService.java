package com.spring.proje.services;
import com.spring.proje.entities.Post;

import com.spring.proje.entities.User;
import com.spring.proje.repos.PostRepository;
import org.springframework.stereotype.Service;
import request.PostCreateRequest;
import request.PostUpdateRequest;

import java.util.List;
import java.util.Optional;
@Service
public class PostService {

    private PostRepository postRepository;
private UserService userService;
    public PostService(PostRepository postRepository,UserService userService) {
        this.postRepository = postRepository;
        this.userService=userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId){

    return postRepository.findAll();
    }

    public Post getByIdPost(Long postId){
        return postRepository.getById(postId);
    }

    public Post addOnePost(PostCreateRequest postCreateRequest){

        User user = userService.getOneUser(postCreateRequest.getId());
        if (user==null)
        return null;
        else {
            Post post=new Post();
            post.setId(postCreateRequest.getId());
            post.setTitle(postCreateRequest.getTitle());
            post.setText(postCreateRequest.getText());
            post.setUser(user);
            return postRepository.save(post);
        }
    }

    public void deleteOnePost(Long id){
        postRepository.deleteById(id);
    }

     public Post updateOnePost(Long id, PostUpdateRequest postUpdateRequest){


       Optional<Post> post = postRepository.findById(id);

       if(post.isPresent()){

          Post postGet = post.get();
           postGet.setText(postUpdateRequest.getText());
           postGet.setTitle(postUpdateRequest.getTitle());
            postRepository.save(postGet);
       return postGet;
       }


    else return null;

    }











}
