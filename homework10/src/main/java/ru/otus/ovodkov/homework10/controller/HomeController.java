package ru.otus.ovodkov.homework10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ovodkov Sergey
 * created on 11.08.2020
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
