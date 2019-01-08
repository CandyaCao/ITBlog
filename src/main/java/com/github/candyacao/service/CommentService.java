package com.github.candyacao.service;

import com.github.candyacao.bean.Comment;

import java.util.List;

public interface CommentService {
    public boolean saveComment(Comment comment);
    public boolean deleteComment(Comment comment);
    public List<Comment> selectAllComment(String postID);
}
