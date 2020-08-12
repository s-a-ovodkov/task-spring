package ru.otus.ovodkov.homework10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ovodkov Sergey
 * created on 11.08.2020
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
