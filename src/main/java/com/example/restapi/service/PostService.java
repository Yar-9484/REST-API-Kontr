package com.example.restapi.service;

import com.example.restapi.model.Post;
import com.example.restapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // Інші методи для перегляду, редагування і видалення постів
}