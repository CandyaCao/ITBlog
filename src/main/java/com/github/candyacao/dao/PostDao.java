package com.github.candyacao.dao;


import com.github.candyacao.bean.Post;
import com.github.candyacao.bean.User;

import java.util.List;

public interface PostDao {
    public int savePost(Post post);
    public Post getPostByID(String id);
    public List<Post> getPostsByAuthor(User user);
}
