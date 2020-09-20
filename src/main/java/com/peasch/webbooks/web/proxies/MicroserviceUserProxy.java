package com.peasch.webbooks.web.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.peasch.webbooks.web.Beans.UserBean;

import java.util.List;

@FeignClient(name="MICROSERVICE-LIBRARY-MODEL", url = "localhost:8181")
public interface MicroserviceUserProxy {

    @GetMapping(value="/users")
    List<UserBean> getUsers();

    @GetMapping(value="/user/{id}")
    UserBean getUserById(@PathVariable(value = "id") Integer id);
}
