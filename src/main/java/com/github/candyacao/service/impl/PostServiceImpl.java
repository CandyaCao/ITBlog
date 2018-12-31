package com.github.candyacao.service.impl;

import com.github.candyacao.bean.Post;
import com.github.candyacao.dao.PostDao;
import com.github.candyacao.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;


    public boolean savePost(Post post) {
        int times = 5;
        int num = postDao.savePost(post);
        while (times > 0) {
            if (num <= 0) {
                times--;
                System.out.println("重新次数："+times);
            } else {
                break;
            }
        }
        return num > 0;
    }

    public Post getPostByID(String id) {
        return postDao.getPostByID(id);
    }
}
