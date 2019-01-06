package com.github.candyacao.service;

import com.github.candyacao.bean.Post;
import com.github.candyacao.bean.User;

import java.util.List;

public interface PostService {

    public boolean savePost(Post post);
    public Post getPostByID(String id);
    public List<Post> getPostsAll(User user);
}
