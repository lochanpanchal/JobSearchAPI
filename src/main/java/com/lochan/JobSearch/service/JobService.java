package com.lochan.JobSearch.service;

import com.lochan.JobSearch.entity.Job;
import com.lochan.JobSearch.entity.Type;
import com.lochan.JobSearch.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    IJobRepo iJobRepo;

    public Iterable<Job> getAllJobs() {
        return iJobRepo.findAll();
    }

    public String addJob(Job job) {
        iJobRepo.save(job);
        return "job added";
    }

    public String updateJobBYId(Long id, Type type) {
         Optional<Job> myJobOpt = iJobRepo.findById(id);
         Job myjob = null;
         if(myJobOpt.isPresent()){
             myjob = myJobOpt.get();
         }
         else{
             return "Id not Found!!!";
         }
         myjob.setJobType(type);
         iJobRepo.save(myjob);
         return "room type updated";

    }

    public String deleteJobById(Long id) {
        iJobRepo.deleteById(id);
        return "job deleted successfully of id " + id;
    }

    public List<Job> getJobsByTitle(String title) {
        return iJobRepo.findByTitle(title);
    }

    public List<Job> getJobsByDescription(String description) {
        return iJobRepo.findByDescription(description);
    }

    public List<Job> getAllJobsUsingQuary() {
        return iJobRepo.getAllJobs();
    }
}
