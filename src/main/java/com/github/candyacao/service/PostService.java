package com.github.candyacao.service;

import com.github.candyacao.bean.Post;

public interface PostService {

    public boolean savePost(Post post);
    public Post getPostByID(String id);
}
