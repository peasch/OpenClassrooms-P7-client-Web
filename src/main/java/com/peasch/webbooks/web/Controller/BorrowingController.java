package com.peasch.webbooks.web.Controller;

import com.peasch.webbooks.Beans.UserBean;
import com.peasch.webbooks.web.proxies.MicroserviceUserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Controller
public class BorrowingController {

    @Autowired
    MicroserviceUserProxy mUserProxy;

    @GetMapping("/borrowings/extend/{id}")
    public String prolongation(@PathVariable(name="id")Integer id, @ModelAttribute("userBean") UserBean user, ModelMap model){
        model.addAttribute("localDate", LocalDate.now());
        mUserProxy.extendBorrowing(id);

        return "index";
    }
}
