package com.peasch.webbooks.web.services;
import com.peasch.webbooks.Beans.UserBean;

public interface UserBeanService {


    UserBean toUser(String userName, String password, String email, String name, String firstName);
}
