package com.mongoDB.post.domain;

import org.springframework.data.annotation.Id;

public class Post {
    @Id
    private String id;
    private String subject;
    private String text;

    public Post() {
    }

    public Post(String id, String subject, String text) {
        this.id = id;
        this.subject = subject;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
