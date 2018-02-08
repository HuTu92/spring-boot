package com.github.fnpac.spring.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 刘春龙 on 2018/2/8.
 */
@Controller
public class DemoController {

    @RequestMapping("/advice")
    @ResponseBody
    public String doSomething(@ModelAttribute("msg") String message, DemoObj demoObj) {
        if (demoObj.getId() == null) {// @InitBinder 设置忽略id参数
            throw new IllegalArgumentException("非常抱歉，参数有误/" + "来自@ModelAttribute：" + message);
        }
        return "Success";
    }

    @RequestMapping("/error.html")
    public String toError() {
        return "/error";// 不加'/'报错
    }
}
