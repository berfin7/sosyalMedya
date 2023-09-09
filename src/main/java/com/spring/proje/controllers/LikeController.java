package com.spring.proje.controllers;
import org.springframework.validation.annotation.Validated;

import com.spring.proje.entities.Comment;
import com.spring.proje.entities.Like;
import com.spring.proje.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("likes")
public class LikeController {


private LikeService likeService;
public LikeController(LikeService likeService){
    this.likeService=likeService;
}




    @GetMapping
    public List<Like> getAllLikes(){
        return likeService.getAllLikes();
    }

    @GetMapping("/{like_id}")
    public Like getByIdLike(@PathVariable Long id){
        return likeService.getByIdLike(id);
    }


    @PostMapping
    public Like addOneLike(@RequestBody Like like){
        return likeService.addOneLike(like);
    }

    @PutMapping("/{like_id}")
    public Like updateOneLike(@PathVariable Long id,@RequestBody Like like){
        return likeService.updateOneLike(id,like);
    }

    @DeleteMapping("/{like_id}")
    public void deleteOneLike(@Validated Long id){
        likeService.deleteOneLike(id);
    }

}
