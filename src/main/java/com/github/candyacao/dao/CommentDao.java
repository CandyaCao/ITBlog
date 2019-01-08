package com.github.candyacao.dao;


import com.github.candyacao.bean.Comment;

import java.util.List;

public interface CommentDao {
      public boolean saveComment(Comment comment);
      public boolean deleteComment(Comment comment);
      public List<Comment> selectAllComment(String postID);
}
