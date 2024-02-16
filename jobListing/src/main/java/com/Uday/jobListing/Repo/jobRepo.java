package com.Uday.jobListing.Repo;

import com.Uday.jobListing.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface jobRepo extends MongoRepository<Job, String> {
    List<Job> findByTechs(String tech);
}
