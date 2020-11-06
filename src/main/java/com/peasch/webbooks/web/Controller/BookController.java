package com.peasch.webbooks.web.Controller;

import com.peasch.webbooks.Beans.*;
import com.peasch.webbooks.web.proxies.MicroserviceUserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    @Autowired
    MicroserviceUserProxy mUserProxy;

    @GetMapping("/books")
    public String books (ModelMap model ){
        Research research = new Research();
        List<AuthorBean> authors = mUserProxy.getAuthors();
        List<CategoryBean> categories = mUserProxy.getCategories();

        model.addAttribute("authors",authors);
        model.addAttribute("categories",categories);
        model.addAttribute("research",research);
        return "bookSearch";
    }

    @PostMapping("/books")
    public String bookSearch(@ModelAttribute ("research") Research research, ModelMap model){
        System.out.println(research.toString());
        List<BookBean> books = mUserProxy.findBooksByAuthor(research);
        model.addAttribute("books",books);
        model.addAttribute("research",research);
        return "booksByAuthor";
    }

    @GetMapping("/collection")
    public String bookCollection(ModelMap model){
        List<BookBean> books = mUserProxy.getBooks();
        model.addAttribute("books",books);
        for (BookBean book:books){
            System.out.println(book.getCover());
        }
        return "bookList";
    }

    @GetMapping("/book/describe/{id}")
    public String bookDescribe(@PathVariable(name="id")Integer id,ModelMap model){
        List<LibraryBean> libraries = mUserProxy.getLibraries();
        BookBean book= mUserProxy.getBookById(id);
        Map<Integer,Integer> bookMap = mUserProxy.getCopiesofBookInLibraries(id);
        model.addAttribute("book",book);
        model.addAttribute("bookMap",bookMap);
        model.addAttribute("libraries",libraries);
        return "bookDescribe";
    }
}
