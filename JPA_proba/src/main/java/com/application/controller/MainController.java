package com.application.controller;

import com.application.entity.Book;
import com.application.repositiory.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class MainController
{
    @Autowired
    public BookRepository bookRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/myrequest")
    public String myRequest( Model model)
    {
        Book itemToAdd = new Book(1L, "Sabriel", "Garth_Nix");
        bookRepository.save(itemToAdd);
        itemToAdd = new Book(2L, "Lirael", "Garth_Nix");
        bookRepository.save(itemToAdd);

        StringBuilder response = new StringBuilder();
        for(Book i: bookRepository.findAll()) {
            response.append(i).append("<br>");
        }

        model.addAttribute("message", response.toString());
        log.info(response.toString());

        return "nothing";
    }

    @PostMapping("/hello")
    public String sayHello(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
