package com.Uday.jobListing.Controller;

import com.Uday.jobListing.Repo.jobRepo;
import com.Uday.jobListing.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class jobController {
    @Autowired
    private jobRepo repo;

    @RequestMapping("/")
    public String job(){
        return "index.jsp";
}
    @PostMapping("post")
    public List<Job> prof(String profile, String desc, Integer exp, String[] techs) {
        int experience = (exp != null) ? exp : 0;

        Job job = new Job(profile, desc, experience, techs);
        repo.save(job);
        return List.of(job);
    }

    @GetMapping("/job/{id}")
    public Optional<Job> getJobById(@PathVariable String id) {
        Optional<Job> job = repo.findById(id);
        return job;
    }

    @GetMapping("/jobsByTechnology/{tech}")
    public List<Job> getJobsByTechnology(@PathVariable String tech) {
        List<Job> jobsByTechnology = repo.findByTechs(tech);
        return jobsByTechnology;
    }

    @GetMapping("/jobsByExperience/{exp}")
    public List<Job> getJobsByExperience(@PathVariable int exp) {
        ArrayList<Job> jobsByExperience = new ArrayList<>();
        List<Job> k = repo.findAll();
        for(Job h: k){
            if(h.getExp() >= exp){
                jobsByExperience.add(h);
            }
        }
        return jobsByExperience;
    }

    @DeleteMapping("del")
    public Optional del(String profile){
        Optional<Job> j = repo.findById(profile);
        repo.deleteById(profile);
        return j;
    }

    @GetMapping("alljobs")
    public List<Job> alljobs(){
    List<Job> k = repo.findAll();
//        System.out.println(k);
    return k;
    }
}
