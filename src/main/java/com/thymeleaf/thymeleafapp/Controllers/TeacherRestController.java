package com.thymeleaf.thymeleafapp.Controllers;

import com.thymeleaf.thymeleafapp.Exception.TeacherNotFoundException;
import com.thymeleaf.thymeleafapp.Models.Teacher;
import com.thymeleaf.thymeleafapp.Services.Implementation.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherRestController {

    TeacherServiceImpl teacherServiceImpl;
    private static final String TEACHER_MODEL = "teacher";


    @Autowired
    TeacherRestController(TeacherServiceImpl teacherServiceImpl){
        this.teacherServiceImpl = teacherServiceImpl;
    }

    @GetMapping("/")
    List<Teacher> all() {
        return teacherServiceImpl.findAll();
    }

    @PostMapping("/")
    Teacher newTeacher(@RequestBody Teacher newTeacher) {
        return teacherServiceImpl.save(newTeacher);
    }

    // Single item

    @GetMapping("/{id}")
    Teacher one(@PathVariable int id) throws TeacherNotFoundException {

        return teacherServiceImpl.getOne(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
    }

    @PutMapping("/{id}")
    Teacher replaceTeacher(@RequestBody Teacher newTeacher, @PathVariable int id) {
        return teacherServiceImpl.getOne(id)
                .map(teacher -> {
                    teacher.setName(newTeacher.getName());
                    teacher.setDepartment(newTeacher.getDepartment());
                    teacher.setUpdatedOn();
                    teacher.setUpdatedBy(newTeacher.getUpdatedBy());
                    return teacherServiceImpl.save(teacher);
                })
                .orElseGet(() -> {
                    newTeacher.setId(id);
                    return teacherServiceImpl.save(newTeacher);
                });
    }

    @DeleteMapping(value="/delete")
    public void delete(@PathVariable Integer Id) {
        teacherServiceImpl.delete(Id);
    }
}
