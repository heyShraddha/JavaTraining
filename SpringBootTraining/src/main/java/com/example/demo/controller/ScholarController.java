package com.example.demo.controller;

import com.example.demo.model.MinimisedModel;
import com.example.demo.model.SampleModel;
import com.example.demo.repository.ScholarRepo;
import com.example.demo.services.ScholarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ScholarController {

    private ScholarService scholarService;

    @Autowired
    public ScholarController(ScholarService scholarService){ this.scholarService = scholarService; }

    @GetMapping("scholars")
    public List<MinimisedModel> getAllScholars(){
        return scholarService.getAllScholars();
    }

    @PostMapping("scholar")
    public void addScholar(@RequestBody SampleModel scholar){
        scholarService.addScholar(scholar);
    }

    @GetMapping("scholar")
    public SampleModel getScholar(@RequestParam String id){
        return scholarService.getScholar(id);
    }
}
