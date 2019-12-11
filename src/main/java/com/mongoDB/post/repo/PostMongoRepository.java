package com.mongoDB.post.repo;

import com.mongoDB.post.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostMongoRepository extends MongoRepository<Post, String> {
}
