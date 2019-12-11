package com.mongoDB.post.controller;

import com.mongoDB.post.domain.Post;
import com.mongoDB.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("posts")
public class PostController {

    private static final int SIZE = 6;

    @Autowired
    private PostService postService;

    @GetMapping("{page}")
    public ModelAndView getAllPast(@PathVariable(value = "page", required = false) int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("post");

        modelAndView.addObject("list", postService.getAll(page, SIZE));
        modelAndView.addObject("totalPages",
                IntStream.rangeClosed(1, postService.getAll(page, SIZE).getTotalPages()).boxed().collect(Collectors.toList()));
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/post/save")
    public ModelAndView savePost(@ModelAttribute Post post) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("post");
        post.setId(UUID.randomUUID().toString());
        postService.save(post);

        modelAndView.addObject("list", postService.getAll(0, SIZE));
        modelAndView.addObject("totalPages",
                IntStream.rangeClosed(1, postService.getAll(0, SIZE).getTotalPages()).boxed().collect(Collectors.toList()));
        return modelAndView;
    }

    @GetMapping("/post/delete/{id}")
    public ModelAndView deletePost(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("post");
        postService.delete(id);

        modelAndView.addObject("post", new Post());
        modelAndView.addObject("list", postService.getAll(0, SIZE));
        modelAndView.addObject("totalPages",
                IntStream.rangeClosed(1, postService.getAll(0, SIZE).getTotalPages()).boxed().collect(Collectors.toList()));
        return modelAndView;
    }
}
