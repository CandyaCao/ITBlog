package com.github.candyacao.service.impl;

import com.github.candyacao.dao.CommentDao;
import com.github.candyacao.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;


}
