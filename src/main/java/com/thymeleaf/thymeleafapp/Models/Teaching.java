//package com.thymeleaf.thymeleafapp.Models;
//
//import javax.persistence.*;
//
//@Entity
//public class Teaching {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//      @JsonIgnore                               //PERSIST                 //LAZY
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    private Teacher teacher;
//
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    private Course course;
//
//    public Teaching() {
//        super();
//    }
//
//    public Teaching(int id, Teacher teacher, Course course) {
//        super();
//        this.id = id;
//        this.teacher = teacher;
//        this.course = course;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
//
//}
