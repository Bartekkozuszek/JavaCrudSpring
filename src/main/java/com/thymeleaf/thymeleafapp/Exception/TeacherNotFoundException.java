package com.thymeleaf.thymeleafapp.Exception;

public class TeacherNotFoundException extends Exception {
    public TeacherNotFoundException() {
        super("Could not find Teacher");
    }
    public TeacherNotFoundException(int id) {
        super("Could not find Teacher "+ id);
    }
}
