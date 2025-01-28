package com.example.services;

import org.springframework.stereotype.Component;

@Component
public class UserDepartmentService {

    public String getDepartment() {
        System.out.println("called from normal java class");
        return "IT";
    }
}
