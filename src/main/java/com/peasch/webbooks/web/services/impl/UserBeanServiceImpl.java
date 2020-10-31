package com.peasch.webbooks.web.services.impl;

import com.peasch.webbooks.Beans.UserBean;
import com.peasch.webbooks.web.services.UserBeanService;

public class UserBeanServiceImpl implements UserBeanService {

    @Override
    public UserBean toUser (String userName, String password, String email, String name, String firstName) {
        UserBean userBean = new UserBean();
        userBean.setPassword(password);
        userBean.setName(name);
        userBean.setFirstName(firstName);
        userBean.setEmail(email);
        userBean.setUserName(userName);
        return userBean;
    }
}
