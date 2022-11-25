package com.marlena.beautyschool.controller;

import com.marlena.beautyschool.model.Event;
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
        List<Event> events = Arrays.asList(
                new Event(" 26 November ", "Meeting with the make-up artist, Hamburg", Event.Type.LOCAL),
                new Event(" 27 November ", "10 questions to... monthly meeting with professionals", Event.Type.ONLINE),
                new Event(" 30 November ", "How to make money in cosmetology", Event.Type.ONLINE),
                new Event(" 02 December ", "How to choose hair dye, sponsored by Loreal", Event.Type.ONLINE),
                new Event(" 02 December ", "Marco Lavazza in Paris", Event.Type.LOCAL),
                new Event(" 03 December ", "First Saturday of the month with Dr. Bevola", Event.Type.ONLINE),
                new Event(" 04 December ", "What's in Milan, cosmetic novelties", Event.Type.ONLINE),
                new Event(" 08 December ", "Discover a new body rejuvenating treatment", Event.Type.ONLINE),
                new Event(" 09 December ", "Fan meeting with Bruno Banani", Event.Type.LOCAL),
                new Event(" 10 December ", "The final of the competition for our students", Event.Type.ONLINE),
                new Event(" 14 January ", "Grand sponsors' carnival ball, Spain, Malaga", Event.Type.LOCAL),
                new Event(" 15 January ", "Grand sponsors' carnival ball, United States, Las Vegas", Event.Type.LOCAL)
        );

        Event.Type[] types = Event.Type.values();
        for (Event.Type type : types) {
            model.addAttribute(type.toString(),
                    (events.stream().filter(event -> event.getType().equals(type)).collect(Collectors.toList())));
        }
        return "events.html";

    }

}
