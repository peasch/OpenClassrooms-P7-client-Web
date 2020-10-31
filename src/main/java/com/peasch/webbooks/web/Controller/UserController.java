package com.peasch.webbooks.web.Controller;

import com.peasch.webbooks.Beans.LibraryBean;
import com.peasch.webbooks.Beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import com.peasch.webbooks.web.proxies.MicroserviceUserProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        List<LibraryBean> libraries = mUserProxy.getLibraries();
        model.addAttribute("userBean",userBean);
       // model.addAttribute("libraries",libraries);
        return "register";
    }

    @PostMapping("/register")
    public String registered (@Valid UserBean userBean, ModelMap model){
        mUserProxy.addUser(userBean);
        return "index";
    }
    @GetMapping("/login")
    public String login (ModelMap model){
        UserBean userBean =new UserBean();
        model.addAttribute("userBean",userBean);
        return "login";
    }

    @PostMapping("/login")
    public String LoggedIn (ModelMap model){
        UserBean userBean =new UserBean();
        model.addAttribute("userBean",userBean);
        return "profile";
    }
}
