package org.michael.mpstarter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dijunjie
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/{msg}")
    public String hello(@PathVariable("msg") String message) {
        return "hello " + message;
    }

}
