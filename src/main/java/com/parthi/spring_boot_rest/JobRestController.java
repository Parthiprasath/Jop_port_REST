package com.parthi.spring_boot_rest;

import com.parthi.spring_boot_rest.model.JobPost;
import com.parthi.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //instead of ResponseBody
@CrossOrigin(origins ="http://localhost:5173")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    //@ResponseBody //don't search for view name
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId){
        return service.getJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyWord(@PathVariable("keyword") String keyword){

        return service.search(keyword);
    }


    @PostMapping("jobPost")//same name but different url we are posting values
    public JobPost addJob(@RequestBody JobPost jobpost){
        service.addJob(jobpost);
        return service.getJob(jobpost.getPostId());
    }

    @PutMapping("jobPost")//same name but different url we are posting values
    public JobPost updateJob(@RequestBody JobPost jobpost){
        service.updateJob(jobpost);
        return service.getJob(jobpost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
         service.deleteJob(postId);

         return "Deleted";
    }

    @GetMapping("loads")
    public String loadData(){

        service.load();

        return "success";
    }

}
