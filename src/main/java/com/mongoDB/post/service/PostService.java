package com.mongoDB.post.service;

import com.mongoDB.post.domain.Post;
import org.springframework.data.domain.Page;

public interface PostService {
    Post getById(String id);

    Page<Post> getAll(int page, int size);

    Post save(Post post);

    Post update(Post post);

    void delete(String id);

    void delete(Post post);
}
