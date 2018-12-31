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
        post.setId(RandomString.ID());
        mv.setViewName("post");
        if (request.getMethod().equals(RequestMethod.POST.toString())) {

            System.out.println(post.toString());
            boolean flag = postService.savePost(post);
            if (!flag) {
                mv.setViewName("/post/publish");
            }
            mv.setViewName("redirect:/post/" + post.getId());
        }
        return mv;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ModelAndView post(@PathVariable String id) {
        Post post = postService.getPostByID(id);

        ModelAndView mv = new ModelAndView();
        if (post == null) {
            //跳转至失败页
            mv.setViewName("fail");
            return mv;
        } else {
            //跳转至成功页
            System.out.println(post.toString());
            mv.setViewName("success");
            return mv;
        }
    }
}
