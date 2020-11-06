package com.peasch.webbooks.web.Controller;

import com.peasch.webbooks.Beans.LibraryBean;
import com.peasch.webbooks.Beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.peasch.webbooks.web.proxies.MicroserviceUserProxy;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    MicroserviceUserProxy mUserProxy;


    @GetMapping("/users")
    public String users (ModelMap model ){
        List<UserBean> users = mUserProxy.getUsers();
        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping("/register")
    public String register (ModelMap model){
        UserBean userBean =new UserBean();
        model.addAttribute("userBean",userBean);
       // model.addAttribute("libraries",libraries);
        return "register";
    }

    @PostMapping("/register")
    public String registered (@Valid UserBean userBean, ModelMap model){
        mUserProxy.addUser(userBean);
        return "register";
    }
    @GetMapping("/login")
    public String login (ModelMap model){
        UserBean user =new UserBean();
        model.addAttribute("userBean",user);
        return "login";
    }

    @PostMapping("/login")
    public String LoggedIn (@ModelAttribute("userBean") UserBean user){
        String token=mUserProxy.login(user);
        System.out.println(token);
        return "index";
    }
}
