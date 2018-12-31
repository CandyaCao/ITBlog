package com.github.candyacao.controller;

import com.github.candyacao.bean.Post;
import com.github.candyacao.bean.User;
import com.github.candyacao.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/publish", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView publish(HttpServletRequest request, Post post) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("post");
        if (request.getMethod().equals(RequestMethod.POST.toString())) {

            System.out.println(post.toString());
            postService.savePost(post);
            mv.setViewName("");
        }
        return mv;
    }
}
