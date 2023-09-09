package com.spring.proje.services;

import com.spring.proje.entities.Comment;
import com.spring.proje.entities.Like;
import com.spring.proje.repos.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LikeService {

    private LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public List<Like> getAllLikes() {
    return likeRepository.findAll();
    }

    public Like getByIdLike(Long id) {

    return likeRepository.getById(id);
    }

    public Like addOneLike(Like like) {
        return likeRepository.save(like);
    }

    public Like updateOneLike(Long id, Like likeUpdate) {
        Optional<Like> likeCheck=likeRepository.findById(id);
        if(likeCheck.isPresent()){
            Like like=likeCheck.get();
            like.setPost(likeUpdate.getPost());
            like.setUser(likeUpdate.getUser());
            return likeRepository.save(like);
        }
        else return null;
    }

    public void deleteOneLike(Long id) {
         likeRepository.deleteById(id);
    }
}
