package com.whut.controller;

import com.whut.bean.User;
import com.whut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public ModelAndView login(User user){
        int id=userService.login(user.getUsername(),user.getPassword());
        ModelAndView mv=new ModelAndView();
        if(id!=-1){
            mv.setViewName("main");
        }else {
            mv.setViewName("../failer");
        }
        return mv;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<User> users=userService.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/add.do")
    public String add(User user){
        userService.add(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteById.do")
    public String deleteById(int id){
        userService.deleteById(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/toUpdate.do")
    public ModelAndView toUpdate(int id){
        User user=userService.selectUserById(id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("user-update");
        mv.addObject("user",user);
        return mv;
    }

    @RequestMapping("/update.do")
    public String update(User user){
        userService.update(user);
        return "redirect:findAll.do";
    }

}
