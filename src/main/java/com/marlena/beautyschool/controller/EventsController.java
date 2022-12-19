package com.marlena.beautyschool.controller;

import com.marlena.beautyschool.model.Event;
import com.marlena.beautyschool.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EventsController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events/{display}")
    public String displayEvents(@PathVariable String display, Model model) {

        if (null != display && display.equals("all")) {
            model.addAttribute("local", true);
            model.addAttribute("online", true);
        } else if (null != display && display.equals("local")) {
            model.addAttribute("local", true);
        } else if (null != display && display.equals("online")) {
            model.addAttribute("online", true);
        }
        List<Event> events = eventRepository.findAllEvents();

        Event.Type[] types = Event.Type.values();
        for (Event.Type type : types) {
            model.addAttribute(type.toString(),
                    (events.stream().filter(event -> event.getType().equals(type)).collect(Collectors.toList())));
        }
        return "events.html";

    }

}
