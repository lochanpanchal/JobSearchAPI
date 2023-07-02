package com.lochan.JobSearch.controller;

import com.lochan.JobSearch.entity.Job;
import com.lochan.JobSearch.entity.Type;
import com.lochan.JobSearch.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class JobController {

    @Autowired
    JobService jobService;

    //create add a perticular job
    @PostMapping("job")
    public String addJob( @Valid @RequestBody Job job){
         return jobService.addJob(job);
    }

    // CRUD Operations using Crud Repository

    //read get all the list of jobs
    @GetMapping("jobs")
    public Iterable<Job> getAllJobs(){
        return jobService.getAllJobs();
    }


    //update job type based on Id
    @PutMapping("job/{id}/{type}")
    public String updateJobById(@Valid  @PathVariable Long id,@Valid @PathVariable Type type){
        return jobService.updateJobBYId(id,type);
    }


    //delete
    @DeleteMapping("/id/{id}")
    public String deleteJobById(@PathVariable Long id){
         return jobService.deleteJobById(id);
    }

    //-------------

    // using custom finders

    @GetMapping("jobs/title/{title}")
    public List<Job> getJobsByTitle(@PathVariable String title){
        return jobService.getJobsByTitle(title);
    }

    @GetMapping("jobs/description/{description}")
    public List<Job> getJobsByDescription(@PathVariable String description){
        return jobService.getJobsByDescription(description);
    }

    


    //-------------
    // used @Query for getting table

    @GetMapping("Quaryjobs")
    public List<Job> getAllJobsUsingQuary(){
        return jobService.getAllJobsUsingQuary();
    }


}
