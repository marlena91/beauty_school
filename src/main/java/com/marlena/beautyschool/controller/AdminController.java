package com.marlena.beautyschool.controller;

import com.marlena.beautyschool.model.BeautyClass;
import com.marlena.beautyschool.model.Person;
import com.marlena.beautyschool.repository.BeautyClassRepository;
import com.marlena.beautyschool.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    BeautyClassRepository beautyClassRepository;

    @Autowired
    PersonRepository  personRepository;

    @RequestMapping("/displayClasses")
    public ModelAndView displayClasses(Model model){
        List<BeautyClass> beautyClasses = beautyClassRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("classes.html");
        modelAndView.addObject("beautyClasses", beautyClasses);
        modelAndView.addObject("beautyClass", new BeautyClass());
        return modelAndView;
    }

    @PostMapping("/addNewClass")
    public ModelAndView addNewClass(Model model, @ModelAttribute("beautyClass") BeautyClass beautyClass) {
        beautyClassRepository.save(beautyClass);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

    @RequestMapping("/deleteClass")
    public ModelAndView deleteClass(Model model, @RequestParam int id) {
        Optional<BeautyClass> beautyClass = beautyClassRepository.findById(id);
        for(Person person : beautyClass.get().getPersons()) {
            person.setBeautyClass(null);
            personRepository.save(person);
        }
        beautyClassRepository.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

    @GetMapping("/displayStudents")
    public ModelAndView displayStudents(Model model, @RequestParam int classId, HttpSession httpSession,
                                        @RequestParam(value="error", required = false) String error) {
        String errorMessage = null;
        ModelAndView modelAndView = new ModelAndView("students.html");
        Optional<BeautyClass> beautyClass = beautyClassRepository.findById(classId);
        modelAndView.addObject("beautyClass", beautyClass.get());
        modelAndView.addObject("person", new Person());
        httpSession.setAttribute("beautyClass", beautyClass.get());
        if(error != null) {
            errorMessage = "Invalid Email entered!";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }

    @PostMapping("/addStudent")
    public ModelAndView addStudent(Model model, @ModelAttribute("person") Person person, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        BeautyClass beautyClass = (BeautyClass) httpSession.getAttribute("beautyClass");
        Person personEntity = personRepository.readByEmail(person.getEmail());
        if(personEntity==null || !(personEntity.getPersonId()>0)){
            modelAndView.setViewName("redirect:/admin/displayStudents?classId="+beautyClass.getClassId()
            +"&error=true");
            return modelAndView;
        }
        personEntity.setBeautyClass(beautyClass);
        personRepository.save(personEntity);
        beautyClass.getPersons().add(personEntity);
        beautyClassRepository.save(beautyClass);
        modelAndView.setViewName("redirect:/admin/displayStudents?classId="+beautyClass.getClassId());
        return modelAndView;
    }

}
