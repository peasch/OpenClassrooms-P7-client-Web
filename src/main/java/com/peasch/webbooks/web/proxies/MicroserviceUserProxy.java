package com.peasch.webbooks.web.proxies;

import com.peasch.webbooks.Beans.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name="MICROSERVICE-LIBRARY-MODEL", url = "localhost:8181")
public interface MicroserviceUserProxy {


    @GetMapping(value="/users")
    List<UserBean> getUsers();

    @GetMapping(value="/user/{id}")
    UserBean getUserById(@PathVariable(value = "id") Integer id);

    @PostMapping("/api/auth/register")
    void addUser(@RequestBody UserBean userBean);

    @PostMapping("/api/auth/login")
    String login(@RequestBody UserBean user);

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

    @GetMapping("/books/{id}")
    BookBean getBookById(@PathVariable(value = "id")Integer id);

    @GetMapping("/copies/book/{id}")
    Map<Integer,Integer> getCopiesofBookInLibraries(@PathVariable(value="id")Integer id);



}
