package com.mikevane.covid.controller;


import com.mikevane.covid.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepartController {
    private DepartService departService;

    @Autowired
    public void setDepartService(DepartService departService) {
        this.departService = departService;
    }

    @GetMapping("/findAll")
    private List<String>  findAll(){
       return departService.getAll();
    }
}
