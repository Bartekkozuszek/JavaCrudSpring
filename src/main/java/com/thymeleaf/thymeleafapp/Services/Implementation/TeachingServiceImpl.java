//package com.thymeleaf.thymeleafapp.Services.Implementation;
//
//import com.thymeleaf.thymeleafapp.Models.Teaching;
//import com.thymeleaf.thymeleafapp.Repository.TeachingRepo;
//import com.thymeleaf.thymeleafapp.Services.TeachingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TeachingServiceImpl implements TeachingService {
//
//    @Autowired
//    private TeachingRepo teachingRepo;
//
//    @Override
//    public Teaching save(Teaching teaching) {
//        return teachingRepo.save(teaching);
//    }
//
//    @Override
//    public List<Teaching> findAll() {
//        return (List<Teaching>) teachingRepo.findAll();
//    }
//
//    @Override
//    public List<Teaching> findAllByTeacherID(int id) {
//        {
//            List<Teaching> allTeachings = (List<Teaching>) teachingRepo.findAll();
//            List<Teaching> usersTeachings = new ArrayList<Teaching>();
//            for (Teaching t : allTeachings) {
//                if (t.getTeacher().getId() == id) {
//                    usersTeachings.add(t);
//                }
//            }
//            return usersTeachings;
//        }
//    }
//
//    @Override
//    public Optional<Teaching> findById(Integer id) {
//        return teachingRepo.findById(id);
//    }
//
//    @Override
//    public void deleteById(int id) {
//
//    }
//}
