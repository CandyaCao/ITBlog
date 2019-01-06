package com.github.candyacao.controller;

import com.github.candyacao.bean.Post;
import com.github.candyacao.bean.User;
import com.github.candyacao.service.PostService;
import com.github.candyacao.service.UserService;
import com.github.candyacao.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @RequestMapping(value="/publish", method={RequestMethod.POST, RequestMethod.GET})
    public ModelAndView publish(HttpServletRequest request, Post post){
        ModelAndView mv = new ModelAndView();
        User me =(User) request.getSession().getAttribute("s");
        mv.setViewName("postPublish");
        if (request.getMethod().equals(RequestMethod.POST.toString())){
            post.setId(RandomString.ID());
            post.setAuthorID(me.getId());
            post.setCreateDate(new Date());
            if (postService.savePost(post)) {
                mv.setViewName("redirect:/post/" + post.getId());
            }
        }
        return mv;
    }
    @RequestMapping(value = "/post", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getPost(HttpServletRequest request, String userID) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("postsShow");
        User user;
        if (userID != null && userID.equals("")){
            user = userService.getUserById(userID);
        }else {
            user =(User) request.getSession().getAttribute("s");
        }
        if (user != null){
            List<Post> posts = postService.getPostsAll(user);
            mv.addObject("posts", posts);
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
