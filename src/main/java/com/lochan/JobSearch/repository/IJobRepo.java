package com.lochan.JobSearch.repository;


import com.lochan.JobSearch.entity.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job,Long> {

    //custom finder method to search jobs by title
    List<Job> findByTitle(String title);

    //custom finder method to search jobs by description
    List<Job> findByDescription(String description);



    @Query("SELECT j FROM Job j ")
    public List<Job> getAllJobs();

}
