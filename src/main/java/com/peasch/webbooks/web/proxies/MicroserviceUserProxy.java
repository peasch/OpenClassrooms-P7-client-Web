package com.peasch.webbooks.web.proxies;

import com.peasch.webbooks.Beans.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="MICROSERVICE-LIBRARY-MODEL", url = "localhost:8181")
public interface MicroserviceUserProxy {

    @GetMapping(value="/users")
    List<UserBean> getUsers();

    @GetMapping(value="/user/{id}")
    UserBean getUserById(@PathVariable(value = "id") Integer id);

    @PostMapping("/user/add")
    void addUser(@RequestBody UserBean userBean);

    @GetMapping("/libraries")
    List<LibraryBean> getLibraries();

    @GetMapping("/libraries/{id}")
    LibraryBean getLibraryById(@PathVariable(value = "id")Integer id);


    @PostMapping("/libraries/add")
    void addLibrary (@RequestBody LibraryBean libraryBean);

    @GetMapping("/books")
    List<BookBean> getBooks();

    @GetMapping("/authors")
    List<AuthorBean> getAuthors();

    @GetMapping("/categories")
    List<CategoryBean> getCategories();

    @PostMapping("/books/search")
    List<BookBean> findBooksByAuthor(@RequestBody Research research);
}
