package com.marlena.beautyschool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ContactController {

    private static Logger log = LoggerFactory.getLogger(ContactController.class);

    @RequestMapping("/contact")
    public String displayContactPage() {
        return "contact.html";
    }

    @RequestMapping(value = "/saveMsg", method = POST)
    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String phone,
                                    @RequestParam String email, @RequestParam String subject,
                                    @RequestParam String message) {
        log.info("Name: " + name);
        log.info("Phone number: " + phone);
        log.info("Email: " + email);
        log.info("Subject: " + subject);
        log.info("Message: " + message);
        return new ModelAndView("redirect:/contact");
    }
}
