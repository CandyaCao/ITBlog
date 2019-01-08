package com.github.candyacao.controller;

import com.github.candyacao.bean.Comment;
import com.github.candyacao.bean.User;
import com.github.candyacao.service.CommentService;
import com.github.candyacao.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/postComment", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView addComment(HttpServletRequest request, String postID, Comment comment){
        ModelAndView mv = new ModelAndView();
        System.out.println(postID);
        System.out.println(comment);
        User me = (User)request.getSession().getAttribute("s");
        mv.setViewName("redirect:/post/" + postID);
        if (postID != null && !postID.equals("")){
            comment.setId(RandomString.ID());
            comment.setCreateDate(new Date());
            comment.setPostID(postID);
            comment.setUser(me);
            if (!commentService.saveComment(comment)){
                mv.addObject("msg","评论失败！");
            }

        }
        return mv;
    }

}
