package com.github.candyacao.controller;

import com.github.candyacao.utils.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.candyacao.bean.User;
import com.github.candyacao.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "id", required = true) String id) {
        User user = userService.getUserById(id);

        ModelAndView mav = new ModelAndView();
        if (user == null) {
            //跳转至失败页
            mav.setViewName("fail");
            return mav;
        } else {
            //跳转至成功页
            mav.addObject("id", user.getId());
            mav.addObject("name", user.getUsername());
            mav.addObject("gender", user.getGender());
            mav.addObject("birthday", user.getBirthday());
            mav.setViewName("success");
            return mav;
        }
    }

    @RequestMapping(value = "/signup", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView register1(HttpServletRequest request, User user) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        if (request.getMethod().equals(RequestMethod.POST.toString())) {
            System.out.println(user.toString());
            if (!user.getPassword().equals(user.getPassword1())) {
                return mv;
            }
            user.setId(RandomString.ID());
            userService.saveUser(user);
            mv.setViewName("redirect:signin");
        }
        return mv;
    }

    @RequestMapping(value = "/signin", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView signin(HttpServletRequest request, HttpSession session, User user) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signin");
        if (request.getMethod().equals(RequestMethod.POST.toString())) {
            System.out.println(user.toString());
            User user1 = userService.login(user);
            if (user1 != null) {
                System.out.println(user1.toString());
                session.setAttribute("s", user1);
                mv.setViewName("redirect:/");
            }
        }
        return mv;
    }
}
