package com.peasch.webbooks.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.peasch.webbooks.web.Beans.UserBean;
import com.peasch.webbooks.web.proxies.MicroserviceUserProxy;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    MicroserviceUserProxy mUserProxy;

    @GetMapping("/home")
    public String accueil (ModelMap model ){
        List<UserBean> users = mUserProxy.getUsers();
        model.addAttribute("users",users);
        return "index";
    }
}
