package com.github.candyacao.dao;


import com.github.candyacao.bean.Post;

public interface PostDao {
    public int savePost(Post post);
    public Post getPostByID(String id);
}
