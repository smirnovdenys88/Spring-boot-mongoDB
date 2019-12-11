package com.mongoDB.post.service.impl;

import com.mongoDB.post.domain.Post;
import com.mongoDB.post.repo.PostMongoRepository;
import com.mongoDB.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMongoRepository repository;

    @Override
    public Post getById(String id) {
        Optional<Post> optional = repository.findById(id);
        return optional.orElse(new Post());
    }

    @Override
    public Page<Post> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    @Override
    public Post save(Post post) {
        return repository.save(post);
    }

    @Override
    public Post update(Post post) {
        return repository.save(post);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Post post) {
    }
}
