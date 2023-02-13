package com.marlena.beautyschool.controller;

import com.marlena.beautyschool.model.BeautyClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("/displayClasses")
    public ModelAndView displayClasses(Model model){
        ModelAndView modelAndView = new ModelAndView("classes.html");
        modelAndView.addObject("beautyClass", new BeautyClass());
        return modelAndView;
    }

//    @RequestMapping("/displayCourses")
//    public ModelAndView displayCourses(Model model){
//        ModelAndView modelAndView = new ModelAndView("courses.html");
//        return modelAndView;
//    }
}
