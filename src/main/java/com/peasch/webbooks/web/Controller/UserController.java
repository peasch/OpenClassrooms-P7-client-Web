package com.peasch.webbooks.web.Controller;

import com.peasch.webbooks.Beans.LibraryBean;
import com.peasch.webbooks.Beans.UserBean;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.peasch.webbooks.web.proxies.MicroserviceUserProxy;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
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
    public String LoggedIn (@ModelAttribute("userBean") UserBean user, ModelMap model){
        String token=mUserProxy.login(user);
        SimpleDateFormat sdf = new SimpleDateFormat("dd--MM--yy");
        UserBean  userSession = mUserProxy.getUserByUserName(user.getUserName());
        System.out.println(token);
        model.addAttribute("user",userSession);
        model.addAttribute("borrowings",userSession.getBorrowings());
        model.addAttribute("localDate", LocalDate.now());



        return "profile";
    }


}
