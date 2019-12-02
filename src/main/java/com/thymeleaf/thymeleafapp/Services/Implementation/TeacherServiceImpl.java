package com.thymeleaf.thymeleafapp.Services.Implementation;

import com.thymeleaf.thymeleafapp.Exception.TeacherNotFoundException;
import com.thymeleaf.thymeleafapp.Models.Teacher;
import com.thymeleaf.thymeleafapp.Repository.TeacherRepo;
import com.thymeleaf.thymeleafapp.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class TeacherServiceImpl implements TeacherService {


    private TeacherRepo teacherRepo;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo){
        this.teacherRepo = teacherRepo;
    }

    @Transactional
    public List<Teacher> search(String s){
        return teacherRepo.search(s);
    }

    @Transactional
    public Teacher save(Teacher s){
        teacherRepo.save(s);
        return s;
    }

    @Transactional
    public int createTeacher(Teacher s) throws TeacherNotFoundException {
        if(!teacherExisted(s)){
            teacherRepo.save(s);
            return s.getId();
        }else if(getId(s)!=null){
            return getId(s);
        }
        throw new TeacherNotFoundException();
    }

    @Transactional
    public Integer getId(Teacher teacher){
        if(teacherExisted(teacher)){
            return teacherRepo.findTeacher(teacher.getDepartment(),teacher.getName(), teacher.getUpdatedBy(), teacher.getUpdatedOn());
        }else
            return null;
    }

    @Transactional
    public boolean teacherExisted(Teacher teacher) {
        int c = teacherRepo.countTeacher(teacher.getDepartment(),teacher.getName(), teacher.getUpdatedBy(), teacher.getUpdatedOn());
        if(c!=0)
            return true;
        return false;
    }


    public Teacher addNew(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Transactional
    public List<Teacher> findAll() {
        return (List<Teacher>) teacherRepo.findAll();
    }

    public Optional<Teacher> getOne(Integer id) {
        return teacherRepo.findById(id);
    }

    public void updateTeacher(Teacher teacher) {
    }

    public void delete(int id) {
        teacherRepo.deleteById(id);
    }


}
