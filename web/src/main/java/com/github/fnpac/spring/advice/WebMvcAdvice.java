package com.github.fnpac.spring.advice;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 刘春龙 on 2018/2/8.
 */
@ControllerAdvice
public class WebMvcAdvice {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(Exception e, WebRequest request) {
//        ModelAndView modelAndView = new ModelAndView("error");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        modelAndView.setViewName("/error");// 不加'/'报错
        modelAndView.addObject("message", e.getMessage());

        return modelAndView;
    }

    /**
     * 将指定键值对添加到全局
     *
     * @param model
     */
    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("msg", "全局异常处理");
    }

    /**
     * 设置忽略request中id参数
     *
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

}
