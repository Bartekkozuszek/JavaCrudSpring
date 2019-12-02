//package com.thymeleaf.thymeleafapp.Models;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Course {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    public Integer Id;
//    @NotNull
//    public String name;
//    @NotNull
//    public String updatedBy;
//
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private String updatedOn;
//
//    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    private Set<Teaching> teachers = new HashSet<Teaching>();
//
//    public Course() {super();}
//
//    public Course(String name, String updatedBy, String updatedOn) {
//        this.name = name;
//        this.updatedBy = updatedBy;
//        this.updatedOn = updatedOn;
//    }
//
//    public Course(String name, String updatedBy) {
//        this.name = name;
//        this.updatedBy = updatedBy;
//    }
//
//    public Integer getId() {
//        return Id;
//    }
//
//    public void setId(Integer id) {
//        this.Id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getUpdatedBy() {
//        return updatedBy;
//    }
//
//    public void setUpdatedBy(String updatedBy) {
//        this.updatedBy = updatedBy;
//    }
//
//    public String getUpdatedOn() {
//        return updatedOn;
//    }
//
//    public void setUpdatedOn(){
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date(System.currentTimeMillis());
//        this.updatedOn = formatter.format(date);
//    }
//
//    public void setUpdatedOn(String updatedOn) {
//        this.updatedOn = updatedOn;
//    }
//
//}
