package com.github.candyacao.service.impl;

import com.github.candyacao.bean.Comment;
import com.github.candyacao.dao.CommentDao;
import com.github.candyacao.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;


    public boolean saveComment(Comment comment) {

        return commentDao.saveComment(comment);
    }

    public boolean deleteComment(Comment comment) {
        return commentDao.deleteComment(comment);
    }

    public List<Comment> selectAllComment(String postID) {
        return commentDao.selectAllComment(postID);
    }
}
