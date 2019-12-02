package com.thymeleaf.thymeleafapp.Services;

import com.thymeleaf.thymeleafapp.Exception.StudentNotFoundException;
import com.thymeleaf.thymeleafapp.Exception.TeacherNotFoundException;
import com.thymeleaf.thymeleafapp.Models.Student;
import com.thymeleaf.thymeleafapp.Models.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> search(String s);
    int createTeacher(Teacher s) throws TeacherNotFoundException;
    boolean teacherExisted(Teacher teacher);
    Teacher addNew(Teacher teacher);
    Iterable<Teacher> findAll();
    Optional<Teacher> getOne(Integer id);
    void updateTeacher(Teacher teacher);
    void delete(int id);

}
