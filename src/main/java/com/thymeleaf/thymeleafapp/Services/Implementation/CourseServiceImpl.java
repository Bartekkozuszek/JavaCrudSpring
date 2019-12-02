//package com.thymeleaf.thymeleafapp.Services.Implementation;
//
//import com.thymeleaf.thymeleafapp.Models.Course;
//import com.thymeleaf.thymeleafapp.Repository.CourseRepo;
//import com.thymeleaf.thymeleafapp.Services.CourseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//@Service
//public class CourseServiceImpl implements CourseService {
//
//    @Autowired
//    private CourseRepo courseRepo;
//
//    @Override
//    public Course save(Course course) {
//        return courseRepo.save(course);
//    }
//
//    @Override
//    public List<Course> findAll() {
//        return (List<Course>) courseRepo.findAll();
//    }
//
//    @Override
//    public Optional<Course> findById(Integer id) {
//        return courseRepo.findById(id);
//    }
//
//    @Override
//    public void deleteById(int id) {
//        courseRepo.deleteById(id);
//
//    }
//}
