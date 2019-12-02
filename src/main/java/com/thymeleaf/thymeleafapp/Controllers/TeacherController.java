package com.thymeleaf.thymeleafapp.Controllers;

import com.thymeleaf.thymeleafapp.Exception.TeacherNotFoundException;
import com.thymeleaf.thymeleafapp.Models.Teacher;
import com.thymeleaf.thymeleafapp.Services.Implementation.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    TeacherServiceImpl teacherServiceImpl;
    private static final String TEACHER_MODEL = "teacher";

    @Autowired
    TeacherController(TeacherServiceImpl teacherServiceImpl) {
        this.teacherServiceImpl = teacherServiceImpl;
    }

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("teachers", teacherServiceImpl.findAll());
        return "teachers";
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<Teacher> getOne(Integer Id) {return teacherServiceImpl.getOne(Id);}

    @PostMapping(value="addNew")
    public String addNew(Model model, @Valid @ModelAttribute(TEACHER_MODEL) Teacher teacher) throws TeacherNotFoundException {
        teacher.setUpdatedOn();
        teacherServiceImpl.addNew(teacher);
        return "redirect:/teachers/findAll";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Teacher teacher) {
        teacher.setUpdatedOn();
        teacherServiceImpl.updateTeacher(teacher);
        return "redirect:/teachers/findAll";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        teacherServiceImpl.delete(Id);
        return "redirect:/teachers/findAll";
    }

    @RequestMapping(value = "/search", method={RequestMethod.GET})
    public String search(Model model, String search){
        if(search.length()==0)
            return "redirect:/teachers/findAll";
        else {
            model.addAttribute("teachers", teacherServiceImpl.search(search));
            model.addAttribute("search", search);
            return "teachers";
        }
    }
}

