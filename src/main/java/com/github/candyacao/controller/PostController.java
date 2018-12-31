package com.github.candyacao.controller;

import com.github.candyacao.bean.Post;
import com.github.candyacao.service.PostService;
import com.github.candyacao.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/post/publish", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView publish(HttpServletRequest request, Post post) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("post");
        if (request.getMethod().equals(RequestMethod.POST.toString())) {
            post.setId(RandomString.ID());
            System.out.println(post.toString());
            if (!postService.savePost(post)) {
                mv.setViewName("/post/publish");
            } else {
                mv.setViewName("redirect:/post/" + post.getId());
            }
        }
        return mv;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ModelAndView post(@PathVariable String id) {
        ModelAndView mv = new ModelAndView();
        Post post = postService.getPostByID(id);
        if (post == null) {
            mv.setViewName("fail");
        } else {
            System.out.println(post.toString());
            mv.setViewName("success");
        }
        return mv;
    }
}
