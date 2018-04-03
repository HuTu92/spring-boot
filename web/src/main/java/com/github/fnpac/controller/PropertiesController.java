package com.github.fnpac.controller;

import com.github.fnpac.spring.properties.Author;
import com.github.fnpac.spring.properties.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 刘春龙 on 2018/2/28.
 */
@Controller
public class PropertiesController {

    private final Author author;

    private final Description description;

    @Autowired
    public PropertiesController(Author author, Description description) {
        this.author = author;
        this.description = description;
    }

    @RequestMapping(value = "/app/info", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String info() {
        return author.getUsername() + " - " + author.getEmail() + " - " + description.getDescription();
    }
}
