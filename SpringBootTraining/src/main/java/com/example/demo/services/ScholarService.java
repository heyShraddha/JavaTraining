package com.example.demo.services;
import com.example.demo.model.SampleModel;
import com.example.demo.model.MinimisedModel;
import com.example.demo.repository.ScholarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScholarService {
    @Autowired
    ScholarRepo scholarRepo;

    public List<MinimisedModel> getAllScholars(){
        List<SampleModel> sampleModel = null;
        try {
            sampleModel = scholarRepo.getAllScholars();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<MinimisedModel> minimisedModel = new ArrayList<>();

        for(SampleModel scholar : sampleModel){
            MinimisedModel scholar_mini = new MinimisedModel();
            scholar_mini.setName(scholar.getName());
            scholar_mini.setiNumber(scholar.getiNumber());
            scholar_mini.setBatch(scholar.getJoiningYear() +" "+scholar.getCourseDuration());
            minimisedModel.add(scholar_mini);

        }
        return minimisedModel;

    }
    public SampleModel getScholar(String iNumber){
        return scholarRepo.getScholar(iNumber);
    }
    public void addScholar(SampleModel Scholar){
        scholarRepo.addScholar(Scholar);
    }
}
